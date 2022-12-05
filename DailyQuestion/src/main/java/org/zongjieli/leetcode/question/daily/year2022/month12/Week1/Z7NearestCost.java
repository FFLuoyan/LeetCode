package org.zongjieli.leetcode.question.daily.year2022.month12.Week1;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 做甜点需要购买配料,目前共有 n 种冰激凌基料和 m 种配料可供选购
 * 而制作甜点需要遵循以下几条规则:
 *  必须选择一种冰激凌基料
 *  可以添加一种或多种配料,也可以不添加任何配料
 *  每种类型的配料最多两份
 * 给定以下三个输入:
 *  baseCosts: 一个长度为 n 的整数数组,其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格
 *  toppingCosts: 一个长度为 m 的整数数组,其中每个 toppingCosts[i] 表示一份第 i 种冰激凌配料的价格
 *  target: 一个整数,表示制作甜点的目标价格
 * 希望做的甜点总成本尽可能接近目标价格 target
 *
 * 返回最接近 target 的甜点成本,如果有多种方案,返回成本相对较低的一种
 *
 * n == baseCosts.length
 * m == toppingCosts.length
 * 1 <= n, m <= 10
 * 1 <= baseCosts[i], toppingCosts[i] <= 10^4
 * 1 <= target <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/5
 */
public class Z7NearestCost {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        TreeMap<Integer, TreeSet<Integer>> costs = new TreeMap<>();
        topSum(toppingCosts, 0, 0, baseCosts, costs, target);
        return costs.firstEntry().getValue().first();
    }

    private void topSum(int[] toppingCosts, int currentSum, int currentIndex, int[] baseCosts, TreeMap<Integer, TreeSet<Integer>> costs, int target) {
        if (currentIndex == toppingCosts.length || currentSum > target) {
            for (int baseCost : baseCosts) {
                costs.computeIfAbsent(Math.abs(target - baseCost - currentSum), k -> new TreeSet<>()).add(baseCost + currentSum);
            }
            return;
        }
        topSum(toppingCosts, currentSum, currentIndex + 1, baseCosts, costs, target);
        topSum(toppingCosts, currentSum + toppingCosts[currentIndex], currentIndex + 1, baseCosts, costs, target);
        topSum(toppingCosts, currentSum + toppingCosts[currentIndex] + toppingCosts[currentIndex], currentIndex + 1, baseCosts, costs, target);
    }

    public static void main(String[] args) {
        Z7NearestCost test = new Z7NearestCost();
        // 17
        System.out.println(test.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
    }
}
