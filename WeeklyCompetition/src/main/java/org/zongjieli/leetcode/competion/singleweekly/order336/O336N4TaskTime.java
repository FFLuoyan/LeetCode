package org.zongjieli.leetcode.competion.singleweekly.order336;

import java.util.Arrays;

/**
 * 有一台电脑,可以同时运行无数个任务
 * 给定一个二维整数数组 tasks
 * 其中 tasks[i] = [startI, endI, durationI]
 * 表示第 i 个任务需要在闭区间时间段 [startI, endI] 内运行 durationI 个整数时间点(但不需要连续)
 * 当电脑需要运行任务时,可以打开电脑,如果空闲时,可以将电脑关闭
 * 请返回完成所有任务的情况下,电脑最少需要运行多少秒
 *
 * 1 <= tasks.length <= 2000
 * tasks[i].length == 3
 * 1 <= startI, endI <= 2000
 * 1 <= durationI <= endI - startI + 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/12
 */
public class O336N4TaskTime {

    public int findMinimumTime(int[][] tasks) {
        int[] result = new int[2001];
        Arrays.sort(tasks, (a, b) -> a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : Integer.compare(a[0], b[0]));
        int max = 0;
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2], re = result[end], rs;
            if (re == 0) {
                for (int i = end; i >= 0 && result[i] == 0; i--) {
                    result[i] = max;
                }
            }
            rs = result[start - 1];
            if ((duration -= (max - rs)) > 0) {
                max += duration;
                while (duration > 0) {
                    int durationDiff = result[end] - result[end - 1];
                    result[end--] += duration;
                    duration -= (durationDiff ^ 1);
                }
            }
        }
        return result[tasks[tasks.length - 1][1]];
    }

    public static void main(String[] args) {
        O336N4TaskTime test = new O336N4TaskTime();
        // 4
        System.out.println(test.findMinimumTime(new int[][]{{1, 3, 2}, {2, 5, 3}, {5, 6, 2}}));
        // 1
        System.out.println(test.findMinimumTime(new int[][]{{1, 1, 1}}));
        // 68
        System.out.println(test.findMinimumTime(new int[][]{{68, 129, 2}, {58, 86, 9}, {112, 142, 10}, {106, 108, 1}, {48, 48, 1}, {116, 143, 2}, {28, 43, 5}, {1, 1, 1}, {75, 83, 3}, {104, 136, 10}, {11, 11, 1}, {60, 63, 1}, {73, 111, 8}, {57, 57, 1}, {117, 119, 3}, {25, 38, 2}, {20, 21, 1}, {78, 80, 2}, {17, 17, 1}, {28, 28, 1}, {77, 117, 3}, {76, 109, 4}, {61, 61, 1}, {84, 92, 5}, {18, 41, 4}, {47, 55, 9}, {74, 132, 6}, {53, 87, 3}, {102, 131, 7}, {26, 26, 1}, {66, 68, 3}, {59, 73, 1}, {22, 30, 9}, {9, 13, 2}, {31, 35, 2}, {90, 91, 2}, {72, 72, 1}, {62, 84, 8}, {105, 106, 2}, {3, 3, 1}, {32, 32, 1}, {99, 103, 4}, {45, 52, 4}, {108, 116, 3}, {91, 123, 8}, {89, 114, 4}, {94, 130, 7}, {103, 104, 2}, {14, 17, 4}, {63, 66, 4}, {98, 112, 7}, {101, 140, 9}, {58, 58, 1}, {109, 145, 1}, {8, 15, 8}, {4, 16, 5}, {115, 141, 1}, {40, 50, 4}, {118, 118, 1}, {81, 120, 7}}));
    }

}
