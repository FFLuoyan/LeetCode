package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

/**
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值:
 *  如果 x 是正数,返回 1
 *  如果 x 是负数,返回 -1
 *  如果 x 是等于 0,返回 0
 * 给定一个整数数组 nums,令 product 为数组 nums 中所有元素值的乘积
 *
 * 返回 signFunc(product)
 *
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/11/1
 */
public class Z4NumberFunction {

    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            result *= num > 0 ? 1 : -1;
        }
        return result;
    }
}
