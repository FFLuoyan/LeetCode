package org.zongjieli.leetcode.competion.doubleweekly.order98;

import java.util.Arrays;

/**
 *给定一个下标从 0 开始的整数数组 nums
 * nums 的最小得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值
 * nums 的最大得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值
 * nums 的分数是最大得分与最小得分的和
 * 目标是最小化 nums 的分数
 * 你最多可以修改 nums 中 2 个元素的值
 * 请返回修改 nums 中至多两个元素的值后可以得到的最小分数
 *
 * |x| 表示 x 的绝对值
 *
 * 3 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/18
 */
public class O98N2MaxScore {

    public int minimizeSum(int[] nums) {
        if (nums.length == 3) {
            return 0;
        }
        Arrays.sort(nums);
        return Math.min(Math.min(nums[nums.length - 3] - nums[0], nums[nums.length - 2] - nums[1]), nums[nums.length - 1] - nums[2]);
    }

    public static void main(String[] args) {
        O98N2MaxScore test = new O98N2MaxScore();
        System.out.println(test.minimizeSum(new int[]{1, 4, 7, 8, 5}));
    }
}
