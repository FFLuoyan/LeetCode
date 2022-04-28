package org.zongjieli.leetcode.question.daily.year2022.month4.week5;
/**
 * 给定一个整数数组 nums,将 nums 中的的所有偶数元素移动到数组的前面,后跟所有奇数元素
 * 返回满足此条件的任一数组作为答案
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 *
 * @author   Li.zongjie
 * @date     2022/4/28
 * @version  1.0
 */
public class Z4ParityOrder {

    public int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0, oddIndex = nums.length - 1;
        while (evenIndex < oddIndex) {
            while (evenIndex < oddIndex && nums[evenIndex] % 2 == 0) {
                evenIndex++;
            }
            if (evenIndex == oddIndex) {
                break;
            }
            while (oddIndex > evenIndex && nums[oddIndex] % 2 == 1) {
                oddIndex--;
            }
            if (evenIndex < oddIndex) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }
        return nums;
    }
}
