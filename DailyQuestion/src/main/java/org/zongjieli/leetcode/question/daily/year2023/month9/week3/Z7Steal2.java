package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

/**
 * 一个专业的小偷,计划偷窃沿街的房屋,每间房内都藏有一定的现金
 * 这个地方所有的房屋都围成一圈,这意味着第一个房屋和最后一个房屋是紧挨着的
 * 同时,相邻的房屋装有相互连通的防盗系统,如果两间相邻的房屋在同一晚上被小偷闯入,系统会自动报警
 * 给定一个代表每个房屋存放金额的非负整数数组,计算在不触动警报装置的情况下,今晚能够偷窃到的最高金额
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/21
 */
public class Z7Steal2 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int steal = 0, wait = 0, temp, result;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = wait + nums[i];
            wait = Math.max(steal, wait);
            steal = temp;
        }
        result = Math.max(steal, wait);
        steal = 0;
        wait = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = wait + nums[i];
            wait = Math.max(steal, wait);
            steal = temp;
        }
        return Math.max(result, Math.max(steal, wait));
    }

}
