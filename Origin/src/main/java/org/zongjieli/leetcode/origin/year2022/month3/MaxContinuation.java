package org.zongjieli.leetcode.origin.year2022.month3;
/**
 * 给定一个二进制数组 nums 和一个整数 k
 * 如果可以翻转最多 k 个 0,则返回数组中连续 1 的最大个数
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * @author   Li.zongjie
 * @date     2022/3/30
 * @version  1.0
 */
public class MaxContinuation {

    public int longestOnes(int[] nums, int k) {
        // left 作为滑动窗口最左侧,遍历的时候维护窗口的大小
        // 保证 [left, i] 为最优解的大小
        int left = 0;
        for (int num : nums) {
            k += (num - 1);
            if (k < 0) {
                k += 1 - nums[left++];
            }
        }
        return nums.length - left;
    }

    public static void main(String[] args) {
        MaxContinuation test = new MaxContinuation();
        // 6
        System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
