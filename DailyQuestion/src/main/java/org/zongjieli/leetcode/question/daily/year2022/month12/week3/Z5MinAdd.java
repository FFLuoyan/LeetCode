package org.zongjieli.leetcode.question.daily.year2022.month12.week3;

/**
 * 给定一个整数数组 nums,和两个整数 limit 与 goal
 * 数组 nums 有一条重要属性: abs(nums[i]) <= limit
 * 返回使数组元素总和等于 goal 所需要向数组中添加的最少元素数量
 * 添加元素不应改变数组中 abs(nums[i]) <= limit 这一属性
 * 注意,如果 x >= 0,那么 abs(x) 等于 x,否则等于 -x
 *
 * 1 <= nums.length <= 10^5
 * 1 <= limit <= 10^6
 * -limit <= nums[i] <= limit
 * -10^9 <= goal <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z5MinAdd {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) ((Math.abs(sum - goal) + limit - 1) / limit);
    }

}
