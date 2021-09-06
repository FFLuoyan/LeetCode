package org.zongjieli.leetcode.competion.singleweekly.order257;
/**
 * 给你一个下标从 0 开始的整数数组 nums
 * 返回满足下述条件的不同四元组 (a, b, c, d) 的 数目
 *  nums[a] + nums[b] + nums[c] == nums[d]
 *  且 a < b < c < d
 *
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2021/9/5
 * @version  1.0
 */
public class Quadruplets {
    public int countQuadruplets(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i + 1 ; j < nums.length ; j++){
                for (int k = j + 1 ; k < nums.length;k++){
                    for (int r = k + 1 ; r < nums.length ; r++){
                        if (nums[i] + nums[j] + nums[k] == nums[r]){
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
