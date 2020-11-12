package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * @ClassName: BestTimeToTransactionShares
 * @Description:    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *                  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *                  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: Zongjie.Li
 * @Date: 2020/11/11
 * @Version: 1.0
 **/
public class BestTimeToTransactionShares {
    public int maxProfit(int[] prices) {
        int profits = 0;
        for (int i = 1; i < prices.length; i++){
            profits += Math.max(prices[i] - prices[i-1],0);
        }
        return profits;
    }

    public static void main(String[] args) {
        BestTimeToTransactionShares shares = new BestTimeToTransactionShares();
        System.out.println(shares.maxProfit(new int[]{1, 5, 1, 0, 3, 2, 6, 5, 7, 8, 5, 4, 1, 0, 2}));
    }
}
