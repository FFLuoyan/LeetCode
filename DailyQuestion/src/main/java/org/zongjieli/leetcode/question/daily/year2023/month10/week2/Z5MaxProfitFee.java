package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

/**
 * 给定一个整数数组 prices,其中 prices[i]表示第 i 天的股票价格: 整数 fee 代表了交易股票的手续费用
 * 可以无限次地完成交易,但是每笔交易都需要付手续费
 * 如果已经购买了一个股票,在卖出它之前就不能再继续购买股票了
 * 返回获得利润的最大值
 * 注意: 这里的一笔交易指买入持有并卖出股票的整个过程,每笔交易只需要支付一次手续费
 *
 * 1 <= prices.length <= 5 * 10^4
 * 1 <= prices[i] < 5 * 10^4
 * 0 <= fee < 5 * 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/6
 */
public class Z5MaxProfitFee {

    public int maxProfit(int[] prices, int fee) {
        int last = Integer.MAX_VALUE, result = 0;
        for (int price : prices) {
            if (price >= last) {
                result += (price - last);
                last = price;
            } else {
                last = Math.min(last, price + fee);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z5MaxProfitFee test = new Z5MaxProfitFee();
        // 8
        System.out.println(test.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

}
