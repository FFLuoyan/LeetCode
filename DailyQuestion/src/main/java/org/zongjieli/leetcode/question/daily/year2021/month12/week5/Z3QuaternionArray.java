package org.zongjieli.leetcode.question.daily.year2021.month12.week5;
/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 返回满足下述条件的不同四元组(a, b, c, d)的数目:
 *  nums[a] + nums[b] + nums[c] == nums[d]
 *  且 a < b < c < d
 *
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2021/12/29
 * @version  1.0
 */
public class Z3QuaternionArray {
    public int countQuadruplets(int[] nums) {
        int result = 0;
        int[] one = new int[101];
        int[] two = new int[201];
        int[] three = new int[301];
        for (int num : nums) {
            result += three[num];
            for (int i = 0 ; i < 201 ; i++){
                if (two[i] != 0){
                    three[i + num] += two[i];
                }
            }

            for (int i = 0 ; i < 101 ; i++){
                if (one[i] != 0){
                    two[i + num] += one[i];
                }
            }
            one[num]++;
        }
        return result;
    }
}
