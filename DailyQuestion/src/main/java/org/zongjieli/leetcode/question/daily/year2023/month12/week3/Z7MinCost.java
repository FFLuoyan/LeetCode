package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

/**
 * 给定一个整数数组 cost,其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
 * 一旦支付此费用,即可选择向上爬一个或者两个台阶
 * 可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
 * 请计算并返回达到楼梯顶部的最低花费
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/17
 */
public class Z7MinCost {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        for (int i = 2; i < minCost.length; i++) {
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 2], minCost[i - 1] + cost[i - 1]);
        }
        return minCost[minCost.length - 1];
    }

}
