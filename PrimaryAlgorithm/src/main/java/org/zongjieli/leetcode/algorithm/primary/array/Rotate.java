package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;

/**
 * @ClassName: Rotate
 * @Description: 给定一个数组,将数组中的元素向右移动 k 个位置,其中 k 是非负数。
 * @Author: Zongjie.Li
 * @Date: 2020/11/12
 * @Version: 1.0
 **/
public class Rotate {

    /**
     * 解题思路
     *
     * 根据移动距离将整个数组分为两个部分
     * ├───0───┤├──1───────2───┤
     * 将数组移动即相当于交换两个数组的位置
     * ├──1───────2───┤├───0───┤
     * 数组内的顺序不变
     *
     * 完成这项工作可以分成几个步骤
     *
     * 第一步
     * 将数组 0 与 数组 2 依次交换位置(数组 2 长度与数组 0 相等)
     * ├───2───┤├──1───────0───┤
     * 次数数组 0 内的数据均在正确的位置
     * 第二步,循环执行数组
     * ├───2───┤├──1──┤
     */

    public void rotate(int[] nums, int k) {
        int rightChange = k % nums.length;
        if (rightChange == 0){
            return;
        }
        change(nums,0,nums.length - rightChange - 1,nums.length - 1);
    }

    public void change(int[] nums, int beginIndex,int middleIndex,int endIndex){
        int leftSize = middleIndex - beginIndex + 1;
        int rightSize = endIndex - middleIndex;
        if (leftSize == rightSize){
            changeOnly(nums,beginIndex,middleIndex + 1 , rightSize);
            return;
        }
        if (leftSize > rightSize){
            changeOnly(nums,beginIndex,middleIndex + 1, rightSize);
            change(nums,beginIndex + rightSize,middleIndex,endIndex);
            return;
        }
        int rightStartIndex = endIndex - leftSize + 1;
        changeOnly(nums,beginIndex,rightStartIndex,leftSize);
        change(nums,beginIndex,middleIndex,rightStartIndex - 1);
    }

    public void changeOnly(int[] nums, int firstStartIndex,int secondStartIndex,int size){
        for (int i = 0 ; i < size ; i++){
            int temp = nums[firstStartIndex + i];
            nums[firstStartIndex + i] = nums[secondStartIndex + i];
            nums[secondStartIndex + i] = temp;
        }
    }

    public void rotateByLoop(int[] nums, int k) {
        int leftChange = nums.length - (k % nums.length);
        if (leftChange == 0){
            return;
        }
        int count = 0;
        for (int startIndex = 0 ; count < nums.length; startIndex++){
            for (int index = startIndex,tempSave = nums[index];;){
                count++;
                int changeIndex = (index + leftChange) % nums.length;
                if (changeIndex == startIndex){
                    nums[index] = tempSave;
                    break;
                }
                nums[index] = nums[changeIndex];
                index = changeIndex;
            }
        }
    }

    public void rotateByReverse(int[] nums, int k) {
        int rightChange = k % nums.length;
        if (rightChange == 0){
            return;
        }

        reverse(nums,0,nums.length - 1);
        reverse(nums,0,rightChange - 1);
        reverse(nums,rightChange,nums.length - 1);
    }

    public void reverse(int[] nums,int startIndex,int endIndex){
        for (;startIndex < endIndex ; startIndex++,endIndex--){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
        }
    }


    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] test = new int[]{1,2,3,4,5,6,7,8};
//        int[] test = new int[]{1,2};
        System.out.println(Arrays.toString(test));
//        rotate.rotate(test,6);
        rotate.rotateByReverse(test,3);
        System.out.println(Arrays.toString(test));
    }
}
