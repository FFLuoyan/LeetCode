package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Zongjie.Li
 * @date 2020/11/11
 * @version 1.0
 **/
public class P02TransactionShares {

    /**
     * 该算法通过贪心算法来实现,贪心算法是动态规划法的一个特例
     * 贪心算法要求每一步均为最优解
     * 而动态规划则要求上一步可能为局部最优解,也可能不为局部最优解
     *
     */
    public int maxProfit(int[] prices) {
        int profits = 0;
        for (int i = 1; i < prices.length; i++){
            profits += Math.max(prices[i] - prices[i-1],0);
        }
        return profits;
    }

    /**
     * Dp(Dynamic programming)
     * 该题动态规划的解决方案的要点在于找到合适的状态转移方程
     * 即每日可获得的最高收益与前一日的收益关系
     *
     * 每日的状态为 当前收益、是否持有股票
     * profitNoShares 可以保证每天的收益都是最大的
     * profitWitShares 可以保证每天手上的股票都是最便宜的
     */
    public int maxProfitByDp(int[] prices) {
        int profitNoShares = 0;
        int profitWitShares = - prices[0];

        for (int i = 1 ; i < prices.length ; i++){
            int temp = profitNoShares;
            profitNoShares = Math.max(profitWitShares + prices[i],temp);
            profitWitShares = Math.max(temp - prices[i],profitWitShares);
        }

        return profitNoShares;
    }

    public static void main(String[] args) {
        P02TransactionShares test = new P02TransactionShares();
        System.out.println(test.maxProfit(new int[]{1, 5, 1, 0, 3, 2, 6, 5, 7, 8, 5, 4, 1, 0, 2}));
        System.out.println(test.maxProfitByDp(new int[]{1, 5, 1, 0, 3, 2, 6, 5, 7, 8, 5, 4, 1, 0, 2}));
    }
}
