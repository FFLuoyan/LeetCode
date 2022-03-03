package org.zongjieli.leetcode.question.daily.year2022.month3.week1;
/**
 * 给定一个非负整数 num,反复将各个位上的数字相加,直到结果为一位数,返回这个结果。
 *
 * @author   Li.zongjie
 * @date     2022/3/3
 * @version  1.0
 */
public class Z4DigitSum {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
