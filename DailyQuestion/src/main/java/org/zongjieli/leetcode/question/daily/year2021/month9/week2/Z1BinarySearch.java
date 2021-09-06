package org.zongjieli.leetcode.question.daily.year2021.month9.week2;
/**
 * 给定一个 n 个元素有序的(升序)整型数组 nums 和一个目标值 target
 * 写一个函数搜索 nums 中的 target,如果目标值存在返回下标,否则返回 -1
 *
 * 你可以假设 nums 中的所有元素是不重复的
 * n 将在 [1, 10000]之间
 * nums 的每个元素都将在 [-9999, 9999]之间
 *
 * @author   Li.zongjie
 * @date     2021/9/6
 * @version  1.0
 */
public class Z1BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int compareIndex = (left + right) / 2;
            int compare = nums[compareIndex];
            if (compare == target){
                return compareIndex;
            }
            if (compare < target){
                left = compareIndex + 1;
            } else {
                right = compareIndex - 1;
            }
        }
        return -1;
    }
}
