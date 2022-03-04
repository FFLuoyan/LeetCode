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
        for (int i = 0 ; i < nums.length ; i++) {
            int leftMin = 0, leftMax = 0, rightMin = 0, rightMax = 0;
            for (int left = i - 1 ; left >= 0 && nums[left] >= nums[i] ; left--) {
                leftMin++;
            }
            for (int left = i - 1 ; left >= 0 && nums[left] <= nums[i] ; left--) {
                leftMax++;
            }
            for (int right = i + 1 ; right < nums.length && nums[right] > nums[i]; right++) {
                rightMin++;
            }
            for (int right = i + 1 ; right < nums.length && nums[right] < nums[i]; right++) {
                rightMax++;
            }
            result += (leftMax * rightMax + leftMax + rightMax - leftMin * rightMin - leftMin - rightMin) * (long) nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SubArrayRangeSum test = new SubArrayRangeSum();
        // 4
        System.out.println(test.subArrayRanges(new int[]{1,2,3}));
        // 4
        System.out.println(test.subArrayRanges(new int[]{1,3,3}));
    }
}
