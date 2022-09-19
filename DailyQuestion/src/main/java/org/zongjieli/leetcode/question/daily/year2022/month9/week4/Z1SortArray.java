package org.zongjieli.leetcode.question.daily.year2022.month9.week4;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums
 * 请将数组按照每个值的频率升序排序
 * 如果有多个值的频率相同,请按照数值本身将它们降序排序
 * 请返回排序后的数组
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/9/19
 * @version  1.0
 */
public class Z1SortArray {

    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (count[nums[i] + 100] > count[nums[j] + 100] || (count[nums[i] + 100] == count[nums[j] + 100] && nums[i] < nums[j])) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Z1SortArray test = new Z1SortArray();
        // [2, 2, 1, 1, 3, 3, 3]
        System.out.println(Arrays.toString(test.frequencySort(new int[]{1, 1, 2, 2, 3, 3, 3})));
    }
}
