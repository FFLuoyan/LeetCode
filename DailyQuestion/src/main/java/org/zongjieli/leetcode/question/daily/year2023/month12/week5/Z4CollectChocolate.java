package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

/**
 * 给定一个长度为 n,下标从 0 开始的整数数组 nums,表示收集不同巧克力的成本
 * 每个巧克力都对应一个不同的类型,最初,位于下标 i 的巧克力就对应第 i 个类型
 * 在一步操作中,可以用成本 x 执行下述行为:
 *  同时修改所有巧克力的类型,将巧克力的类型 ith 修改为类型 ((i + 1) mod n)th
 * 假设可以执行任意次操作,请返回收集所有类型巧克力所需的最小成本
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= x <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/28
 */
public class Z4CollectChocolate {

    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] min = new int[n][n];
        min[0] = nums;
        for (int i = 0 ; i < n ; i++) {
            int current = nums[i];
            for (int j = 1 ; j < n ; j++) {
                min[j][(i - j + n) % n] = current = Math.min(current, nums[(i - j + n) % n]);
            }
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long current = 0;
            for (int j = 0; j < n; j++) {
                current += min[i][j];
            }
            result = Math.min(result, current + (long) x * i);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4CollectChocolate test = new Z4CollectChocolate();
        // 13
        System.out.println(test.minCost(new int[]{20, 1, 15}, 5));
    }

}
