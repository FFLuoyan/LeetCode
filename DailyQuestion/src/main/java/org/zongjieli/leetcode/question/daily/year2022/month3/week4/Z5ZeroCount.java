package org.zongjieli.leetcode.question.daily.year2022.month3.week4;
/**
 * 给定一个整数 n,返回 n! 结果中尾随零的数量
 *
 * 0 <= n <= 10^4
 *
 * @author   Li.zongjie
 * @date     2022/3/25
 * @version  1.0
 */
public class Z5ZeroCount {

    public int trailingZeroes(int n) {
        if (n < 25) {
            return n / 5;
        }
        if (n < 125) {
            return (n / 25) * 6 + trailingZeroes(n % 25);
        }
        if (n < 625) {
            return (n / 125) * 31 + trailingZeroes(n % 125);
        }
        if (n < 3125) {
            return (n / 625) * 156 + trailingZeroes(n % 625);
        }
        return (n / 3125) * 781 + trailingZeroes(n % 3125);
    }
}
