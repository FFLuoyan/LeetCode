package org.zongjieli.leetcode.origin.year2023;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素
 * 给定一个整数数组 nums,找到峰值元素并返回其索引
 * 数组可能包含多个峰值,在这种情况下,返回任何一个峰值所在位置即可
 * 可以假设 nums[-1] = nums[n] = -∞
 * 必须实现时间复杂度为 O(log n) 的算法来解决此问题
 *
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/18
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length, middle;
        while (left < right) {
            middle = (left + right) / 2;
            if ((middle - 1) == -1 || nums[middle] > nums[middle - 1]) {
                if ((middle + 1) == nums.length || nums[middle] > nums[middle + 1]) {
                    return middle;
                }
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

}
