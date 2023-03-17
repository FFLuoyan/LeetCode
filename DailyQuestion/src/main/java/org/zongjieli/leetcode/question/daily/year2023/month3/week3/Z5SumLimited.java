package org.zongjieli.leetcode.question.daily.year2023.month3.week3;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组 nums 和一个长度为 m 的整数数组 queries
 * 返回一个长度为 m 的数组 answer
 * 其中 answer[i] 是 nums 中元素之和小于等于 queries[i] 的子序列的最大长度
 * 子序列是由一个数组删除某些元素(也可以不删除)但不改变剩余元素顺序得到的一个数组
 *
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/17
 */
public class Z5SumLimited {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int current = sum, compare = queries[i];
            for (int j = nums.length - 1; j >= 0; j--) {
                if (current > compare) {
                    current -= nums[j];
                } else {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z5SumLimited test = new Z5SumLimited();
        // 2, 3, 4
        System.out.println(Arrays.toString(test.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }

}
