package org.zongjieli.leetcode.question.daily.year2025.month1.week3;

/**
 * 给定一个非负整数数组 nums 和一个整数 k
 * 如果一个数组中所有元素的按位或运算 OR 的值至少为 k,那么我们称这个数组是特别的
 * 请返回 nums 中最短特别非空子数组的长度,如果特别子数组不存在,那么返回 -1
 *
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 0 <= k < 64
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/16
 */
public class Z4SpecialSubarray {

    public int minimumSubarrayLength(int[] nums, int k) {
        int result = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int currentOR = 0;
            for (int j = i; j < nums.length; j++) {
                currentOR |= nums[j];
                if (currentOR >= k) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == nums.length + 1 ? -1 : result;
    }

}
