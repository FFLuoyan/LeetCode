package org.zongjieli.leetcode.question.daily.year2025.month3.week2;

/**
 * 给定一个下标从 0 开始的整数数组 nums,每次操作中可以:
 *  选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j
 *  选择一个非负整数 k,满足 nums[i] 和 nums[j] 在二进制下的第 k 位(下标编号从 0 开始)是 1
 *  将 nums[i] 和 nums[j] 都减去 2^k
 * 如果一个子数组内执行上述操作若干次后,该子数组可以变成一个全为 0 的数组
 * 那么我们称它是一个美丽的子数组
 * 请返回数组 nums 中美丽子数组的数目
 * 子数组是一个数组中一段连续非空的元素序列
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/6
 */
public class Z4BeautySubarray {

    public long beautifulSubarrays(int[] nums) {
        int[] count = new int[1048576];
        count[0]++;
        int value = 0;
        long result = 0;
        for (int num : nums) {
            value ^= num;
            result += (count[value]++);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4BeautySubarray test = new Z4BeautySubarray();
        // 2
        System.out.println(test.beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
    }

}
