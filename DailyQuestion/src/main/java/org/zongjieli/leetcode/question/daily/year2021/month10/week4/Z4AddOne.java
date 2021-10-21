package org.zongjieli.leetcode.question.daily.year2021.month10.week4;
/**
 * 给定一个由整数组成的非空数组所表示的非负整数,在该数的基础上加一
 * 最高位数字存放在数组的首位,数组中每个元素只存储单个数字
 * 你可以假设除了整数 0 之外,这个整数不会以零开头
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author   Li.zongjie
 * @date     2021/10/21
 * @version  1.0
 */
public class Z4AddOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length;
        while (--i >= 0){
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
