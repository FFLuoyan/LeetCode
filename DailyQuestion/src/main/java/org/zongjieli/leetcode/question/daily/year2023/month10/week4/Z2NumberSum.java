package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

/**
 * 给定一个正整数 n,请计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和
 * 返回一个整数,用于表示给定范围内所有满足约束条件的数字之和
 *
 * 1 <= n <= 10^3
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/17
 */
public class Z2NumberSum {

    public int sumOfMultiples(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                result += i;
            }
        }
        return result;
    }

}
