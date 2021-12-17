package org.zongjieli.leetcode.question.daily.year2021.month12.week3;
/**
 * 小区便利店正在促销,用 numExchange 个空酒瓶可以兑换一瓶新酒
 * 现在有 numBottles 瓶酒
 * 如果喝掉了酒瓶中的酒,那么酒瓶就会变成空的
 * 请计算最多能喝到多少瓶酒
 *
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 *
 * @author   Li.zongjie
 * @date     2021/12/17
 * @version  1.0
 */
public class Z5ExchangeDrinks {
    public int numWaterBottles(int numBottles, int numExchange) {
        return  numBottles * numExchange / (numExchange - 1) + ( numBottles * numExchange % (numExchange - 1) == 0 ? -1 : 0);
    }
}
