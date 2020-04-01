package org.zongjieli.leetcode.primaryalgorithm.other;

/**
 * @ClassName: ReverseBits
 * @Description: 颠倒给定的 32 位无符号整数的二进制位
 *               颠倒前后顺序,而不是二进制的位数颠倒
 * @Author: Zongjie.Li
 * @Date: 2020/3/30
 * @Version: 1.0
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int remain = 32;
        while (n != 0) {
            stringBuilder.append(n & 1);
            n >>= 1;
            remain--;
        }
        while (remain != 0) {
            stringBuilder.append(0);
            remain--;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }

}
