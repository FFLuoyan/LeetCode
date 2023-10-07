package org.zongjieli.leetcode.question.daily.year2023.month10.week1;

/**
 * 给定一个数组 prices,它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
 * 只能选择某一天买入这只股票,并选择在未来的某一个不同的日子卖出该股票
 * 设计一个算法来计算所能获取的最大利润
 * 返回可以从这笔交易中获取的最大利润
 * 如果不能获取任何利润,返回 0
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/7
 */
public class Z7MaxProfit {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(price, min);
        }
        return result;
    }

}
