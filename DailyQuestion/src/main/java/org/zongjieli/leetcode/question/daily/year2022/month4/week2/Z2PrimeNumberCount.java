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

    private int[] count = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5};

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left ; i <= right ; i++) {
            int w = count[i & 31] + count[(i >> 5) & 31] + count[(i >> 10) & 31] + count[(i >> 15) & 31];
            if (w == 2 || w == 3 || w == 5 || w == 7 || w == 11 || w == 13 || w == 17 || w == 19) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z2PrimeNumberCount test = new Z2PrimeNumberCount();
        // 4
        System.out.println(test.countPrimeSetBits(6, 10));
        // 117
        System.out.println(test.countPrimeSetBits(8, 200));
        // 1465
        System.out.println(test.countPrimeSetBits(289051, 294301));
    }
}
