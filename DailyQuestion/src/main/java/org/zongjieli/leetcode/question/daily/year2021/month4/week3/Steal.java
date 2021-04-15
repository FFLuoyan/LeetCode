package org.zongjieli.leetcode.question.daily.year2021.month4.week3;
/**
 * 一个专业的小偷,计划偷窃沿街的房屋
 * 每间房内都藏有一定的现金,这个地方所有的房屋都围成一圈
 * 这意味着第一个房屋和最后一个房屋是紧挨着的
 * 同时,相邻的房屋装有相互连通的防盗系统
 * 如果两间相邻的房屋在同一晚上被小偷闯入,系统会自动报警
 *
 * 给定一个代表每个房屋存放金额的非负整数数组
 * 在不触动警报装置的情况下,能够偷窃到的最高金额。
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author   Zongjie.Li
 * @date     2021/4/15
 * @version  1.0
 */
public class Steal {

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(robRange(nums,0,nums.length - 2),robRange(nums,1,nums.length - 1));
    }

    public int robRange(int[] nums,int startIndex,int endIndex) {
        int current = nums[startIndex];
        int wait = 0;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            int temp = wait;
            wait = Math.max(wait,current);
            current = temp + nums[i];
        }
        return Math.max(current,wait);
    }



    public static void main(String[] args) {
        Steal steal = new Steal();
        System.out.println(steal.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
}
