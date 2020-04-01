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

    public int reverseBitsByInteger(int n){
        return Integer.reverse(n);
        //        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        //        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        //        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        // 代码解析,第一步的操作是将 奇数位与偶数位交换
        // 然后在 2 位 2 位 的进行交换,接着 4 位
        // 至此,每一个 Byte (8位) 均颠倒
        // 然后执行 reverseByByte() 原理类似
    }

}
