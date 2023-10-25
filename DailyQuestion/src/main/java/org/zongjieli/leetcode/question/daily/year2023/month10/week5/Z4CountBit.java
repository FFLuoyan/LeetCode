package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 给定一个整数 num,返回 num 中能整除 num 的数位的数目
 * 如果满足 nums % val == 0,则认为整数 val 可以整除 nums
 *
 * 1 <= num <= 10^9
 * num 的数位中不含 0
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/26
 */
public class Z4CountBit {

    public int countDigits(int num) {
        int remain = num, result = 0;
        while (remain > 0) {
            if (num % (remain % 10) == 0) {
                result++;
            }
            remain /= 10;
        }
        return result;
    }

}
