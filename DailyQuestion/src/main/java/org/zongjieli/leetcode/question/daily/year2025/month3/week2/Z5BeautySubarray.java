package org.zongjieli.leetcode.question.daily.year2025.month3.week2;


import java.util.*;

/**
 * 给定一个由正整数组成的数组 nums 和一个正整数 k
 * 如果 nums 的子集中,任意两个整数的绝对差均不等于 k,则认为该子数组是一个美丽子集
 * 返回数组 nums 中非空且美丽的子集数目
 * nums 的子集定义为:
 *  可以经由 nums 删除某些元素(也可能不删除)得到的一个数组
 *  只有在删除元素时选择的索引不同的情况下,两个子集才会被视作是不同的子集
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/7
 */
public class Z5BeautySubarray {

    public int beautifulSubsets(int[] nums, int k) {
        Set<Integer> invalidSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    invalidSet.add((1 << i) + (1 << j));
                }
            }
        }
        int max = 1 << nums.length, result = 0;
        a: for (int i = 1; i < max; i++) {
            for (Integer invalidValue : invalidSet) {
                if ((invalidValue & i) == invalidValue) {
                    continue a;
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z5BeautySubarray test = new Z5BeautySubarray();
        // 4
        System.out.println(test.beautifulSubsets(new int[]{2, 4, 6}, 2));
    }

}
