package org.zongjieli.leetcode.question.daily.year2024.month1.week4;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 如果 nums 中长度为 m 的子数组 s 满足以下条件,称它是一个交替子数组:
 *  m 大于 1
 *  s1 = s0 + 1
 *  下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s((m-1) % 2)] 一样
 *      也就是说,s1 - s0 = 1,s2 - s1 = -1,s3 - s2 = 1,s4 - s3 = -1,以此类推
 *      直到 s[m - 1] - s[m - 2] = (-1)^m
 * 请返回 nums 中所有交替子数组中最长的长度
 * 如果不存在交替子数组,请返回 -1
 * 子数组是一个数组中一段连续非空的元素序列
 *
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/23
 */
public class Z2LongestSubarray {

    public int alternatingSubarray(int[] nums) {
        int result = -1, cl = 1, cv, need = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((cv = nums[i] - nums[i - 1]) == need) {
                cl++;
                need = -need;
                result = Math.max(result, cl);
            } else if (cv == 1) {
                cl = 2;
            } else {
                cl = 1;
                need = 1;
            }
        }
        return result;
    }

}
