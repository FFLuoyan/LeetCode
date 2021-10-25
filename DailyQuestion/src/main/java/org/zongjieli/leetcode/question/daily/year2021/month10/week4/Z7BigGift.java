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
        // 1 第一件商品包含数量 1 第二件 ... 第 n 件 1 总价
        long[] specials = new long[special.size()];
        for (int i = 0 ; i < special.size() ; i++){
            List<Integer> item = special.get(i);
            for (int j = 0 ; j < item.size() ; j++){
                specials[i] <<= 7;
                specials[i] += item.get(j);
            }
        }
        // 1 第一件商品价格 1 第二件 ... 第 n 件 1 0
        long prices = 0;
        for (int i = 0 ; i < price.size() ; i++){
            prices <<= 1;
            prices += 1;
            prices <<= 6;
            prices += price.get(i);
        }
        prices <<= 1;
        prices += 1;
        prices <<= 6;

        // 1 第一件商品需要数量 1 第二件 ... 第 n 件 1 0
        long need = 0;
        long compare = 0;
        for (Integer i : needs) {
            need <<= 1;
            need += 1;
            need <<= 6;
            need += i;
            compare += 1;
            compare <<= 7;
        }
        need <<= 1;
        need += 1;
        need <<= 6;
        compare <<= 6;
        return getResult(0, 0, prices, need, specials, compare);
    }

    private int getResult(int specialsIndex, int currentCost, long price, long need, long[] specials, long compare){
        if (specialsIndex == specials.length){
            while (need > 0){
                long currentNeed = need & 63;
                long currentPrice = price & 63;
                currentCost += currentNeed * currentPrice;
                need >>= 7;
                price >>= 7;
            }
            return currentCost;
        }
        long special = specials[specialsIndex];
        int min = getResult(specialsIndex + 1, currentCost, price, need, specials, compare);
        while (((need - special) & compare) == compare){
            int specialCost = (int) (special & 63);
            need -= special;
            need += specialCost;
            currentCost += specialCost;
            min = Math.min(min, getResult(specialsIndex + 1, currentCost, price, need, specials, compare));
        }
        return min;
    }

    public static void main(String[] args) {
        Z7BigGift test = new Z7BigGift();
//        System.out.println(test.shoppingOffers(Arrays.asList(2,5), Arrays.asList(Arrays.asList(3,0,5)), Arrays.asList(3,2)));
//        System.out.println(test.shoppingOffers(Arrays.asList(2,5), Arrays.asList(Arrays.asList(3,0,5), Arrays.asList(1,2,10)), Arrays.asList(3,2)));
        System.out.println(test.shoppingOffers(Arrays.asList(9,9), Arrays.asList(Arrays.asList(1,1,1)), Arrays.asList(2,2)));
    }
}
