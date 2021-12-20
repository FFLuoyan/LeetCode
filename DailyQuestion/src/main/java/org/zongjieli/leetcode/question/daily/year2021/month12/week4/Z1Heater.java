package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import java.util.Arrays;

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
    private int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int result = 0;
        int heaterIndex = 0;
        int temp;
        for (int house : houses) {
            int current = Math.abs(heaters[heaterIndex] - house);
            while (heaterIndex < heaters.length - 1 && (temp = Math.abs(heaters[heaterIndex + 1] - house)) <= current) {
                current = temp;
                heaterIndex++;
            }
            result = Math.max(current, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Z1Heater test = new Z1Heater();
        // 1
        System.out.println(test.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        // 1
        System.out.println(test.findRadius(new int[]{1,2,3}, new int[]{2}));
        // 3
        System.out.println(test.findRadius(new int[]{1,5}, new int[]{2}));
        // 0
        System.out.println(test.findRadius(new int[]{1,2,3,9,10,1000,17}, new int[]{1,2,3,9,10,50,1000,1001,17}));
    }
}
