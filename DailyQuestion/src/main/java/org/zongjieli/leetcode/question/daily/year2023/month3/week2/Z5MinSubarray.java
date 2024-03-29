package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数数组 nums,请移除最短子数组(可以为空)
 * 使得剩余元素的和能被 p 整除,不允许将整个数组都移除
 * 请返回需要移除的最短子数组的长度,如果无法满足题目要求,返回 -1
 * 子数组定义为原数组中连续的一组元素
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= p <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/10
 */
public class Z5MinSubarray {

    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        nums[0] %= p;
        for (int i = 1; i < length; i++) {
            nums[i] = (nums[i] + nums[i - 1]) % p;
        }
        int remain = nums[length - 1];
        if (remain == 0) {
            return 0;
        }
        int result = length;
        Map<Integer, Integer> indexes = new HashMap<>();
        indexes.put(0, -1);
        for (int i = 0; i < length; i++) {
            indexes.put(nums[i], i);
            Integer index = indexes.get((nums[i] - remain + p) % p);
            if (index != null) {
                result = Math.min(result, i - index);
            }
        }
        return result == length ? -1 : result;
    }

    public static void main(String[] args) {
        Z5MinSubarray test = new Z5MinSubarray();
        // 1
        System.out.println(test.minSubarray(new int[]{3, 1, 4, 2}, 6));
        // 7
        System.out.println(test.minSubarray(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148));
    }

}
