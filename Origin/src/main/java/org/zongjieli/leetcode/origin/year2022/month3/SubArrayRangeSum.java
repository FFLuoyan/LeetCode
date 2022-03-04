package org.zongjieli.leetcode.origin.year2022.month3;
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
 * @date     2022/3/4
 * @version  1.0
 */
public class SubArrayRangeSum {

    public long subArrayRanges(int[] nums) {
        long result = 0;
        for (int start = 0 ; start < nums.length ; start++) {
            int min = nums[start];
            int max = min;
            for (int end = start + 1 ; end < nums.length ; end++) {
                min = Math.min(min, nums[end]);
                max = Math.max(max, nums[end]);
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
