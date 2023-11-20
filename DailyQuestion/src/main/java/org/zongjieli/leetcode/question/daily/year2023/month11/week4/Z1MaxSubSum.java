package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

/**
 * 给定一个整数数组 nums,请找出一个具有最大和的连续子数组(子数组最少包含一个元素),返回其最大和
 * 子数组是数组中的一个连续部分
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/20
 */
public class Z1MaxSubSum {

    public int maxSubArray(int[] nums) {
        int max = nums[0], before = 0, result = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        if (max <= 0) {
            return max;
        }
        for (int num : nums) {
            before = Math.max(0, before + num);
            result = Math.max(before, result);
        }
        return result;
    }

}
