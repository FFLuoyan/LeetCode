package org.zongjieli.leetcode.question.daily.year2022.month1.month.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 请你返回数对 (i, j) 的数目
 * 满足 i < j 且 |nums[i] - nums[j]| == k
 *
 * |x| 的值定义为:
 *  如果 x >= 0,那么值为 x
 *  如果 x < 0,那么值为 -x
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *
 * @author   Li.zongjie
 * @date     2022/2/9
 * @version  1.0
 */
public class Z3DifferentK {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        int result = 0;
        for (int num : nums) {
            result += count.getOrDefault(num - k, 0);
            result += count.getOrDefault(num + k, 0);
            count.merge(num, 1, Integer::sum);
        }
        return result;
    }
}
