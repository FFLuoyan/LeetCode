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
        int start = 0, result = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 0 && --k < 0) {
                result = Math.max(result, i - start);
                while (nums[start] == 1) {
                    start++;
                }
                start++;
            }
        }
        return Math.max(result, nums.length - start);
    }

    public static void main(String[] args) {
        MaxContinuation test = new MaxContinuation();
        // 6
        System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
