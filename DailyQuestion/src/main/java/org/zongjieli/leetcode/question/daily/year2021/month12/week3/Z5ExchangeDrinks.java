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
        /*
            开始有 n 个酒瓶,每换一次酒,就会损失 a 个酒瓶,但是会得到 1 个酒瓶
            就相当于每换一次酒,损失了 (a - 1) 个酒瓶
            计算 n / (a - 1) 即可得到可换酒的总次数
            但是如果正好整除,则说明最后一次兑换时只有 a - 1 个酒瓶
            需要把这瓶酒删掉
            也可以一开始就减去一个空瓶,保证最后肯定会剩下一个空瓶
         */
        return  numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
