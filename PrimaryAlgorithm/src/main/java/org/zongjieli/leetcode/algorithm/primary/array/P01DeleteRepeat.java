package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * 给定一个排序数组,在原地删除重复出现的元素,使得每个元素只出现一次
 * 返回移除后数字的新长度
 *
 * @author Zongjie.Li
 * @date 2020/11/10
 * @version 1.0
 **/
public class P01DeleteRepeat {
    public int removeDuplicates(int[] nums) {
        int lastIndex = 0;
        for (int i = 1 ; i < nums.length; i++){
            int compareValue = nums[i];
            if (nums[lastIndex] != compareValue){
                nums[++lastIndex] = compareValue;
            }
        }
        return lastIndex + 1;
    }

    public static void main(String[] args) {
        P01DeleteRepeat test = new P01DeleteRepeat();
        System.out.println(test.removeDuplicates(new int[]{1,1,1}));
        System.out.println(test.removeDuplicates(new int[]{1,1,1,2,2,3,3,3,3,3,4}));
    }
}
