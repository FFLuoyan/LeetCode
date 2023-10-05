package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

import java.util.Arrays;

/**
 * 给定一个整数数组 prices,其中第 prices[i] 表示第 i 天的股票价格
 * 设计一个算法计算出最大利润,在满足以下约束条件下,可以尽可能地完成更多的交易(多次买卖一支股票):
 *  卖出股票后,无法在第二天买入股票(即冷冻期为 1 天)
 * 注意: 不能同时参与多笔交易(必须在再次购买前出售掉之前的股票)
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/5
 */
public class Z4MaxProfit {

    private int[] max;

    public int maxProfit(int[] prices) {
        max = new int[prices.length];
        Arrays.fill(max, -1);
        return maxProfit(prices, 0);
    }

    public int maxProfit(int[] prices, int index) {
        if (index >= prices.length) {
            return 0;
        }
        if (max[index] != -1) {
            return max[index];
        }
        int min = prices[index], result = 0;
        for (int i = index + 1 ; i < prices.length ; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                result = Math.max(result, prices[i] - min + maxProfit(prices, i + 2));
            }
        }
        return max[index] = result;
    }
}
