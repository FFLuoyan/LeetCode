package org.zongjieli.leetcode.question.daily.year2022.month4.week3;
/**
 * 给定一个整数 n,统计并返回各位数字都不同的数字 x 的个数,其中 0 <= x < 10^n
 *
 * 0 <= n <= 8
 *
 * @author   Li.zongjie
 * @date     2022/4/11
 * @version  1.0
 */
public class Z1CountUniqueNumber {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int nd = 9;
        int tn = n - 1;
        int base = 9;
        while (--tn >= 0) {
            nd *= base--;
        }
        return nd + countNumbersWithUniqueDigits(n - 1);
    }

    public static void main(String[] args) {
        Z1CountUniqueNumber test = new Z1CountUniqueNumber();
        // 9
        System.out.println(test.countNumbersWithUniqueDigits(1));
        // 90
        System.out.println(test.countNumbersWithUniqueDigits(2));
    }
}
