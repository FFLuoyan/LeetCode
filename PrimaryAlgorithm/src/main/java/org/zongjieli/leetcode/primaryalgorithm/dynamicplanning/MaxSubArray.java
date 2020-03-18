package org.zongjieli.leetcode.primaryalgorithm.dynamicplanning;

/**
 * @ClassName: MaxSubArray
 * @Description: 给定一个数组, 求出该数组的最大大连子数组和
 * @Author: Zongjie.Li
 * @Date: 2020/3/16
 * @Version: 1.0
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{1, 2, 4, 2, 0, 1, 3, -5, -5, -8, -6, -6, -1, 56, 3, 5, -85, 2, -5, -5, -5, 8, 5, -9, -6}));
    }

    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        for (int index = 1 ; index < nums.length ; index++){
            int countValue = 0;
            for (int countIndex = index ; countIndex >=0 ;countIndex--){
                countValue += nums[countIndex];
                if (countValue > maxValue){
                    maxValue = countValue;
                }
            }
        }
        return maxValue;
    }
}