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
        if (nums.length <= 1){
            return nums.length;
        }
        int size = 1;
        for (int i = 1 ; i < nums.length ;){
            nums[size++] = nums[i++];
            while (i < nums.length && nums[i] == nums[size - 2]){
                i++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        DeleteRepeatInPlace delete = new DeleteRepeatInPlace();
        System.out.println(delete.removeDuplicates(new int[]{1,1,1,1,3,3}));
    }
}
