package org.zongjieli.leetcode.question.daily.year2024.month3.week3;

/**
 * 给你一个下标从 0 开始、由正整数组成的数组 nums
 * 可以在数组上执行下述操作任意次:
 *  选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i
 *  将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1],并从数组中删除元素 nums[i]
 * 返回可以从最终数组中获得的最大元素的值
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/14
 */
public class Z4FindMax {

    public long maxArrayValue(int[] nums) {
        long result = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result = nums[i] <= result ? result + nums[i] : nums[i];
        }
        return result;
    }

}
