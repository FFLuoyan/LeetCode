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
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = seats.length - 1 ; i >= 0 ; i--) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }

}
