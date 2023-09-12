package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

import java.util.*;

/**
 * 总共需要上 numCourses 门课,课程编号依次为 0 到 numCourses - 1
 * 给定数组 prerequisite,其中 prerequisites[i] = [ai, bi] 表示如果想选 bi 课程必须先选 ai 课程
 * 有的课会有直接的先修课程,比如如果想上课程 1,必须先上课程 0,那么会以 [0,1] 数对的形式给出先修课程数对
 * 先决条件也可以是间接的,如果课程 a 是课程 b 的先决条件,课程 b 是课程 c 的先决条件,那么课程 a 就是课程 c 的先决条件
 * 给定数组 queries,其中 queries[j] = [uj, vj],对于第 j 个查询,应该回答课程 uj 是否是课程 vj 的先决条件
 * 返回一个布尔数组 answer,其中 answer[j] 是第 j 个查询的答案
 *
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 每一对 [ai, bi] 都不同
 * 先修课程图中没有环
 * 1 <= queries.length <= 10^4
 * 0 <= ui, vi <= n - 1
 * ui != vi
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/12
 */
public class Z2CourseBefore {

    Set<Integer>[] fathers;

    boolean[] visited;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        fathers = new Set[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            fathers[prerequisite[1]].add(prerequisite[0]);
        }
        for (int i = 0 ; i < numCourses ; i++) {
            addFather(i);
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(fathers[query[1]].contains(query[0]));
        }
        return result;
    }

    public void addFather(int course) {
        if (visited[course]) {
            return;
        }
        Set<Integer> newFather = new HashSet<>(fathers[course]);
        for (Integer father : fathers[course]) {
            addFather(father);
            newFather.addAll(fathers[father]);
        }
        fathers[course] = newFather;
        visited[course] = true;
    }

    public static void main(String[] args) {
        Z2CourseBefore test = new Z2CourseBefore();
        // [false, false]
        System.out.println(test.checkIfPrerequisite(2, new int[][]{}, new int[][]{{1, 0}, {0, 1}}));
        // [true, true]
        System.out.println(test.checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}));
    }

}
