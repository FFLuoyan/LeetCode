package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一所学校里有一些班级,每个班级里有一些学生,现在每个班都会进行一场期末考试
 * 给定一个二维数组 classes,其中 classes[i] = [passI, totalI]
 * 表示提前知道了第 i 个班级总共有 totalI 个学生,其中只有 passI 个学生可以通过考试
 * 给定一个整数 extraStudents,表示额外有 extraStudents 个聪明的学生,他们一定能通过任何班级的期末考
 * 需要给这 extraStudents 个学生每人都安排一个班级,使得所有班级的平均通过率最大
 * 一个班级的通过率等于这个班级通过考试的学生人数除以这个班级的总人数
 * 平均通过率是所有班级的通过率之和除以班级数目
 * 请返回在安排这 extraStudents 个学生去对应班级后的最大平均通过率
 * 与标准答案误差范围在 10^-5 以内的结果都会视为正确结果
 *
 * 1 <= classes.length <= 10^5
 * classes[i].length == 2
 * 1 <= passI <= totalI <= 10^5
 * 1 <= extraStudents <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/20
 */
public class Z7MaxAvg {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<long[]> values = new PriorityQueue<>((a, b) -> Long.compare(a[2] * b[0], b[2] * a[0]));
        double result = 0;
        for (int[] value : classes) {
            if (value[0] == value[1]) {
                result += 1;
            } else {
                values.add(new long[]{value[1] - value[0], value[1], value[1] * (1L + value[1])});
            }
        }
        if (values.size() == 0) {
            return 1;
        }
        if (values.size() == 1) {
            long[] v = values.poll();
            return (((double) v[1] - v[0] + extraStudents) /  (v[1] + extraStudents) + result) / classes.length;
        }
        while (--extraStudents >= 0) {
            long[] value = values.poll();
            value[2] = value[2] + value[1] + ++value[1] + 1;
            values.add(value);
        }
        for (long[] value : values) {
            result += ((double) value[1] - value[0]) / value[1];
        }
        return result / classes.length;
    }

    public static void main(String[] args) {
        Z7MaxAvg test = new Z7MaxAvg();
        // 0.78333
        System.out.println(test.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        // 0.61455
        System.out.println(test.maxAverageRatio(new int[][]{{13609, 17094}, {24079, 89827}}, 22159));
    }

}
