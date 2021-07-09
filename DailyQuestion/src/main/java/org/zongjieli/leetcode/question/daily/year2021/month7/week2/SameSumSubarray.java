package org.zongjieli.leetcode.question.daily.year2021.month7.week2;
/**
 * 给你一个二元数组 nums 和一个整数 goal
 * 请你统计并返回有多少个和为 goal 的非空子数组
 *
 * 子数组是数组的一段连续部分
 *
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * @author   Zongjie.Li
 * @date     2021/7/8
 * @version  1.0
 */
public class SameSumSubarray {
    public int numSubarrayWithSum(int[] nums, int goal) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int endIndex = i;
            while (endIndex < nums.length - 1 && value < goal){
                value += nums[++endIndex];
            }
            if (value < goal){
                break;
            } else if (value == goal){
                count++;
                while (++endIndex < nums.length){
                    if (nums[endIndex] == 0){
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SameSumSubarray test = new SameSumSubarray();
        System.out.println(test.numSubarrayWithSum(new int[]{0,0,0,0,0},0));
    }
}
