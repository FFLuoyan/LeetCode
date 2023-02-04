package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

/**
 * 给定一个长度为 n 的整数数组 nums,表示由范围 [0, n - 1] 内所有整数组成的一个排列
 * 全局倒置的数目等于满足下述条件不同下标对 (i, j) 的数目:
 *  0 <= i < j < n
 *  nums[i] > nums[j]
 * 局部倒置的数目等于满足下述条件的下标 i 的数目:
 *  0 <= i < n - 1
 *  nums[i] > nums[i + 1]
 * 当数组 nums 中全局倒置的数量等于局部倒置的数量时,返回 true,否则返回 false
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 0 <= nums[i] < n
 * nums 中的所有整数互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/3
 */
public class Z3Inversion {

    public boolean isIdealPermutation(int[] nums) {
        int i = 0, v, l = nums.length;
        while (i < l && (v = (nums[i] - i)) <= 1 && v >= -1) {
            i++;
        }
        return i == l;
    }

}
