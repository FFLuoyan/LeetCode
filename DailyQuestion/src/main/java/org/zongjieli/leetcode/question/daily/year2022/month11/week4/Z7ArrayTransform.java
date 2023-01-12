package org.zongjieli.leetcode.question.daily.year2022.month11.week4;

/**
 * 给定一个数组 nums,nums 的源数组中,所有元素与 nums 相同,但按非递减顺序排列
 * 如果 nums 能够由源数组轮转若干位置(包括 0 个位置)得到,则返回 true,否则返回 false
 * 源数组中可能存在重复项
 * 注意: 数组 A 在轮转 x 个位置后得到长度相同的数组 B
 * 当它们满足 A[i] == B[(i+x) % A.length],其中 % 为取余运算
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/12
 */
public class Z7ArrayTransform {

    public boolean check(int[] nums) {
        boolean existAdd = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (existAdd) {
                    return false;
                }
                existAdd = true;
            }
        }
        return !existAdd || nums[nums.length - 1] <= nums[0];
    }

}
