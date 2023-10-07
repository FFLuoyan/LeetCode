package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

/**
 * 给定一个整数数组 prices,其中 prices[i] 表示某支股票第 i 天的价格
 * 在每一天,可以决定是否购买或出售股票,在任何时候最多只能持有一股股票
 * 可以先购买,然后在同一天出售
 * 返回能获得的最大利润
 *
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/7
 */
public class Z1MaxProfit {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for (int price : prices) {
            if (price > min) {
                result += price - min;
            }
            min = price;
        }
        return result;
    }

}
