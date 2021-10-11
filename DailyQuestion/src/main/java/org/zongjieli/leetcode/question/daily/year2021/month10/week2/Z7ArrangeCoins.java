package org.zongjieli.leetcode.question.daily.year2021.month10.week2;
/**
 * 总共有 n 枚硬币,并计划将它们按阶梯状排列
 * 对于一个由 k 行组成的阶梯,其第 i 行必须正好有 i 枚硬币
 * 阶梯的最后一行可能是不完整的
 *
 * 给定一个数字 n,计算并返回可形成完整阶梯行的总行数
 *
 * @author   Li.zongjie
 * @date     2021/10/11
 * @version  1.0
 */
public class Z7ArrangeCoins {
    public int arrangeCoins(int n) {
        /*
            设可以排列成 x 行,有 x * (x + 1) / 2 = n
            x 的解的最大正整数即为答案
            x=(√(8n+1)-1)/2
         */
        return (int) ((Math.sqrt(8L * n + 1) - 1) / 2);
    }

    public static void main(String[] args) {
        Z7ArrangeCoins test = new Z7ArrangeCoins();
        System.out.println(test.arrangeCoins(1804289383));
    }
}
