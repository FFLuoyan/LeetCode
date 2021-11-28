package org.zongjieli.leetcode.competion.singleweekly.order269;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的数组 nums,数组中有 n 个整数,另给定一个整数 k
 * 半径为 k 的子数组平均值是指:
 *  nums 中一个以下标 i 为中心且半径为 k 的子数组中所有元素的平均值
 *      即下标在 i - k 和 i + k 范围(含 i - k 和 i + k)内所有元素的平均值
 *      如果在下标 i 前或后不足 k 个元素,那么半径为 k 的子数组平均值是 -1
 *
 * 构建并返回一个长度为 n 的数组 avgs
 * 其中 avgs[i] 是以下标 i 为中心的子数组的半径为 k 的子数组平均值
 * x 个元素的平均值是 x 个元素相加之和除以 x
 * 此时使用截断式整数除法,即需要去掉结果的小数部分
 *
 * 例如,四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 3.75，截断后得到 3
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 0 <= nums[i], k <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/11/28
 * @version  1.0
 */
public class SubarrayAverage {
    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        long sum = 0;
        for (int i = 0 ; i < k && i < nums.length; i++){
            result[i] = -1;
            sum += nums[i];
        }
        for (int i = Math.max(nums.length - k - 1, 0) ; i < nums.length ; i++){
            result[i] = -1;
        }
        for (int i = k ; i < 2 * k && i < nums.length; i++){
            sum += nums[i];
        }
        for (int i = k ; i < nums.length - k ; i++){
            sum += nums[i + k];
            result[i] = (int) (sum / (2 * k + 1));
            sum -= nums[i - k];
        }
        return result;
    }

    public static void main(String[] args) {
        SubarrayAverage test = new SubarrayAverage();
        System.out.println(Arrays.toString(test.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));
        System.out.println(Arrays.toString(test.getAverages(new int[]{8}, 10000)));
    }
}
