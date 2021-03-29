package org.zongjieli.leetcode.question.daily.year2021.month3.week4;
/**
 * 编写一个函数,输入一个无符号整数(二进制串)
 * 返回其二进制表达式中数字位数为 '1' 的个数(汉明重量)
 *
 * @author   Zongjie.Li
 * @date     2021/3/22
 * @version  1.0
 */
public class HammingWeight {
    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
        int count = 0;
        while (n != 0){
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println( -1 >>> 1);
        System.out.println(hammingWeight.hammingWeight(-1));
    }
}
