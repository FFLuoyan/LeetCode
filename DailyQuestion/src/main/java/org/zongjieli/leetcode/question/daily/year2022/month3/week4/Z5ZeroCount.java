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
        if (n < 5) {
            return 0;
        }
        int count = 1;
        int base = 5;
        while (n >= base) {
            count = 5 * count + 1;
            base *= 5;
        }
        base /= 5;
        count = (count - 1) / 5;
        return (n / base) * count + trailingZeroes(n % base);
    }

    public static void main(String[] args) {
        Z5ZeroCount test = new Z5ZeroCount();
        // 6
        System.out.println(test.trailingZeroes(25));
    }
}
