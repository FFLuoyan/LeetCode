package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请在该数组中找出和为目标值 target 的那两个整数,并返回它们的数组下标
 *
 * 可以假设每种输入只会对应一个答案
 * 但是,数组中同一个元素在答案里不能重复出现
 *
 * 可以按任意顺序返回答案。
 *
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 * 只会存在一个有效答案
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P09TwoNumberSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> save = new HashMap<>(2 * nums.length);
        for (int i = 0 ; i < nums.length ; i++){
            int search = target - nums[i];
            Integer index = save.get(search);
            if (index != null){
                return new int[]{index,i};
            }
            save.put(nums[i],i);
        }
        return null;
    }
}
