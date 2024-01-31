package org.zongjieli.leetcode.question.daily.year2024.month1.week5;

/**
 * 给定一个下标从 0 开始的数组 nums,数组长度为 n
 * nums 的不同元素数目差数组可以用一个长度为 n 的数组 diff 表示
 * 其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目减去后缀 nums[i + 1, ..., n - 1] 中不同元素的数目
 * 返回 nums 的不同元素数目差数组
 * 注意: nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组(包含下标 i 和 j 对应元素)
 * 特别需要说明的是,如果 i > j,则 nums[i, ..., j] 表示一个空子数组
 *
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/31
 */
public class Z3DiffArray {

    public int[] distinctDifferenceArray(int[] nums) {
        long[] before = new long[nums.length];
        int[] result = new int[nums.length];
        long current = 0;
        for (int i = 0; i < nums.length; i++) {
            before[i] = (current |= (1L << nums[i]));
        }
        current = 0;
        result[nums.length - 1] = Long.bitCount(before[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = Long.bitCount(before[i]) - Long.bitCount(current |= (1L << nums[i + 1]));
        }
        return result;
    }

}
