package org.zongjieli.leetcode.competion.singleweekly.order368;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 如果下标三元组 (i, j, k) 满足下述全部条件,则认为它是一个山形三元组:
 *  i < j < k
 *  nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请找出 nums 中元素和最小的山形三元组,并返回其元素和
 * 如果不存在满足条件的三元组,返回 -1
 *
 * 3 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/22
 */
public class O368N1MountainTuple {

    public int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (b > a) {
                    for (int k = j+ 1; k < nums.length; k++) {
                        int c = nums[k];
                        if (b > c) {
                            result = Math.min(result,  a + b +c);
                        }
                    }
                }
            }
        }
        return result ==  Integer.MAX_VALUE ? -1 : result;
    }
}
