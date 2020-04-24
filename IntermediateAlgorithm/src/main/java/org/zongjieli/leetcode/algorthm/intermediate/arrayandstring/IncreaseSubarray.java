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
        int secondNumber = nums[0];
        int temp = nums[0];
        boolean check = false;
        for (int index = 1;index < nums.length;index++){
            if (check){
                if (nums[index] > secondNumber){
                    return true;
                }else if (nums[index] < secondNumber){
                    if (nums[index] > firstNumber){
                        secondNumber = nums[index];
                    } else if (nums[index] < firstNumber){
                        if (temp < firstNumber){
                            // temp nums[index] 均小于firstNumber,可以刷新 secondNumber
                            if (nums[index] > temp){
                                firstNumber = temp;
                                secondNumber = nums[index];
                                temp = secondNumber;
                            }
                        }else {
                            temp = nums[index];
                        }
                    }
                }
            } else {
                if (nums[index] > firstNumber){
                    secondNumber = nums[index];
                    check = true;
                }else {
                    firstNumber = nums[index];
                }
            }
        }
        return false;
    }
}
