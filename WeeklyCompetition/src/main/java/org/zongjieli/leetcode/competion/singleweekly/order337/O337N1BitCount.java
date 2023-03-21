package org.zongjieli.leetcode.competion.singleweekly.order337;

/**
 * 给定一个正整数 n
 * 用 even 表示在 n 的二进制形式(下标从 0 开始)中值为 1 的偶数下标的个数
 * 用 odd 表示在 n 的二进制形式(下标从 0 开始)中值为 1 的奇数下标的个数
 * 返回整数数组 answer,其中 answer = [even, odd]
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/19
 */
public class O337N1BitCount {

    public int[] evenOddBit(int n) {
        int[] result = new int[]{0, 0};
        int current = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                result[current]++;
            }
            n /= 2;
            current ^= 1;
        }
        return result;
    }
}
