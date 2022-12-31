package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

import java.util.Arrays;

/**
 * 一个房间里有 n 个座位和 n 名学生,房间用一个数轴表示
 * 给定一个长度为 n 的数组 seats,其中 seats[i] 是第 i 个座位的位置
 * 同时给定一个长度为 n 的数组 students,其中 students[j] 是第 j 位学生的位置
 * 可以执行以下操作任意次:
 *  增加或者减少第 i 位学生的位置,每次变化量为 1(也就是将第 i 位学生从位置 x 移动到 x + 1 或者 x - 1)
 * 请返回使所有学生都有座位坐的最少移动次数,并确保没有两位学生的座位相同
 *
 * 请注意,初始时有可能有多个座位或者多位学生在同一位置
 *
 * n == seats.length == students.length
 * 1 <= n <= 100
 * 1 <= seats[i], students[j] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/31
 */
public class Z6MoveSeat {

    public int minMovesToSeat(int[] seats, int[] students) {
        int[] seatPosition = new int[101];
        int[] studentPosition = new int[101];
        for (int i = 0; i < seats.length; i++) {
            seatPosition[seats[i]]++;
            studentPosition[students[i]]++;
        }
        seatPosition[0] = 1;
        studentPosition[0] = 1;
        int result = 0, seat = 100, student = 100;
        while (seat > 0 && student > 0) {
            while (seatPosition[seat] == 0) {
                seat--;
            }

            while (studentPosition[student] == 0) {
                student--;
            }
            result += Math.abs(seat - student);
            seatPosition[seat]--;
            studentPosition[student]--;
        }
        return result;
    }

    public static void main(String[] args) {
        Z6MoveSeat test = new Z6MoveSeat();
        // 4
        System.out.println(test.minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 2, 3, 6}));
    }
}
