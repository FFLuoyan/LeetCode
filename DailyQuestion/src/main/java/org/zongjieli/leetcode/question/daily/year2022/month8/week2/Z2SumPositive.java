package org.zongjieli.leetcode.question.daily.year2022.month8.week2;
/**
 * 给定一个整数数组 nums,可以选定任意的正数 startValue 作为初始值
 * 需要从左到右遍历 nums 数组,并将 startValue 依次累加上 nums 数组中的值
 * 请在确保累加和始终大于等于 1 的前提下,选出一个最小的正数作为 startValue
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/8/10
 * @version  1.0
 */
public class Z2SumPositive {

    public int minStartValue(int[] nums) {
        int sum = 0, min = 0;
        for (int num : nums) {
            min = Math.min(min, sum += num);
        }
        return 1 - min;
    }
}
