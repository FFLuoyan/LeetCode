package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

import java.util.Arrays;

/**
 * 给定一个整数数组 prices,它表示一个商店里若干巧克力的价格
 * 同时给定一个整数 money,表示一开始拥有的钱数
 * 必须购买恰好两块巧克力,而且剩余的钱数必须是非负数
 * 同时想最小化购买两块巧克力的总花费
 * 请返回在购买两块巧克力后,最多能剩下多少钱
 * 如果购买任意两块巧克力都超过了拥有的钱,请返回 money,注意剩余钱数必须是非负数
 *
 * 2 <= prices.length <= 50
 * 1 <= prices[i] <= 100
 * 1 <= money <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/29
 */
public class Z5BuyChocolate {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int remain = money - prices[0] - prices[1];
        return remain >= 0 ? remain : money;
    }

}
