package org.zongjieli.leetcode.question.daily.year2023.month7.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请在该数组中找出和为目标值 target  的那两个整数,并返回它们的数组下标
 * 可以假设每种输入只会对应一个答案,但是数组中同一个元素在答案里不能重复出现
 * 可以按任意顺序返回答案
 *
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/10
 */
public class Z6TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer needIndex = valueIndex.get(target - nums[i]);
            if (needIndex != null) {
                return new int[]{needIndex, i};
            }
            valueIndex.put(nums[i], i);
        }
        return null;
    }

}
