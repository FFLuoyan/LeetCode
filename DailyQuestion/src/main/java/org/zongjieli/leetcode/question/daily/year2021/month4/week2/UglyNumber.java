package org.zongjieli.leetcode.question.daily.year2021.month4.week2;
/**
 * 给你一个整数 n,请你判断 n 是否为丑数
 * 如果是,返回 true,否则返回 false
 *
 * 丑数: 只包含质因数 2、3 或 5 的正整数
 *
 * @author   Zongjie.Li
 * @date     2021/4/10
 * @version  1.0
 */
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0){
            return false;
        }
        int[] factors = new int[]{2,3,5};
        for (int factor : factors){
            while (n % factor == 0){
                n = n / factor;
            }
        }
        return n == 1;
    }
}