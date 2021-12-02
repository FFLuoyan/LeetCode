package org.zongjieli.leetcode.question.daily.year2021.month12.week1;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个长度为 n 的整数数组 score
 * 其中 score[i] 是第 i 位运动员在比赛中的得分所有得分都互不相同
 * 运动员将根据得分决定名次,其中名次第 1 的运动员得分最高
 * 名次第 2 的运动员得分第 2 高,依此类推
 * 运动员的名次决定了他们的获奖情况:
 *
 *  名次第 1 的运动员获金牌 "Gold Medal"
 *  名次第 2 的运动员获银牌 "Silver Medal"
 *  名次第 3 的运动员获铜牌 "Bronze Medal"
 *
 * 从名次第 4 到第 n 的运动员,只能获得他们的名次编号(即,名次第 x 的运动员获得编号 "x")
 * 使用长度为 n 的数组 answer 返回获奖,其中 answer[i] 是第 i 位运动员的获奖情况
 *
 * n == score.length
 * 1 <= n <= 10^4
 * 0 <= score[i] <= 10^6
 * score 中的所有值互不相同
 *
 * @author   Li.zongjie
 * @date     2021/12/2
 * @version  1.0
 */
public class Z4RelativeRank {
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        TreeMap<Integer, Integer> scoreIndex = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            scoreIndex.put(score[i], i);
        }
        String[] result = new String[length];

        int th = 1;
        Map.Entry<Integer, Integer> current = scoreIndex.lastEntry();
        result[current.getValue()] = "Gold Medal";
        th++;
        if (length >= 2){
            current = scoreIndex.lowerEntry(current.getKey());
            result[current.getValue()] = "Silver Medal";
        }
        th++;
        if (length >= 3){
            current = scoreIndex.lowerEntry(current.getKey());
            result[current.getValue()] = "Bronze Medal";
        }
        th++;
        while ((current = scoreIndex.lowerEntry(current.getKey())) != null){
            result[current.getValue()] = String.valueOf(th++);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4RelativeRank test = new Z4RelativeRank();
        System.out.println(Arrays.toString(test.findRelativeRanks(new int[]{5,4,3,2,1})));
    }
}
