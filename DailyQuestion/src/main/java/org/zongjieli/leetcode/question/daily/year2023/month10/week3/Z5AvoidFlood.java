package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 有无数个湖泊,所有湖泊一开始都是空的,当第 n 个湖泊下雨前是空的,那么它就会装满水
 * 如果第 n 个湖泊下雨前是满的,这个湖泊会发生洪水,目标是避免任意一个湖泊发生洪水
 * 给定一个整数数组 rains,其中:
 *  rains[i] > 0 表示第 i 天时,第 rains[i] 个湖泊会下雨
 *  rains[i] == 0 表示第 i 天没有湖泊会下雨,可以选择一个湖泊并抽干这个湖泊的水
 * 请返回一个数组 ans,满足:
 *  ans.length == rains.length
 *  如果 rains[i] > 0,那么ans[i] == -1
 *  如果 rains[i] == 0,ans[i] 是第 i 天选择抽干的湖泊
 * 如果有多种可行解请返回它们中的任意一个,如果没办法阻止洪水,请返回一个空的数组
 * 请注意,如果选择抽干一个装满水的湖泊,它会变成一个空的湖泊
 * 但如果选择抽干一个空的湖泊,那么将无事发生
 *
 * 1 <= rains.length <= 10^5
 * 0 <= rains[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/13
 */
public class Z5AvoidFlood {

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> index = new HashMap<>();
        TreeSet<Integer> canUse = new TreeSet<>();
        int[] result = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                canUse.add(i);
                result[i] = 1;
            } else {
                Integer exist = index.get(rains[i]);
                result[i] = -1;
                if (exist == null) {
                    index.put(rains[i], i);
                } else {
                    Integer can = canUse.higher(exist);
                    if (can == null) {
                        return new int[0];
                    }
                    result[can] = rains[i];
                    index.put(rains[i], i);
                    canUse.remove(can);
                }
            }
        }
        return result;
    }

}
