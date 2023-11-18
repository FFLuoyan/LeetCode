package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

/**
 * 给定一个下标从 0 开始的数组 nums,数组中的元素都是正整数
 * 请选出两个下标 i,j (i != j) 且 nums[i] 的数位和与 nums[j] 的数位和相等
 * 请找出所有满足条件的下标 i 和 j,找出并返回 nums[i] + nums[j] 可以得到的最大值
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/18
 */
public class Z6MaxSum {

    public int maximumSum(int[] nums) {
        int[][] maxSums = new int[82][2];
        int result = -1;
        for (int num : nums) {
            int sum = getSum(num);
            if (maxSums[sum][0] == 0) {
                maxSums[sum][0] = num;
            } else if (num > maxSums[sum][0]) {
                maxSums[sum][1] = maxSums[sum][0];
                maxSums[sum][0] = num;
                result = Math.max(result, num + maxSums[sum][1]);
            } else if (num > maxSums[sum][1]) {
                maxSums[sum][1] = num;
                result = Math.max(result, num + maxSums[sum][0]);
            }
        }
        return result;
    }

    public int getSum(int i) {
        int result = 0;
        while (i > 0) {
            result += (i % 10);
            i /= 10;
        }
        return result;
    }
}
