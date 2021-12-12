package org.zongjieli.leetcode.competion.singleweekly.order271;

import org.zongjieli.leetcode.competion.singleweekly.order269.SubarrayAverage;

/**
 * 给定一个整数数组 nums
 * nums 中子数组的范围是子数组中最大元素和最小元素的差值
 * 返回 nums 中所有子数组范围的和
 * 子数组是数组中一个连续非空的元素序列
 *
 * 1 <= nums.length <= 1000
 * -10^9 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/12/12
 * @version  1.0
 */
public class SubArrayRangeSum {
    public long subArrayRanges(int[] nums) {
        long result = 0;
        for (int i = 0 ; i < nums.length ; i++){
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1 ; j < nums.length ; j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                result += (max - min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubArrayRangeSum test = new SubArrayRangeSum();
        System.out.println(test.subArrayRanges(new int[]{1,2,3}));
    }
}
