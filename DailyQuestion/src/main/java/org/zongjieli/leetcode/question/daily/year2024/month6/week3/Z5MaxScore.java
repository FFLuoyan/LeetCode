package org.zongjieli.leetcode.question.daily.year2024.month6.week3;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个正整数 x
 * 一开始在数组的位置 0 处,可以按照下述规则访问数组中的其他位置:
 *  如果当前在位置 i,那么可以移动到满足 i < j 的任意位置 j
 *  对于访问的位置 i,可以获得分数 nums[i]
 *  如果从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的奇偶性不同,那么将失去分数 x
 * 请返回能得到的最大得分之和
 * 注意,一开始的分数为 nums[0]
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], x <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/6/16
 */
public class Z5MaxScore {

    public long maxScore(int[] nums, int x) {
        long[] maxScore = new long[2];
        maxScore[nums[0] & 1] = nums[0];
        maxScore[(nums[0] & 1) ^ 1] = -x;
        for (int i = 1; i < nums.length; i++) {
            int index = (nums[i] & 1);
            maxScore[index] = Math.max(maxScore[index], maxScore[index ^ 1] - x) + nums[i];
        }
        return Math.max(maxScore[0], maxScore[1]);
    }

}
