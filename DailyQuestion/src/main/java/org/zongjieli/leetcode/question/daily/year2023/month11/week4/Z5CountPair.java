package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target
 * 请返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目
 *
 * 1 <= nums.length == n <= 50
 * -50 <= nums[i], target <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/24
 */
public class Z5CountPair {

    public int countPairs(List<Integer> nums, int target) {
        int[] values = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            values[i] = nums.get(i);
        }
        int result = 0, start = 0, end = values.length - 1, sv;
        Arrays.sort(values);
        while (start < end) {
            sv = values[start];
            while (end > start && sv + values[end] >= target) {
                end--;
            }
            result += end - start++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z5CountPair test = new Z5CountPair();
        // 3
        System.out.println(test.countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2));
    }

}
