package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import java.util.TreeSet;

/**
 * 冬季已经来临,设计一个有固定加热半径的供暖器向所有房屋供暖
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖
 * 现在,给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置
 * 请找出并返回可以覆盖所有房屋的最小加热半径
 *
 * 说明:所有供暖器都遵循半径标准,加热的半径也一样
 *
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/12/20
 * @version  1.0
 */
public class Z1Heater {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> positions = new TreeSet<>();
        for (int heater : heaters) {
            positions.add(heater);
        }
        int result = 0;
        for (int house : houses) {
            Integer min = positions.floor(house);
            Integer max = positions.ceiling(house);
            min = min == null ? Integer.MAX_VALUE : house - min;
            max = max == null ? Integer.MAX_VALUE : max - house;
            result = Math.max(result, Math.min(min, max));
        }
        return result;
    }

    public static void main(String[] args) {
        Z1Heater test = new Z1Heater();
        // 1
        System.out.println(test.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
    }
}
