package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import java.util.Arrays;

/**
 * 现在总共有 numCourses 门课需要选,记为 0 到 numCourses - 1
 * 给定一个数组 prerequisites,其中 prerequisites[i] = [ai, bi]
 * 表示在选修课程 ai 前必须先选修 bi
 * 例如,想要学习课程 0,需要先完成课程 1,用一个匹配来表示: [0,1]
 * 返回为了学完所有课程所安排的学习顺序
 * 可能会有多个正确的顺序,只要返回任意一种就可以了
 * 如果不可能完成所有课程,返回一个空数组
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/10
 */
public class Z7Course {

    int index = 0;
    int[] fatherLastIndex, before, result;
    int[][] pre;
    Boolean[] learned;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        fatherLastIndex = new int[numCourses];
        before = new int[prerequisites.length];
        Arrays.fill(before, -1);
        Arrays.fill(fatherLastIndex, -1);
        learned = new Boolean[numCourses];
        pre = prerequisites;
        for (int i = 0; i < prerequisites.length; i++) {
            before[i] = fatherLastIndex[prerequisites[i][0]];
            fatherLastIndex[prerequisites[i][0]] = i;
        }
        for (int i = 0 ; i < numCourses ; i++) {
            if (!canLearn(i)) {
                return new int[0];
            }
        }
        return result;
    }

    public boolean canLearn(int course) {
        Boolean learn = learned[course];
        if (learn != null) {
            return learn;
        }
        learned[course] = Boolean.FALSE;
        int fatherIndex = fatherLastIndex[course];
        while (fatherIndex != -1) {
            int father = pre[fatherIndex][1];
            if (!canLearn(father)) {
                return Boolean.FALSE;
            }
            fatherIndex = before[fatherIndex];
        }
        result[index++] = course;
        return learned[course] = Boolean.TRUE;
    }

}
