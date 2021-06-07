package org.zongjieli.leetcode.question.daily.year2021.month6.week2;
/**
 * 给一个整数数组 nums 和一个整数 target
 * 向数组中的每个整数前添加 '+' 或 '-',然后串联起所有整数,可以构造一个表达式
 *
 * 例如 nums = [2, 1]
 * 可以在 2 之前添加 '+',在 1 之前添加 '-',然后串联起来得到表达式 "+2-1"
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同表达式的数目
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * @author   Zongjie.Li
 * @date     2021/6/7
 * @version  1.0
 */
public class TargetSum {
    private int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        add(nums, target, 0, 0);
        return result;
    }

    public void add(int[] nums, int target,int index,int temp){
        if (index == nums.length - 1){
            if (temp + nums[index] == target){
                result++;
            }
            if (temp - nums[index] == target){
                result++;
            }
        } else {
            add(nums, target, index + 1, temp + nums[index]);
            add(nums, target, index + 1, temp - nums[index]);
        }
    }
}
