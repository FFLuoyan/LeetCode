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
        int result = 0;
        int index = nums.length;
        int length = index + 1;
        int[] products = new int[length];
        for (int num : nums) {
            if (num >= k) {
                products[index] = 0;
                continue;
            }
            int nextStart = 0;
            while (nextStart < products[index] && (products[nextStart] *= num) >= k) {
                nextStart++;
            }
            result++;
            if (nextStart == products[index]) {
                products[index] = 1;
                products[0] = num;
                continue;
            }
            products[0] = products[nextStart];
            int nextEnd = 1;
            while (++nextStart < products[index]) {
                products[nextEnd++] = products[nextStart] * num;
                result++;
            }
            products[nextEnd] = num;
            products[index] = nextEnd + 1;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4SubArrayProduct test = new Z4SubArrayProduct();
        // 8
        System.out.println(test.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
