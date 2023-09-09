package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import java.util.Arrays;

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
        int length = prerequisites.length, a;
        int[] fatherIndex = new int[numCourses], indexBefore = new int[length];
        Boolean[] canFinish = new Boolean[numCourses];
        Arrays.fill(fatherIndex, -1);
        Arrays.fill(indexBefore, -1);
        for (int i = 0; i < length; i++) {
            a = prerequisites[i][0];
            indexBefore[i] = fatherIndex[a];
            fatherIndex[a] = i;
        }
        for (int i = 0 ; i < numCourses ; i++) {
            if (!canFinish(i, fatherIndex, indexBefore, canFinish, prerequisites)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int course, int[] fatherIndex, int[] indexBefore, Boolean[] canFinish, int[][] prerequisites) {
        if (canFinish[course] != null) {
            return canFinish[course];
        }
        int index = fatherIndex[course];
        while (index != -1) {
            canFinish[course] = Boolean.FALSE;
            if (!canFinish(prerequisites[index][1], fatherIndex, indexBefore, canFinish, prerequisites)) {
                return false;
            }
            index = indexBefore[index];
        }
        return canFinish[course] = Boolean.TRUE;
    }

    public static void main(String[] args) {
        Z6PreClass test = new Z6PreClass();
        // ture
        System.out.println(test.canFinish(2, new int[][]{{1, 0}}));
        // false
        System.out.println(test.canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
    }

}
