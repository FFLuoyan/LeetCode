package org.zongjieli.leetcode.question.daily.year2023.month6.week3;

/**
 * 给定一个长度为 n 、下标从 1 开始的二进制字符串,所有位最开始都是 0
 * 按步翻转该二进制字符串的所有位(即,将 0 变为 1)
 * 给定一个下标从 1 开始的整数数组 flips,其中 flips[i] 表示对应下标 flips[i] 的位将会在第 i 步翻转
 * 二进制字符串前缀一致需满足:
 *  在第 i 步之后,在闭区间 [1, i] 内的所有位都是 1,而其他位都是 0
 * 返回二进制字符串在翻转过程中前缀一致的次数
 *
 * n == flips.length
 * 1 <= n <= 5 * 10^4
 * flips 是范围 [1, n] 中所有整数构成的一个排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/14
 */
public class Z3FlipAgree {

    public int numTimesAllBlue(int[] flips) {
        int result = 0, max = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                result++;
            }
        }
        return result;
    }

}
