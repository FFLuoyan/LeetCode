package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 这里有 n 门不同的在线课程,按从 1 到 n 编号
 * 给定一个数组 courses,其中 courses[i] = [durationI, lastDayI]
 * 表示第 i 门课将会持续上 durationI 天课,并且必须在不晚于 lastDayI 的时候完成
 * 学期从第 1 天开始,且不能同时修读两门及两门以上的课程
 * 返回最多可以修读的课程数目
 *
 * 1 <= courses.length <= 10^4
 * 1 <= durationI, lastDayI <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/11
 */
public class Z1CourseCount {

    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> learned = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : a[1] > b[1] ? 1 : -1);
        int sum = 0;
        for (int[] course : courses) {
            if (course[0] + sum <= course[1]) {
                learned.add(course[0]);
                sum += course[0];
            } else if (!learned.isEmpty()) {
                int max = learned.poll();
                if (max < course[0]) {
                    learned.add(max);
                } else {
                    learned.add(course[0]);
                    sum = sum - max + course[0];
                }
            }
        }
        return learned.size();
    }

    public static void main(String[] args) {
        Z1CourseCount test = new Z1CourseCount();
        // 2
        System.out.println(test.scheduleCourse(new int[][]{{1, 9}, {1, 9}}));
    }

}
