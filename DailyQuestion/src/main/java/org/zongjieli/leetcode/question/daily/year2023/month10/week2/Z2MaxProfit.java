package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

/**
 * 给定一个数组,它的第 i 个元素是一支给定的股票在第 i 天的价格
 * 设计一个算法来计算所能获取的最大利润,最多可以完成两笔交易
 * 注意: 不能同时参与多笔交易(必须在再次购买前出售掉之前的股票)
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/3
 */
public class Z2MaxProfit {

    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];
        int min = prices[0], max = prices[prices.length - 1], maxProfit = 0, result;
        for (int i = 1; i < prices.length; i++) {
            profit[i] = maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        maxProfit = 0;
        result = profit[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            result = Math.max(result, profit[i] + maxProfit);
            maxProfit = Math.max(maxProfit, max - prices[i]);
            max = Math.max(prices[i], max);
        }
        return result;
    }

    public static void main(String[] args) {
        Z2MaxProfit test = new Z2MaxProfit();
        // 6
        System.out.println(test.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        // 4
        System.out.println(test.maxProfit(new int[]{1, 2, 3, 4, 5}));
        // 13
        System.out.println(test.maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }

}
