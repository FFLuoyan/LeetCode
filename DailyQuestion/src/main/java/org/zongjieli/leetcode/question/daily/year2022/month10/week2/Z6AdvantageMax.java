package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

import java.util.Arrays;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，
 * nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述
 * 返回 nums1 的任意排列,使其相对于 nums2 的优势最大化
 *
 * 1 <= nums1.length <= 10^5
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z6AdvantageMax {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        long[] sort = new long[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            sort[i] = (((long) nums2[i]) << 32) + i;
        }
        Arrays.sort(nums1);
        Arrays.sort(sort);
        int is = 0, ie = nums1.length - 1;
        for (int i = sort.length - 1; i >= 0; i--) {
            nums2[(int) sort[i]] = nums1[ie] > (sort[i] >> 32) ? nums1[ie--] : nums1[is++];
        }
        return nums2;
    }

    public static void main(String[] args) {
        Z6AdvantageMax test = new Z6AdvantageMax();
        // 2, 4, 1, 2, 0
        System.out.println(Arrays.toString(test.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }
}
