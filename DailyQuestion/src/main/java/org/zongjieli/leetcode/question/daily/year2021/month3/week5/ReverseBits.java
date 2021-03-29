package org.zongjieli.leetcode.question.daily.year2021.month3.week5;
/**
 * 颠倒给定的 32 位无符号整数的二进制位
 *
 * @author   Zongjie.Li
 * @date     2021/3/29
 * @version  1.0
 */
public class ReverseBits {
    public int reverseBits(int n) {
//        return Integer.reverse(n);
        int reverse = 0;
        for (int i = 0 ; i < 32 ; i++){
            reverse <<= 1;
            reverse += (n & 1);
            n >>>= 1;
        }
        return reverse;
    }
}
