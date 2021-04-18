package org.zongjieli.leetcode.question.daily.year2021.month4.week3;
/**
 * 给你一个有序数组 nums
 * 请你原地删除重复出现的元素
 * 使每个元素只出现一次
 * 返回删除后数组的新长度
 *
 * 不要使用额外的数组空间
 * 必须在原地修改输入数组
 * 并在使用 O(1) 额外空间的条件下完成
 *
 * 0 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按升序排列
 *
 * @author   Zongjie.Li
 * @date     2021/4/18
 * @version  1.0
 */
public class DeleteDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
