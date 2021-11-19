package org.zongjieli.leetcode.question.daily.year2021.month11.week3;
/**
 * 给定一个正整数 n,可以做如下操作
 *  如果 n 是偶数则用 n / 2替换 n
 *  如果 n 是奇数则可以用 n + 1 或 n - 1替换 n
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/11/19
 * @version  1.0
 */
public class Z5IntegerReplacement {
    public int integerReplacement(int n) {
        return integerReplacementLong(n);
    }

    public int integerReplacementLong(long n) {
        int result = 0;
        while ((n & 1) == 0){
            n >>= 1;
            result++;
        }
        if (n == 1){
            return result;
        }
        return result + 1 + Math.min(integerReplacementLong(n + 1), integerReplacementLong(n - 1));
    }
}
