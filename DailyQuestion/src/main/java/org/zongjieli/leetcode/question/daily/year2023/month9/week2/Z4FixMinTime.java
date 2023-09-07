package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

/**
 * 给定一个整数数组 ranks,表示一些机械工的能力值
 * ranksI 是第 i 位机械工的能力值,能力值为 r 的机械工可以在 r * n^2 分钟内修好 n 辆车
 * 同时给定一个整数 cars,表示总共需要修理的汽车数目
 * 请返回修理所有汽车最少需要多少时间
 * 注意: 所有机械工可以同时修理汽车
 *
 * 1 <= ranks.length <= 10^5
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/7
 */
public class Z4FixMinTime {

    public long repairCars(int[] ranks, int cars) {
        int[] count = new int[101];
        for (int rank : ranks) {
            count[rank]++;
        }
        if (count[1] >= cars) {
            return 1;
        }
        long max = 100L * cars * cars, min = 1;
        while (min < max) {
            long middle = (min + max) / 2;
            if (canFix(middle, count, cars)) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        return max;
    }

    public boolean canFix(long time, int[] count, int cars) {
        long fixCount = 0;
        for (int i = 1 ; i <= 100 ; i++) {
            if (count[i] != 0) {
                fixCount += (long) Math.sqrt(time / i) * count[i];
            }
        }
        return fixCount >= cars;
    }

}
