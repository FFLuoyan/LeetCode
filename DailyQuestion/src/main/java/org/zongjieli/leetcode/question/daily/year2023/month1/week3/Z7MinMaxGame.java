package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

/**
 * 给定一个下标从 0 开始的整数数组 nums,其长度是 2 的幂
 * 对 nums 执行下述算法:
 *  设 n 等于 nums 的长度,如果 n == 1,终止算法过程
 *  否则创建一个新的整数数组 newNums,新数组长度为 n / 2,下标从 0 开始
 *  对于满足 0 <= i < n / 2 的每个偶数下标 i
 *  将 newNums[i] 赋值为 min(nums[2 * i], nums[2 * i + 1])
 *  对于满足 0 <= i < n / 2 的每个奇数下标 i
 *  将 newNums[i] 赋值为 max(nums[2 * i], nums[2 * i + 1])
 *  用 newNums 替换 nums
 * 从步骤 1 开始重复整个过程
 * 执行算法后,返回 nums 中剩下的那个数字
 *
 * 1 <= nums.length <= 1024
 * 1 <= nums[i] <= 10^9
 * nums.length 是 2 的幂
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/31
 */
public class Z7MinMaxGame {

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while ((n /= 2) >= 1) {
            for (int i = 0 ; i < n ; i++) {
                nums[i] = (i & 1) == 0 ? Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return nums[0];
    }

}
