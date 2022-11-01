package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

/**
 * 给定一个数组 nums,将其划分为两个连续子数组 left 和 right,使得:
 *  left 中的每个元素都小于或等于 right 中的每个元素
 *  left 和 right 都是非空的
 *  left 的长度要尽可能小
 * 在完成这样的分组后返回 left 的 长度
 *
 * 用例可以保证存在这样的划分方法
 *
 * 2 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分
 *
 * @author   Li.zongjie
 * @date     2022/10/24
 * @version  1.0
 */
public class Z1SplitArray {

    public int partitionDisjoint(int[] nums) {
        int max = nums[0], leftMax = max, result = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = max;
                result = i + 1;
            }
        }
        return result;
    }
}
