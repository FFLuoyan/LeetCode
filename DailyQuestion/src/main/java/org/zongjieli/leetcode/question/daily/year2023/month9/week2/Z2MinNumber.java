package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

/**
 * 给定两个只包含 1 到 9 之间数字的数组 nums1 和 nums2
 * 每个数组中的元素互不相同,请返回最小的数字,两个数组都至少包含这个数字的某个数位
 *
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中,元素互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/5
 */
public class Z2MinNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        int num1 = 0, num2 = 0, min1 = 9, min2 = 9;
        for (int i : nums1) {
            num1 |= (1 << i);
            min1 = Math.min(min1, i);
        }
        for (int i : nums2) {
            num2 |= (1 << i);
            min2 = Math.min(min2, i);
        }
        if ((num1 & num2) > 0) {
            num1 &= num2;
            for (int i = 1; i <= 9; i++) {
                if ((num1 & (1 << i)) > 0) {
                    return i;
                }
            }
        }
        return Math.min(min1 * 10 + min2, min2 * 10 + min1);
    }

}
