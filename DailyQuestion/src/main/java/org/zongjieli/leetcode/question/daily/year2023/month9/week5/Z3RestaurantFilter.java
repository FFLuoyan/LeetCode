package org.zongjieli.leetcode.question.daily.year2023.month9.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个餐馆信息数组 restaurants
 * 其中  restaurants[i] = [idI, ratingI, veganFriendlyI, priceI, distanceI]
 * 必须使用以下三个过滤器来过滤这些餐馆信息
 *  其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false
 *  如果为 true 就意味着应该只包括 veganFriendlyI 为 true 的餐馆,为 false 则意味着可以包括任何餐馆
 *  此外,还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器
 *  它们分别考虑餐厅的价格因素和距离因素的最大值
 * 过滤后返回餐馆的 id,按照 rating 从高到低排序
 * 如果 rating 相同,那么按 id 从高到低排序
 * 简单起见,veganFriendlyI 和 veganFriendly 为 true 时取值为 1,为 false 时取值为 0
 *
 * 1 <= restaurants.length <= 10^4
 * restaurants[i].length == 5
 * 1 <= idI, ratingI, priceI, distanceI <= 10^5
 * 1 <= maxPrice, maxDistance <= 10^5
 * veganFriendlyI 和 veganFriendly 的值为 0 或 1
 * 所有 idi 各不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/27
 */
public class Z3RestaurantFilter {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int index = 0;
        for (int[] restaurant : restaurants) {
            if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                restaurants[index++] = restaurant;
            }
        }
        Arrays.sort(restaurants, 0, index, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        List<Integer> result = new ArrayList<>();
        for (int i = index - 1; i >= 0; i--) {
            result.add(restaurants[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        Z3RestaurantFilter test = new Z3RestaurantFilter();
        // [57395, 28391, 77484]
        System.out.println(test.filterRestaurants(new int[][]{{77484, 13400, 1, 4010, 2926}, {3336, 85138, 0, 49966, 89979}, {28391, 55328, 0, 69158, 29058}, {57395, 64988, 0, 45312, 30261}}, 0, 99739, 60242));
    }
}
