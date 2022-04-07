package org.zongjieli.leetcode.question.daily.year2022.month4.week2;
/**
 * 给定两个整数 left 和 right
 * 在闭区间 [left, right] 范围内
 * 统计并返回计算置位位数为质数的整数个数
 * 计算置位位数就是二进制表示中 1 的个数
 * 例如,21 的二进制表示 10101 有 3 个计算置位
 *
 * 1 <= left <= right <= 10^6
 * 0 <= right - left <= 10^4
 *
 * @author   Li.zongjie
 * @date     2022/4/7
 * @version  1.0
 */
public class Z2PrimeNumberCount {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left ; i <= right ; i++) {
            int w = Integer.bitCount(i);
            if (w == 2 || w == 3 || w == 5 || w == 7 || w == 11 || w == 13 || w == 17 || w == 19 || w == 23 || w == 29 || w == 31) {
                count++;
            }
        }
        return count;
    }
}
