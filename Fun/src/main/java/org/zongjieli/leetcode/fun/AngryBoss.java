package org.zongjieli.leetcode.fun;
/**
 * 今天,书店老板有一家店打算试营业 customer.length 分钟
 * 每分钟都有一些顾客 (customer[i]) 会进入书店
 * 所有这些顾客都会在那一分钟结束后离开
 *
 * 在某些时候,书店老板会生气,如果书店老板在第 i 分钟生气
 * 那么 grumpy[i] = 1,否则 grumpy[i] = 0
 * 当书店老板生气时,那一分钟的顾客就会不满意,不生气则他们是满意的
 *
 * 书店老板知道一个秘密技巧,能抑制自己的情绪
 * 可以让自己连续 X 分钟不生气,但却只能使用一次
 *
 * 请你返回这一天营业下来,最多有多少客户能够感到满意的数量
 *
 * @author   Zongjie.Li
 * @date     2021/3/27
 * @version  1.0
 */
public class AngryBoss {
    /**
     * 该方法的主要思路是,计算出客户的总量
     * 以及客户不满意的数量
     * 根据客户不满意的数量,计算老板可以挽留的最大数量
     * 客户数量 - 客户不满意的数量 + 老板可以挽留的最大数量
     * 就是最大客户满意数量
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 最大挽留客户数
        int max = 0;
        // 客户不满意的数组
        int[] lose = new int[customers.length];
        int loseAmount = 0;
        // 客户总数
        int customerAmount = 0;
        // 当前可挽留客户(当前分钟前 X 分钟(不包括当前))
        int current = 0;
        for (int i = 0 ; i < customers.length ; i++){
            customerAmount += customers[i];
            lose[i] = customers[i] * grumpy[i];
            loseAmount += lose[i];
            if (i < X){
                current += lose[i];
                max = current;
            } else {
                current = current + lose[i] - lose[i - X];
                max = Math.max(max,current);
            }
        }
        return customerAmount - loseAmount + max;
    }
}
