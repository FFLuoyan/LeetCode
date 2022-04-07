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
        int result = 0;
        for (int i = left ; i <= right ; i++) {
            // 665772 = 10100010100010101100
            // 从低至高第 i 位表示第 i 位为质数,质数为 2, 3, 5, 7, 11, 13, 17, 19
            if ((665772 >> Integer.bitCount(i) & 1) == 1) {
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
