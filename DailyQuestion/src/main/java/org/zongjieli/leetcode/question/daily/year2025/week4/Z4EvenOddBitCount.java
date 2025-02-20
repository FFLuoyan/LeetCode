package org.zongjieli.leetcode.question.daily.year2025.week4;

/**
 * 给定一个正整数 n
 * 用 even 表示在 n 的二进制形式(下标从 0 开始)中值为 1 的偶数下标的个数
 * 用 odd 表示在 n 的二进制形式(下标从 0 开始)中值为 1 的奇数下标的个数
 * 请注意,在数字的二进制表示中,位下标的顺序从右到左
 * 返回整数数组 answer,其中 answer = [even, odd]
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/20
 */
public class Z4EvenOddBitCount {

    public int[] evenOddBit(int n) {
        int[] result = new int[]{0, 0};
        int addIndex = 0, valueCheck;
        while (n > 0) {
            valueCheck = n & 1;
            n >>= 1;
            if (valueCheck == 1) {
                result[addIndex]++;
            }
            addIndex ^= 1;
        }
        return result;
    }

}
