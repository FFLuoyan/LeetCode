package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个整数 k
 * 需要执行以下操作恰好 k 次,最大化得分:
 *  从 nums 中选择一个元素 m
 *  将选中的元素 m 从数组中删除
 *  将新元素 m + 1 添加到数组中
 *  得分增加 m
 * 请返回执行以上操作恰好 k 次后的最大得分
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/15
 */
public class Z3MaxKSum {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return (max + max + k - 1) * k / 2;
    }

}
