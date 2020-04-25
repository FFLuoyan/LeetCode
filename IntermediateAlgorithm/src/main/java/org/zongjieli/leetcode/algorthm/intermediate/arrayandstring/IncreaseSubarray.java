package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

/**
 * @ClassName: IncreaseSubarray
 * @Description: 给定一个未排序的数组,判断这个数组中是否存在长度为 3 的递增子序列
 * @Author: Zongjie.Li
 * @Date: 2020/4/23
 * @Version: 1.0
 **/
public class IncreaseSubarray {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3){
            return false;
        }
        int firstNumber = nums[0];
        int secondNumber = Integer.MAX_VALUE;
        for (int index = 1;index < nums.length;index++) {
            if (nums[index] > secondNumber){
                return true;
            }else if (nums[index] <= firstNumber){
                firstNumber = nums[index];
            }else {
                secondNumber = nums[index];
            }
        }
        return false;
    }
}
