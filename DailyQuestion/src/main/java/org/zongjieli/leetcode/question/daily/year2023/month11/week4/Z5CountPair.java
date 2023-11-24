package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

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
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            int need = target - nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < need) {
                    result++;
                }
            }
        }
        return result;
    }

}
