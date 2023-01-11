package org.zongjieli.leetcode.question.daily.year2022.month12.week2;

/**
 * 给定一个整数数组 nums(下标从 0 开始)
 * 每一次操作中,可以选择数组中一个元素,并将它增加 1
 * 比方说,如果 nums = [1,2,3],可以选择增加 nums[1] 得到 nums = [1,3,3]
 * 请返回使 nums 严格递增的最少操作次数
 * 我们称数组 nums 是严格递增的,当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1]
 * 一个长度为 1 的数组是严格递增的一种特殊情况
 *
 * 1 <= nums.length <= 5000
 * 1 <= nums[i] <= 104
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z7IncreaseArray {

    public int minOperations(int[] nums) {
        int result = 0, before = nums[0] + 1;
        for (int i = 1 ; i < nums.length ; i++) {
            int current = nums[i];
            if (current < before) {
                result += (before - current);
                current = before;
            }
            before = current + 1;
        }
        return result;
    }

}
