package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

/**
 * 给定一个正整数 num,请将它分割成两个非负整数 num1 和 num2,满足:
 *  num1 和 num2 直接连起来,得到 num 各数位的一个排列
 *  换句话说,num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数
 *  num1 和 num2 可以包含前导 0
 * 请返回 num1 和 num2 可以得到的和的最小值
 * 注意:
 *  num 保证没有前导 0
 *  num1 和 num2 中数位顺序可以与 num 中数位顺序不同
 *
 * 10 <= num <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/9
 */
public class Z1MinSum {

    public int splitNum(int num) {
        int[] count = new int[10];
        int bitCount = 0, result = 0;
        while (num != 0) {
            count[num % 10]++;
            bitCount++;
            num /= 10;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- != 0) {
                if (--bitCount % 2 == 1) {
                    result *= 10;
                }
                result += i;
            }
        }
        return result;
    }

}
