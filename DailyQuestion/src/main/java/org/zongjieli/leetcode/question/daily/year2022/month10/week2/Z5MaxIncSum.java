package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

/**
 * 给定一个正整数组成的数组 nums
 * 返回 nums 中一个升序子数组的最大可能元素和
 * 子数组是数组中的一个连续数字序列
 *
 * 已知子数组 [numsL, numsL + 1, ..., numsR - 1, numsR]
 * 若对所有 i(l <= i < r),numsI < numsI + 1 都成立
 * 则称这一子数组为升序子数组,注意,大小为 1 的子数组也视作升序子数组
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z5MaxIncSum {

    public int maxAscendingSum(int[] nums) {
        int result = 0, current = 0, last = 0;
        for (int num : nums) {
            if (num > last) {
                current += num;
            } else {
                result = Math.max(result, current);
                current = num;
            }
            last = num;
        }
        return Math.max(result, current);
    }

    public static void main(String[] args) {
        Z5MaxIncSum test = new Z5MaxIncSum();
        // 60
        System.out.println(test.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }
}
