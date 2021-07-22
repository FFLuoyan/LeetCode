package org.zongjieli.leetcode.question.daily.year2021.month7.week3;
/**
 * 输入一个整型数组,数组中的一个或连续多个整数组成一个子数组
 * 求所有子数组的和的最大值
 *
 * 要求时间复杂度为 O(n)
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author   Zongjie.Li
 * @date     2021/7/19
 * @version  1.0
 */
public class Z6MaxSumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            max = Math.max(max,temp = temp > 0 ? temp + num : num);
        }
        return max;
    }

    public static void main(String[] args) {
        Z6MaxSumSubarray test = new Z6MaxSumSubarray();
        System.out.println(test.maxSubArray(new int[]{-1,-3,-7,-8,1,-10,-5,-6}));
    }
}
