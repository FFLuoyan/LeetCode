package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 给定一个正整数 num,请统计并返回小于或等于 num 且各位数字之和为偶数的正整数的数目
 * 正整数的各位数字之和是其所有位上的对应数字相加的结果
 *
 * 1 <= num <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/6
 */
public class Z5DigitSumEven {

    public int countEven(int num) {
        int single = num % 10;
        int base = (num - single) / 2 - 1;
        if ((single & 1) == 0 && isDigitEven(num)) {
            base++;
        }
        return (single + 1) / 2 + base;
    }

    public boolean isDigitEven(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return (sum & 1) == 0;
    }
}
