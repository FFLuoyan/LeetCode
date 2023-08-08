package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

/**
 * 给定一个整数数组 nums,一个子数组 [numsL, numsL+1, ..., numsR-1, numsR] 的和的绝对值为
 * abs(numsL + numsL+1 + ... + numsR-1 + numsR)
 * 请找出 nums 中和的绝对值最大的任意子数组(可能为空)并返回该最大值
 * abs(x) 定义如下:
 *  如果 x 是负整数,那么 abs(x) = -x
 *  如果 x 是非负整数,那么 abs(x) = x
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/8
 */
public class Z2MaxAbsSum {

    public int maxAbsoluteSum(int[] nums) {
        int currentSumMax= 0, currentSumMin = 0, resultMax = 0, resultMin = 0;
        for (int num : nums) {
            if (num < 0) {
                currentSumMax = Math.max(currentSumMax + num, 0);
                resultMin = Math.min(resultMin, currentSumMin += num);
            } else {
                currentSumMin= Math.min(currentSumMin + num, 0);
                resultMax = Math.max(resultMax, currentSumMax += num);
            }
        }
        return Math.max(resultMax, Math.abs(resultMin));
    }

    public static void main(String[] args) {
        Z2MaxAbsSum test = new Z2MaxAbsSum();
        // 3
        System.out.println(test.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
    }

}
