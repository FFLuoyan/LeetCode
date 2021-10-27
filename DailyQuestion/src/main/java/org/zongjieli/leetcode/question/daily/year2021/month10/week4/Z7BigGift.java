package org.zongjieli.leetcode.question.daily.year2021.month10.week4;

import java.util.Arrays;
import java.util.List;

/**
 * 在 LeetCode 商店中,有 n 件在售的物品,每件物品都有对应的价格
 * 然而,也有一些大礼包,每个大礼包以优惠的价格捆绑销售一组物品
 * 给定一个整数数组 price 表示物品价格,其中 price[i] 是第 i 件物品的价格
 * 另有一个整数数组 needs 表示购物清单,其中 needs[i] 是需要购买第 i 件物品的数量
 * 还有一个数组 special 表示大礼包,special[i] 的长度为 n + 1
 * 其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量
 * 且 special[i][n] (也就是数组中的最后一个整数) 为第 i 个大礼包的价格
 *
 * 返回确切满足购物清单所需花费的最低价格,可以充分利用大礼包的优惠活动
 * 不能购买超出购物清单指定数量的物品,即使那样会降低整体价格
 * 任意大礼包可无限次购买
 *
 * n == price.length
 * n == needs.length
 * 1 <= n <= 6
 * 0 <= price[i] <= 10
 * 0 <= needs[i] <= 10
 * 1 <= special.length <= 100
 * special[i].length == n + 1
 * 0 <= special[i][j] <= 50
 *
 * @author   Li.zongjie
 * @date     2021/10/25
 * @version  1.0
 */
public class Z7BigGift {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int base = 16;
        int need = 0;
        int compare = 0;
        int prices = 0;
        int allCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            need <<= 5;
            need += base;
            int currentNeed = needs.get(i);
            need += currentNeed;

            compare <<= 5;
            compare += base;

            int currentPrice = price.get(i);
            prices <<= 5;
            prices += currentPrice;

            allCost += currentNeed * currentPrice;
        }

        int[] bag = new int[special.size()];
        int[] bagCost = new int[special.size()];

        for (int i = 0; i < special.size(); i++) {
            List<Integer> item = special.get(i);
            int itemIndex = item.size() - 1;
            bagCost[i] = item.get(itemIndex);
            int bagNumber = 0;
            for (int j = 0 ; j < itemIndex ; j++){
                bagNumber <<= 5;
                bagNumber += item.get(j);
            }
            bag[i] = bagNumber;
        }
        return getMin(0, bag, bagCost, 0, need, prices, compare);
    }

    private int getMin(int bagIndex, int[] bag, int[] bagCost, int currentCost, int needs, int prices, int compare){
        if (bagIndex == bag.length){
            while (needs > 0){
                int currentNeed = needs & 15;
                int currentPrice = prices & 15;
                needs >>= 5;
                prices >>= 5;
                currentCost += currentNeed * currentPrice;
            }
            return currentCost;
        }
        int min = getMin(bagIndex + 1, bag, bagCost, currentCost, needs, prices, compare);
        while (((needs -= bag[bagIndex]) & compare) == compare){
            currentCost += bagCost[bagIndex];
            min = Math.min(min, getMin(bagIndex + 1, bag, bagCost, currentCost, needs, prices, compare));
        }
        return min;
    }

    public static void main(String[] args) {
        Z7BigGift test = new Z7BigGift();
        System.out.println(test.shoppingOffers(Arrays.asList(2,5), Arrays.asList(Arrays.asList(3,0,5)), Arrays.asList(3,2)));
        System.out.println(test.shoppingOffers(Arrays.asList(2,5), Arrays.asList(Arrays.asList(3,0,5), Arrays.asList(1,2,10)), Arrays.asList(3,2)));
        System.out.println(test.shoppingOffers(Arrays.asList(9,9), Arrays.asList(Arrays.asList(1,1,1)), Arrays.asList(2,2)));
    }
}
