package org.zongjieli.leetcode.question.daily.year2021.month4.week2;
/**
 * 已知一个长度为 n 的数组预先按照升序排列
 * 经由 1 到 n 次 旋转后得到输入数组
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]
 * 旋转一次的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
 *
 * 给你一个可能存在重复元素值的数组 nums
 * 它原来是一个升序排列的数组,并按上述情形进行了多次旋转
 * 请你找出并返回数组中的最小元素
 *
 * @author   Zongjie.Li
 * @date     2021/4/9
 * @version  1.0
 */
public class SearchMinInRotatedSortedRepeatArray {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int n : nums){
            min = Math.min(n,min);
        }
        return min;
    }
}
