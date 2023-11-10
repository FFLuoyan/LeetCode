package org.zongjieli.leetcode.question.daily.year2023.month11.week2;

import java.util.Arrays;

/**
 * 给定两个正整数数组 spells 和 potions,长度分别为 n 和 m
 * 其中 spells[i] 表示第 i 个咒语的能量强度,potions[j] 表示第 j 瓶药水的能量强度
 * 同时给定一个整数 success,一个咒语和药水的能量强度相乘如果大于等于 success
 * 那么它们视为一对成功的组合
 * 请返回一个长度为 n 的整数数组 pairs,其中 pairs[i] 是能跟第 i 个咒语成功组合的药水数目
 *
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10^5
 * 1 <= spells[i], potions[i] <= 10^5
 * 1 <= success <= 10^10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/10
 */
public class Z5PairCount {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = potions.length - findMinSuccessIndex((success - 1) / spells[i] + 1, potions);
        }
        return result;
    }

    private int findMinSuccessIndex(long min, int[] potions) {
        int left = 0, right = potions.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (potions[middle] < min) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Z5PairCount test = new Z5PairCount();
        // [4, 0, 3]
        System.out.println(Arrays.toString(test.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        // [0, 0, 0]
        System.out.println(Arrays.toString(test.successfulPairs(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5}, 10000)));
    }

}
