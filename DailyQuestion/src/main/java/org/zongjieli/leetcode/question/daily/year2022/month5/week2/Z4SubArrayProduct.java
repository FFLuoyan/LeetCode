package org.zongjieli.leetcode.question.daily.year2022.month5.week2;
/**
 * 给定一个整数数组 nums 和一个整数 k
 * 请返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目
 *
 * 1 <= nums.length <= 3 * 10^4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10^6
 *
 * @author   Li.zongjie
 * @date     2022/5/5
 * @version  1.0
 */
public class Z4SubArrayProduct {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, start = 0, product = 1;
        for (int end = 0 ; end < nums.length ; end++) {
            product *= nums[end];
            while (start <= end && product >= k) {
                product /= nums[start++];
            }
            result += (end - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4SubArrayProduct test = new Z4SubArrayProduct();
        // 8
        System.out.println(test.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        // 18
        System.out.println(test.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
        // 0
        System.out.println(test.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
