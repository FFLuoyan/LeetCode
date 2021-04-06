package org.zongjieli.leetcode.question.daily.year2021.month4.week2;
/**
 *
 * 给你一个有序数组 nums,原地删除重复出现的元素
 * 使每个元素最多出现两次,返回删除后数组的新长度
 *
 * @author   Zongjie.Li
 * @date     2021/4/6
 * @version  1.0
 */
public class DeleteRepeatInPlace {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int size = 2;
        for (int i = 2 ; i < nums.length ; i++){
            if (nums[i] == nums[size - 1] && nums[i] == nums[size - 2]){
                continue;
            }
            nums[size ++] = nums[i];
        }
        return size;
    }

    public static void main(String[] args) {
        DeleteRepeatInPlace delete = new DeleteRepeatInPlace();
        delete.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
