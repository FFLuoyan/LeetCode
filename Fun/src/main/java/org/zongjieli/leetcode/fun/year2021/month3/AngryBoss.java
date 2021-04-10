package org.zongjieli.leetcode.fun.year2021.month3;
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
     * 客户的满意数量
     * 等于客户本就满意的数量 + 老板克制后的挽留数量
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 最大挽留客户数
        int max = 0;
        // 客户总数
        int customerAmount = 0;
        // 当前可挽留客户(当前分钟前 X 分钟(不包括当前))
        int currentSave = 0;
        for (int i = 0 ; i < customers.length ; i++){
            if (grumpy[i] == 0){
                customerAmount += customers[i];
            } else {
                currentSave += customers[i];
            }
            if (i >= X && grumpy[i - X] == 1){
                currentSave -= customers[i - X];
            }
            max = Math.max(max,currentSave);
        }
        return customerAmount + max;
    }
}
