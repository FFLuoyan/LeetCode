package org.zongjieli.leetcode.question.daily.year2021.month9.week3;
/**
 * 峰值元素是指其值严格大于左右相邻值的元素
 *
 * 给一个整数数组 nums,找到峰值元素并返回其索引
 * 数组可能包含多个峰值,在这种情况下返回任何一个峰值所在位置即可
 * 可以假设 nums[-1] = nums[n] = -∞
 * 必须实现时间复杂度为 O(log n) 的算法来解决此问题
 *
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author   Li.zongjie
 * @date     2021/9/15
 * @version  1.0
 */
public class Z3FindPeak {
    public int findPeakElement(int[] nums) {
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] < nums[i - 1]){
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}
