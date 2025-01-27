package org.zongjieli.leetcode.question.daily.year2025.month1.week4;

/**
 * 给定一个下标从 0 开始的二维整数数组 transactions,其中 transactions[i] = [costI, cashbackI]
 * 数组描述了若干笔交易,其中每笔交易必须以某种顺序恰好完成一次
 * 在任意一个时刻,有一定数目的钱 money,为了完成交易 i,money >= costI 这个条件必须为真
 * 执行交易后,钱数 money 变成 money - costI + cashbackI
 * 请返回任意一种交易顺序下,都能完成所有交易的最少钱数 money 是多少
 *
 * 1 <= transactions.length <= 10^5
 * transactions[i].length == 2
 * 0 <= costI, cashbackI <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/26
 */
public class Z6MinMoney {

    public long minimumMoney(int[][] transactions) {
        // 计算所有负数的交易,负数交易在前,正数交易在后
        // 由于负数总数的确定的,对于全部的负数交易,回款数最大的一笔在最后
        // 同理,开销最大的一笔正数交易在最前
        // 满足此两笔交易,则任意交易可执行
        long sub, maxAdd = 0, maxSub = 0, result = 0;
        for (int[] transaction : transactions) {
            sub = transaction[0] - transaction[1];
            if (sub < 0) {
                maxAdd = Math.max(maxAdd, transaction[0]);
            } else {
                result += sub;
                maxSub = Math.max(maxSub, transaction[1]);
            }
        }
        return Math.max(maxSub, maxAdd) + result;
    }

    public static void main(String[] args) {
        Z6MinMoney test = new Z6MinMoney();
        // 10
        System.out.println(test.minimumMoney(new int[][]{{2, 1}, {5, 0}, {4, 2}}));
        // 18
        System.out.println(test.minimumMoney(new int[][]{{7, 2}, {0, 10}, {5, 0}, {4, 1}, {5, 8}, {5, 9}}));
    }
}
