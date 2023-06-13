package org.zongjieli.leetcode.question.daily.year2023.month6.week3;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的正整数数组 nums
 * 请找出并统计满足下述条件的三元组 (i, j, k) 的数目:
 *  0 <= i < j < k < nums.length
 *  nums[i]、nums[j] 和 nums[k] 两两不同
 *      即 nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k]
 * 返回满足上述条件三元组的数目
 *
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/13
 */
public class Z2TripletCount {

    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = length * (length - 1) * (length - 2) / 6;
        int start = 0;
        while (start < length) {
            int value = nums[start];
            int count = 1, next = start + 1;
            for (; next < length && nums[next] == value; next++) {
                count++;
            }
            start = next;
            if (count > 1) {
                sum = sum - count * (count - 1) / 2 * (length - count) - count * (count - 1) * (count - 2) / 6;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Z2TripletCount test = new Z2TripletCount();
        // 3
        System.out.println(test.unequalTriplets(new int[]{4, 4, 2, 3, 4}));
    }

}
