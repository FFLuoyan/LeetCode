package org.zongjieli.leetcode.question.daily.year2021.month4.week4;
/**
 * 给你一个数组 nums 和一个值 val
 * 你需要原地移除所有数值等于 val 的元素
 * 并返回移除后数组的新长度
 *
 * 元素的顺序可以改变
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 * @author   Zongjie.Li
 * @date     2021/4/19
 * @version  1.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
