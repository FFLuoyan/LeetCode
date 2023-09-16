package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

/**
 * 一个专业的小偷,计划偷窃沿街的房屋
 * 每间房内都藏有一定的现金,影响偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
 * 如果两间相邻的房屋在同一晚上被小偷闯入,系统会自动报警
 * 给定一个代表每个房屋存放金额的非负整数数组,计算不触动警报装置的情况下,一夜之内能够偷窃到的最高金额
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/16
 */
public class Z6Steal {

    public int rob(int[] nums) {
        int steal = 0, wait = 0, temp;
        for (int num : nums) {
            temp = wait + num;
            wait = Math.max(steal, wait);
            steal = temp;
        }
        return Math.max(steal, wait);
    }

}
