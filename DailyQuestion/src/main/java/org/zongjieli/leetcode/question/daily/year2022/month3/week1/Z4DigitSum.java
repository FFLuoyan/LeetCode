package org.zongjieli.leetcode.question.daily.year2022.month3.week1;
/**
 * 给定一个非负整数 num,反复将各个位上的数字相加,直到结果为一位数,返回这个结果
 *
 * @author   Li.zongjie
 * @date     2022/3/3
 * @version  1.0
 */
public class Z4DigitSum {
    public int addDigits(int num) {
        /*
            对于给定的数 x,可以表达为
            a1 + a2 * (10 - 1 + 1) + a3 * (100 - 1 + 1) + ... + an * (10^n - 1 + 1)
            即 a1 + a2 + a3 + ... + an + 9 * a2 + 99 * a3 + ... + (10^n - 1) * an
            已知其其数位和 f(x) 为 a1 + a2 + a3 + ... + an
            则 x 可以表示为 f(x) + 9 * t
            当 f(x) < 9 时
                结果 g(x) = f(x) = x % 9
            当 f(x) = 9 时
                g(x) = 9
            当 f^n(x) > 9 时
                有 f^(n - 1)(x) = 9 * t + f^n(x)
                故 g(x) = f^n(x) = f^(n - 1)(x) % 9 = x % 9 (取余结果为 0 时,g(x) = 9)
         */
        return (num - 1) % 9 + 1;
    }
}
