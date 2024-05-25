package org.zongjieli.leetcode.question.daily.year2024.month5.week4;

/**
 * 给定一个下标从 0 开始、长度为 n 的整数数组 nums
 * 以及整数 indexDifference 和整数 valueDifference
 * 从范围 [0, n - 1] 内找出 2 个满足下述所有条件的下标 i 和 j:
 *  abs(i - j) >= indexDifference
 *  abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer,如果存在满足题目要求的两个下标,则 answer = [i, j]
 * 否则 answer = [-1, -1],如果存在多组可供选择的下标对,只需要返回其中任意一组即可
 * 注意: i 和 j 可能相等
 *
 * 1 <= n == nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= indexDifference <= 100
 * 0 <= valueDifference <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/5/25
 */
public class Z6FindIndex {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i + indexDifference ; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
