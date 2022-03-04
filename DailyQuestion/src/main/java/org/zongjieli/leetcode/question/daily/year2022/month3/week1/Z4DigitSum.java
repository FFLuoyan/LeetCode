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
            设对于任意给定 x,其各位之和为 f(x)
            对于任意 x 可以表达为
            x = a1 + a2 * 10 + a3 * 100 + ... + an * 10^(n - 1)
              = a1 + a2 + 9 * a2 + a3 + 99 * a3 + an + (10^(n - 1) - 1) * an
              = f(x) + 9 * t
            f(x) = x - 9 * t
            即对 x 求各位之和,可以视为从 x 中减去一个数,这个数是 9 的倍数
            当这个操作重复执行,直至 f(x) 的结果为个位数,总共减去的值依旧为 9 的倍数
            所以对于结果 r(x) 来说
            有 r(x) = f^n(x) = x - 9 * q
         */
        return (num - 1) % 9 + 1;
    }
}
