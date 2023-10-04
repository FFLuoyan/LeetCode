package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

import java.util.Arrays;

/**
 * 给定一个整数数组 prices 和一个整数 k
 * 其中 prices[i] 是某支给定的股票在第 i 天的价格
 * 设计一个算法来计算所能获取的最大利润,最多可以完成 k 笔交易
 * 也就是说,最多可以买 k 次,卖 k 次
 * 注意: 不能同时参与多笔交易(必须在再次购买前出售掉之前的股票)
 *
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/4
 */
public class Z3MaxProfit {

    private int[][] save = new int[0][0];

    public int maxProfit(int k, int[] prices) {
        int[] simple = new int[prices.length];
        int index = 1, si = 0;
        while (true) {
            while (index < prices.length && prices[index] <= prices[index - 1]) {
                index++;
            }
            if (index == prices.length) {
                break;
            }
            simple[si++] = prices[index - 1];
            while (index < prices.length && prices[index] >= prices[index - 1]) {
                index++;
            }
            simple[si++] = prices[index - 1];
        }
        if (si == 0) {
            return 0;
        }
        simple = Arrays.copyOf(simple, si);
        save = new int[simple.length][k + 1];
        return maxProfit(0, k, simple);
    }

    public int maxProfit(int index, int k, int[] values) {
        if (k == 0) {
            return 0;
        }
        if (save[index][k] != 0) {
            return save[index][k];
        }
        int result = 0;
        if (values.length <= 2 * k) {
            for (int i = 0; i < values.length; i += 2) {
                result += (values[i + 1] - values[i]);
            }
            return save[index][k] = result;
        }
        int min = values[index], beforeMax = 0;
        for (int i = index + 1 ; i < values.length - 2 * k + 2 ; i += 2) {
            min = Math.min(min, values[i - 1]);
            beforeMax = Math.max(beforeMax, values[i] - min);
            result = Math.max(result, beforeMax + maxProfit(i + 1, k - 1, values));
        }
        return save[index][k] = result;
    }

    public static void main(String[] args) {
        Z3MaxProfit test = new Z3MaxProfit();
        // 0
        System.out.println(test.maxProfit(2, new int[]{1}));
        // 3
        System.out.println(test.maxProfit(2, new int[]{1, 2, 4}));
        // 7
        System.out.println(test.maxProfit(2, new int[]{6, 1, 3, 2, 4, 7}));
        // 6
        System.out.println(test.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        // 12
        System.out.println(test.maxProfit(2, new int[]{5, 2, 3, 0, 3, 5, 6, 8, 1, 5}));
    }
}
