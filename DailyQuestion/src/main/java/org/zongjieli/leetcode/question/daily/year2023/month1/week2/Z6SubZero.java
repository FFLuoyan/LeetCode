package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 给定一个整数数组 nums 和一个整数 x
 * 每一次操作时,应当移除数组 nums 最左边或最右边的元素
 * 然后从 x 中减去该元素的值
 * 请注意,需要修改数组以供接下来的操作使用
 * 如果可以将 x 恰好 减到 0,返回最小操作数,否则返回 -1
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 1 <= x <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/7
 */
public class Z6SubZero {

    public int minOperations(int[] nums, int x) {
        int left = 0, right = nums.length, currentSum = 0;
        while (left < nums.length && currentSum < x) {
            currentSum += nums[left++];
        }
        if (currentSum == x && left == nums.length) {
            return nums.length;
        }
        if (currentSum < x) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        while (left > 0) {
            while (left > 0 && currentSum > x) {
                currentSum -= nums[--left];
            }
            while (currentSum < x) {
                currentSum += nums[--right];
            }
            if (currentSum == x) {
                result = Math.min(result, left + nums.length - right);
                if (left > 0) {
                    currentSum -= nums[--left];
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Z6SubZero test = new Z6SubZero();
        // 2
        System.out.println(test.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }

}
