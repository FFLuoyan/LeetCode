package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

/**
 * 给定一个下标从 0 开始的整数数组 nums,如果满足下述条件,则认为数组 nums 是一个美丽数组:
 *  nums.length 为偶数
 *  对所有满足 i % 2 == 0 的下标 i,nums[i] != nums[i + 1] 均成立
 * 注意,空数组同样认为是美丽数组
 * 可以从 nums 中删除任意数量的元素
 * 当删除一个元素时,被删除元素右侧的所有元素将会向左移动一个单位以填补空缺,而左侧的元素将会保持不变
 * 返回使 nums 变为美丽数组所需删除的最少元素数目
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/21
 */
public class Z2BeautyArray {

    public int minDeletion(int[] nums) {
        int a = 0, b = 1, result = 0;
        while (b < nums.length) {
            if (nums[a] != nums[b]) {
                a = b + 1;
                b = a + 1;
            } else {
                b++;
                result++;
            }
        }
        if (a < nums.length) {
            result++;
        }
        return result;
    }

}
