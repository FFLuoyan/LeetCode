package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

/**
 * 给定一个数组 seats 表示一排座位
 * 其中 seats[i] = 1 代表有人坐在第 i 个座位上
 * seats[i] = 0 代表座位 i 上是空的(下标从 0 开始)
 * 至少有一个空座位,且至少有一人已经坐在座位上
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上
 * 返回他到离他最近的人的最大距离
 *
 * 2 <= seats.length <= 2 * 10^4
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/22
 */
public class Z2MaxDistance {

    public int maxDistToClosest(int[] seats) {
        int start = 0, end = seats.length - 1;
        while (seats[start] == 0) {
            start++;
        }
        while (seats[end] == 0) {
            end--;
        }
        int result = Math.max(start, seats.length - 1 - end), temp = 0;
        while (start <= end) {
            if (seats[start++] == 0) {
                temp++;
            } else {
                result = Math.max(result, (temp + 1) / 2);
                temp = 0;
            }
        }
        return result;
    }

}
