package org.zongjieli.leetcode.competion.doubleweekly.order99;

/**
 * 给定一个正整数 num,请将它分割成两个非负整数 num1 和 num2,满足:
 *  num1 和 num2 直接连起来,得到 num 各数位的一个排列
 *  换句话说,num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数
 *  num1 和 num2 可以包含前导 0
 * 请返回 num1 和 num2 可以得到的和的最小值
 *
 * 注意:
 * num 保证没有前导 0
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同
 *
 * 10 <= num <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/4
 */
public class O99N1MinSplit {
    public int splitNum(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        int a = 0, b = 0, start = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1 ; j <= count[i] ; j++) {
                if (start == 0) {
                    a = a * 10 + i;
                    start = 1;
                } else {
                    b = b * 10 + i;
                    start = 0;
                }
            }
        }
        return a + b;
    }
}
