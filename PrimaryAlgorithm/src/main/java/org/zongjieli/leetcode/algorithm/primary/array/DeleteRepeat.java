package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * @ClassName: DeleteRepeat
 * @Description: 给定一个排序数组,在原地删除重复出现的元素,使得每个元素只出现一次
 *               返回移除后数字的新长度
 * @Author: Zongjie.Li
 * @Date: 2020/11/10
 * @Version: 1.0
 **/
public class DeleteRepeat {
    public int removeDuplicates(int[] nums) {
//        if (nums == null){
//            return 0;
//        }
//        if (nums.length < 2){
//            return nums.length;
//        }

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
        DeleteRepeat deleteRepeat = new DeleteRepeat();
        System.out.println(deleteRepeat.removeDuplicates(new int[]{1,1,1}));
        System.out.println(deleteRepeat.removeDuplicates(new int[]{1,1,1,2,2,3,3,3,3,3,4}));
    }
}
