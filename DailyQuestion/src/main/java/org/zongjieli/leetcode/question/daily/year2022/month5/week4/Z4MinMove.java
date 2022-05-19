package org.zongjieli.leetcode.question.daily.year2022.month5.week4;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组 nums,返回使所有数组元素相等需要的最少移动数
 * 在一步操作中,你可以使数组中的一个元素加 1 或者减 1
 *
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/5/19
 * @version  1.0
 */
public class Z4MinMove {

    public int minMoves2(int[] nums) {
        // 求所有数据距中位数的差的和
        Arrays.sort(nums);
        int result = 0;
        int mi = nums.length / 2;
        int middle = nums[mi];
        for (int i = 0 ; i < mi ; i++) {
            result += (middle - nums[i]);
        }
        for (int i = mi + 1 ; i < nums.length ; i++) {
            result += (nums[i] - middle);
        }
        return result;
    }
}
