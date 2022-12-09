package org.zongjieli.leetcode.question.daily.year2022.month12.week2;

/**
 * 给定一个整数 n,如果可以将 n 表示成若干个不同的三的幂之和,请返回 true,否则返回 false
 * 对于一个整数 y,如果存在整数 x 满足 y == 3x,我们称这个整数 y 是三的幂
 *
 * 1 <= n <= 10^7
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/9
 */
public class Z5ThreePowerSum {

    public boolean checkPowersOfThree(int n) {
        int base = 14348907;
        while (n - base < base) {
            n = n % base;
            base /= 3;
        }
        return base == 0;
    }

    public static void main(String[] args) {
        Z5ThreePowerSum test = new Z5ThreePowerSum();
        // ture
        System.out.println(test.checkPowersOfThree(12));
    }
}
