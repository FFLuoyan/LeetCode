package org.zongjieli.leetcode.algorithm.primary.array;
/**
 * 给定一个数组 nums,编写一个函数将所有 0 移动到数组的末尾
 * 同时保持非零元素的相对顺序
 *
 * 必须在原数组上操作,不能拷贝额外的数组
 * 尽量减少操作次数
 *
 * @author   Zongjie.Li
 * @date     2021/7/16
 * @version  1.0
 */
public class P08MoveZero {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = -1;
        while (++right < nums.length){
            if (nums[right] != 0){
                nums[left++] = nums[right];
            }
        }
        while (left < nums.length){
            nums[left++] = 0;
        }
    }
}
