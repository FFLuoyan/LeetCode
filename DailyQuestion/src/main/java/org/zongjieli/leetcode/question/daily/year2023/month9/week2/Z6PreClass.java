package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个学期必须选修 numCourses 门课程,记为 0 到 numCourses - 1
 * 在选修某些课程之前需要一些先修课程,先修课程按数组 prerequisites 给出
 * 其中 prerequisites[i] = [ai, bi],表示如果要学习课程 ai 则必须先学习课程 bi
 * 例如,先修课程对 [0, 1] 表示: 想要学习课程 0,需要先完成课程 1
 * 请判断是否可能完成所有课程的学习,如果可以,返回 true,否则返回 false
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/9
 */
public class Z6PreClass {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] fathers = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (fathers[prerequisite[0]] == null) {
                fathers[prerequisite[0]] = new ArrayList<>();
            }
            fathers[prerequisite[0]].add(prerequisite[1]);
        }
        int[] canFinish = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++) {
            if (!canFinish(i, canFinish, fathers)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int course, int[] canFinish, List<Integer>[] fathers) {
        if (canFinish[course] == 1) {
            return true;
        }
        if (canFinish[course] == 2) {
            return false;
        }
        if (fathers[course] == null) {
            canFinish[course] = 1;
            return true;
        }
        canFinish[course] = 2;
        for (Integer father : fathers[course]) {
            if (!canFinish(father, canFinish, fathers)) {
                return false;
            }
        }
        canFinish[course] = 1;
        return true;
    }

    public static void main(String[] args) {
        Z6PreClass test = new Z6PreClass();
        // ture
        System.out.println(test.canFinish(2, new int[][]{{1, 0}}));
        // false
        System.out.println(test.canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
    }

}
