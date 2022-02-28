package org.zongjieli.leetcode.question.daily.year2022.month2.week4;
/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 该数组的大小为 n,请计算 nums[j] - nums[i] 能求得的最大差值
 * 其中 0 <= i < j < n 且 nums[i] < nums[j]
 *
 * 返回最大差值,如果不存在满足要求的 i 和 j,返回 -1
 *
 * n == nums.length
 * 2 <= n <= 1000
 * 1 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/2/28
 * @version  1.0
 */
public class Z6MaxDifference {
    public int maximumDifference(int[] nums) {
        int result = -1;
        int min = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > min) {
                result = Math.max(result, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return result;
    }
}
