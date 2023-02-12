package org.zongjieli.leetcode.competion.singleweekly.order332;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始、长度为 n 的整数数组 nums
 * 和两个整数 lower 和 upper,返回公平数对的数目
 * 如果 (i, j) 数对满足以下情况,则认为它是一个公平数对:
 * 0 <= i < j < n,且 lower <= nums[i] + nums[j] <= upper
 *
 * 1 <= nums.length <= 10^5
 * nums.length == n
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= lower <= upper <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/12
 */
public class O332N2FairPair {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        int start = nums.length - 1, end = nums.length - 1;
        for (int i = 0 ; i < nums.length - 1 && nums[i] + nums[i + 1] <= upper; i++) {
            int max = upper - nums[i];
            int min = lower - nums[i];
            start = Math.max(i + 1, start);
            while (start >= i + 1 && nums[start] >= min) {
                start--;
            }
            while (end >= i + 1 && nums[end] > max) {
                end--;
            }
            result += end - start;
        }
        return result;
    }

    public static void main(String[] args) {
        O332N2FairPair test = new O332N2FairPair();
        // 6
        System.out.println(test.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        // 1
        System.out.println(test.countFairPairs(new int[]{0, 7, 9, 2, 5}, 11, 11));
        // 0
        System.out.println(test.countFairPairs(new int[]{-1, 0}, 1, 1));
        // 3
        System.out.println(test.countFairPairs(new int[]{6,9,4,2,7,5,10,3}, 13, 13));
    }

}
