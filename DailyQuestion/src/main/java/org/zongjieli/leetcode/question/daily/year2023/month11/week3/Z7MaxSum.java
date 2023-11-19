package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 找出三个长度为 k、互不重叠、且全部数字和(3 * k 项)最大的子数组
 * 并以下标的数组形式返回这三个子数组
 * 数组中的每一项分别指示每个子数组的起始位置(下标从 0 开始)
 * 如果有多个结果,返回字典序最小的一个
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] < 2^16
 * 1 <= k <= floor(nums.length / 3)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/19
 */
public class Z7MaxSum {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int[] maxSingle = new int[nums.length];
        int[] maxSingleIndex = new int[nums.length];
        int[] maxDouble = new int[nums.length];
        int[][] maxDoubleIndex =  new int[nums.length][];
        sum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2 ; i >= nums.length - k ; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }
        maxSingle[nums.length - k] = sum[nums.length - k];
        maxSingleIndex[nums.length - k] = nums.length - k;
        for (int i = nums.length - k - 1 ; i >= 0 ; i--) {
            sum[i] = sum[i + 1] + nums[i] - nums[i + k];
            if (sum[i] >= maxSingle[i + 1]) {
                maxSingle[i]  = sum[i];
                maxSingleIndex[i] = i;
            } else {
                maxSingle[i] = maxSingle[i + 1];
                maxSingleIndex[i] = maxSingleIndex[i + 1];
            }
        }
        for (int i = nums.length - 2 * k ; i >= 0 ; i--) {
            int currentDouble = sum[i] + maxSingle[i + k];
            if (currentDouble >= maxDouble[i + 1]) {
                maxDouble[i] = currentDouble;
                maxDoubleIndex[i] = new int[]{i, maxSingleIndex[i + k]};
            } else {
                maxDouble[i] = maxDouble[i + 1];
                maxDoubleIndex[i] = maxDoubleIndex[i + 1];
            }
        }
        int resultSum = 0;
        int[] result = null;
        for (int i = nums.length - 3 * k ; i >= 0 ; i--) {
            int currentSum = sum[i] + maxDouble[i + k];
            if (currentSum >= resultSum) {
                resultSum = currentSum;
                result = new int[]{i, maxDoubleIndex[i + k][0], maxDoubleIndex[i + k][1]};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z7MaxSum test = new Z7MaxSum();
        // [1, 4, 7]
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, 3)));
    }
}
