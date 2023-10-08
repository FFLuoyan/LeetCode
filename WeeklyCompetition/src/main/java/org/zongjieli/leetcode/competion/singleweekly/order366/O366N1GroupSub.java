package org.zongjieli.leetcode.competion.singleweekly.order366;

/**
 * 给定两个正整数 n 和 m
 * 现定义两个整数 num1 和 num2,如下所示:
 *  num1: 范围 [1, n] 内所有无法被 m 整除的整数之和
 *  num2: 范围 [1, n] 内所有能够被 m 整除的整数之和
 * 返回整数 num1 - num2
 *
 * 1 <= n, m <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/8
 */
public class O366N1GroupSub {

    public int differenceOfSums(int n, int m) {
        int num2 = n / m;
        return (1 + n) * n / 2 - (1 + num2) * m * num2;
    }

    public static void main(String[] args) {
        O366N1GroupSub test = new O366N1GroupSub();
        // 19
        System.out.println(test.differenceOfSums(10, 3));
    }
}
