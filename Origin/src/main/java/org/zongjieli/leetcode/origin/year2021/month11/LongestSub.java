package org.zongjieli.leetcode.origin.year2021.month11;
/**
 * 给定一个整数数组 nums,找到其中最长严格递增子序列的长度
 *
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *  
 * @author   Li.zongjie
 * @date     2021/11/4
 * @version  1.0
 */
public class LongestSub {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] length = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            int currentLength = 1;
            for (int j = 0 ; j < i ; j++){
                if (nums[i] > nums[j]){
                    currentLength = Math.max(length[j] + 1, currentLength);
                }
            }
            length[i] = currentLength;
            result = Math.max(result, currentLength);
        }
        return result;
    }
}
