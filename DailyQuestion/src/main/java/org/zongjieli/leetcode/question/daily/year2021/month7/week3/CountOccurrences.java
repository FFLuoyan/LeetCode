package org.zongjieli.leetcode.question.daily.year2021.month7.week3;
/**
 * 统计一个数字在排序数组中出现的次数
 *
 * 0 <= 数组长度 <= 50000
 *
 * @author   Zongjie.Li
 * @date     2021/7/16
 * @version  1.0
 */
public class CountOccurrences {
    public int search(int[] nums, int target) {
        int count = 0;
        int index = -1;
        while (++index < nums.length){
            if (nums[index] == target){
                count++;
            } else if (nums[index] > target){
                break;
            }
        }
        return count;
    }
}
