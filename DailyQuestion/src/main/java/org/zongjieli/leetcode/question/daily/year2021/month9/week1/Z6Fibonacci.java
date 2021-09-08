package org.zongjieli.leetcode.question.daily.year2021.month9.week1;
/**
 * 写一个函数,输入 n,求斐波那契(Fibonacci)数列的第 n 项(即 F(N))
 * 斐波那契数列的定义如下：
 *  F(0) = 0,F(1) = 1
 *  F(N) = F(N - 1) + F(N - 2),其中 N > 1
 *
 * 斐波那契数列由 0 和 1 开始,之后的斐波那契数就是由之前的两数相加而得出
 * 答案需要取模 1e9+7(1000000007),如计算初始结果为:1000000008,请返回 1
 *
 * 0 <= n <= 100
 *
 * @author   Li.zongjie
 * @date     2021/9/8
 * @version  1.0
 */
public class Z6Fibonacci {
    public int fib(int n) {
        if (n <= 1){
            return n;
        }
        int a = 0;
        int b = 1;
        while (n-- > 1){
            int temp = a;
            a = b;
            b = (temp + a) % 1000000007;
        }
        return b;
    }
}
