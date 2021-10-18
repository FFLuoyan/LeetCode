package org.zongjieli.leetcode.question.daily.year2021.month10.week4;
/**
 * 给定一个正整数 num,输出它的补数,补数是对该数的二进制表示取反
 *
 * @author   Li.zongjie
 * @date     2021/10/18
 * @version  1.0
 */
public class Z1ComplementNumber {
    public int findComplement(int num) {
        int v = 1;
        while (num - v >= 0){
            num = num ^ v;
            v <<= 1;
        }
        return num;
    }
}
