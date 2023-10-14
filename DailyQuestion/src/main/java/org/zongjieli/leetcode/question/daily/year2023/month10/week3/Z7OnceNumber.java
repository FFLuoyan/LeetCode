package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums,除某个元素仅出现一次外,其余每个元素都恰出现三次,请找出并返回那个只出现了一次的元素
 * 必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题
 *
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中,除某个元素仅出现一次外,其余每个元素都恰出现三次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/15
 */
public class Z7OnceNumber {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 3) {
            if (nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

}
