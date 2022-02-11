package org.zongjieli.leetcode.question.daily.year2022.month1.month.week2;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 其中 nums[i] 表示第 i 名学生的分数,另给定一个整数 k
 * 从数组中选出任意 k 名学生的分数
 * 使这 k 个分数间最高分和最低分的差值达到最小化
 *
 * 返回可能的最小差值
 *
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/2/11
 * @version  1.0
 */
public class Z5MinDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[k - 1] - nums[0];
        for (int i = k ; i < nums.length ; i++){
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }
}
