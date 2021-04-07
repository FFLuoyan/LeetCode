package org.zongjieli.leetcode.question.daily.year2021.month4.week2;
/**
 * 已知存在一个按非降序排列的整数数组 num
 * 数组中的值不必互不相同
 *
 * 在传递给函数之前,num 预先在未知的某个下标 k(0 <= k <= nums.length) 上进行了旋转
 * 使数组变为 nums[k],nums[k + 1],......,nums[0],nums[1],......nums[k - 1]
 * 给你旋转后的数组 nums 和一个整数 target,请你编写一个函数
 * 来判断目标值是否存在于数组中
 * 如果存在,返回 true,否则返回 false
 *
 * @author   Zongjie.Li
 * @date     2021/4/7
 * @version  1.0
 */
public class SearchRotateSortedArray {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target){
                return true;
            }
        }
        return false;
    }
}
