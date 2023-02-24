package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 给定一个非负整数数组 nums,在一步操作中必须:
 *  选出一个正整数 x,x 需要小于或等于 nums 中最小的非零元素
 *  nums 中的每个正整数都减去 x
 * 返回使 nums 中所有元素都等于 0 需要的最少操作数
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/24
 */
public class Z5ArrayZero {

    public int minimumOperations(int[] nums) {
        boolean[] exists = new boolean[101];
        int result = 0;
        for (int num : nums) {
            if (!exists[num]) {
                exists[num] = true;
                result++;
            }
        }
        return exists[0] ? result - 1 : result;
    }

}
