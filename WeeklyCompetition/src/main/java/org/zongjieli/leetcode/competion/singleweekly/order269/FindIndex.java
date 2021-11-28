package org.zongjieli.leetcode.competion.singleweekly.order269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个下标从 0 开始的整数数组 nums 以及一个目标元素 target
 * 目标下标是一个满足 nums[i] == target 的下标 i
 * 将 nums 按非递减顺序排序后
 * 返回由 nums 中目标下标组成的列表
 * 如果不存在目标下标,返回一个空列表
 * 返回的列表必须按递增顺序排列
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i], target <= 100
 *
 * @author   Li.zongjie
 * @date     2021/11/28
 * @version  1.0
 */
public class FindIndex {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                result.add(i);
            }
        }
        return result;
    }
}
