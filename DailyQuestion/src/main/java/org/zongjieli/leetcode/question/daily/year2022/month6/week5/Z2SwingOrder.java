package org.zongjieli.leetcode.question.daily.year2022.month6.week5;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums,将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
 * 可以假设所有输入数组都可以得到满足题目要求的结果
 *
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证,对于给定的输入 nums,总能产生满足题目要求的结果
 *
 * 用 O(n) 时间复杂度或原地 O(1) 额外空间来实现
 *
 * @author   Li.zongjie
 * @date     2022/6/28
 * @version  1.0
 */
public class Z2SwingOrder {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        for (int i = 1 ; i < nums.length ; i += 2) {
            result[i] = nums[index--];
        }
        for (int i = 0 ; i < nums.length ; i += 2) {
            result[i] = nums[index--];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Z2SwingOrder test = new Z2SwingOrder();
        int[] e1 = new int[]{1, 1, 1, 4, 5, 6};
        test.wiggleSort(e1);
        System.out.println(Arrays.toString(e1));
    }

}
