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
        int current = -10000, result = current;
        for (int num : nums) {
            result = Math.max(result, current = current < 0 ? num : current + num);
        }
        return result;
    }

}
