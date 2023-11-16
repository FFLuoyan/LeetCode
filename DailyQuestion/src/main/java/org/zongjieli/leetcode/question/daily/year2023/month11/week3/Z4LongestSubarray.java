package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个整数 threshold
 * 请从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length)
 * 且满足以下条件的最长子数组:
 *  nums[l] % 2 == 0
 *  对于范围 [l, r - 1] 内的所有下标 i,nums[i] % 2 != nums[i + 1] % 2
 *  对于范围 [l, r] 内的所有下标 i,nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度
 * 注意:子数组是数组中的一个连续非空元素序列
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= threshold <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/16
 */
public class Z4LongestSubarray {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int result = 0, l, bit;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= threshold && (bit = nums[i] & 1) == 0) {
                l = i;
                while (++i < nums.length && nums[i] <= threshold && (bit ^ (bit = nums[i] & 1)) == 1) {}
                result = Math.max(result, i-- - l);
            }
        }
        return result;
    }

}
