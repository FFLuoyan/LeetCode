package org.zongjieli.leetcode.question.daily.year2023.month9.week5;

import java.util.TreeMap;

/**
 * 给定一个下标从 0 开始的二维整数数组 flowers
 * 其中 flowers[i] = [startI, endI] 表示第 i 朵花的花期从 startI 到 endI(都包含)
 * 同时给定一个下标从 0 开始大小为 n 的整数数组 people,people[i] 是第 i 个人来看花的时间
 * 请返回一个大小为 n 的整数数组 answer,其中 answer[i]是第 i 个人到达时在花期内花的数目
 *
 * 1 <= flowers.length <= 5 * 10^4
 * flowers[i].length == 2
 * 1 <= startI <= endI <= 10^9
 * 1 <= people.length <= 5 * 10^4
 * 1 <= people[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/28
 */
public class Z4FlowerCount {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> calculate = new TreeMap<>();
        for (int[] flower : flowers) {
            calculate.merge(flower[0], 1, Integer::sum);
            calculate.merge(flower[1] + 1, -1, (old, update) -> old == 1 ? null : old - 1);
        }
        int current = 0;
        TreeMap<Integer, Integer> timeCount = new TreeMap<>();
        timeCount.put(0, 0);
        while (!calculate.isEmpty()) {
            int time = calculate.firstKey();
            current += calculate.pollFirstEntry().getValue();
            timeCount.put(time, current);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = timeCount.floorEntry(people[i]).getValue();
        }
        return people;
    }

}
