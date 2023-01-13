package org.zongjieli.leetcode.question.daily.year2022.month11.week4;

/**
 * 给定一个整数数组 nums 和两个整数: left 及 right
 * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
 * 并返回满足条件的子数组的个数
 *
 * 生成的测试用例保证结果符合 32-bit 整数范围
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= left <= right <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/13
 */
public class Z4SubArrayCount {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0, lastOver = -1, lastMatch = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                result += (i - lastMatch - 1) * (lastMatch - lastOver);
                lastMatch = lastOver = i;
            } else if (nums[i] >= left) {
                result += (lastMatch - lastOver + 1) * (i - lastMatch);
                lastMatch = i;
            }
        }
        result += (nums.length - lastMatch - 1) * (lastMatch - lastOver);
        return result;
    }

    public static void main(String[] args) {
        Z4SubArrayCount test = new Z4SubArrayCount();
        // 25
        System.out.println(test.numSubarrayBoundedMax(new int[]{1, 2, 1, 3, 3, 2, 1}, 2, 3));
        // 4
        System.out.println(test.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

}
