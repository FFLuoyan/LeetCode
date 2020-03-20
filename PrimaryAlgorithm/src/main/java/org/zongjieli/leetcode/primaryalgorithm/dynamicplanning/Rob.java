package org.zongjieli.leetcode.primaryalgorithm.dynamicplanning;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Rob
 * @Description: 假设有一个专业的小偷, 要偷取社区的房屋, 不能偷窃相邻的房屋, 请问小偷的最大利益是多少
 * @Author: Zongjie.Li
 * @Date: 2020/3/20
 * @Version: 1.0
 **/
public class Rob {

    private Map<Integer, Integer> valueMap = new HashMap<>();

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 5, 2, 3, 4, 6, 3, 2, 1, 2, 4, 5, 78, 9, 1, 2, 3, 3, 21, 3, 54, 56, 64, 78, 2, 3, 5, 6, 67, 14, 68, 52, 53, 42, 22, 33, 56, 4, 6, 8, 75, 13, 2, 32, 65, 6, 8, 9, 5, 3, 2, 3, 5, 7, 53, 45, 3, 1, 34, 85, 64, 5, 4, 2, 15, 3, 23, 1, 3, 4, 6, 5, 7, 6, 8, 9, 4, 32, 3, 2, 32, 3, 14, 76, 4, 6, 43, 55, 5, 42, 56, 4, 3, 1, 32, 3, 78, 46, 5, 6, 78, 6, 22, 5, 3, 2, 3, 4, 6, 5}));
      //  System.out.println(rob.rob(new int[]{2, 3, 4, 6, 5, 2, 4, 8, 5, 4, 3, 1, 5, 5, 8, 7, 4, 5, 2, 1, 8, 3, 6, 5, 8, 7, 4, 5, 2, 1, 3, 6, 9, 8, 5, 7, 4, 1, 2, 3, 6, 5}));
    }

    public int rob(int[] nums) {
        return subRob(nums, 0);
    }

    public int subRob(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (index >= nums.length) {
            return 0;
        }
        int nexIndex = index + 2;
        Integer subValue = valueMap.get(nexIndex);
        if (subValue == null) {
            subValue = subRob(nums, nexIndex);
            valueMap.put(nexIndex, subValue);
        }
        int firstRob = nums[index] + subValue;
        System.out.println(" Length: " + nums.length + " Index: " + index + " First Rob: " + firstRob);
        subValue = valueMap.get(++nexIndex);
        if (subValue == null) {
            subValue = subRob(nums, nexIndex);
            valueMap.put(nexIndex, subValue);
        }
        int firstSafe = nums[index + 1] + subValue;
        System.out.println(" Length: " + nums.length + " Index: " + index + " First Safe: " + firstSafe);
        return firstRob > firstSafe ? firstRob : firstSafe;
    }

}
