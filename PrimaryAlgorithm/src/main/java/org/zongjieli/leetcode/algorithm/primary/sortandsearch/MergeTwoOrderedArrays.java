package org.zongjieli.leetcode.algorithm.primary.sortandsearch;

import java.util.Arrays;

/**
 * @ClassName: MergeTwoOrderedArrays
 * @Description: 合并两个有序数组
 * @Author: Zongjie.Li
 * @Date: 2020/3/12
 * @Version: 1.0
 **/
public class MergeTwoOrderedArrays {
    public static void main(String[] args) {
        MergeTwoOrderedArrays mergeTwoOrderedArrays = new MergeTwoOrderedArrays();
        int[] nums1 = new int[]{0, 0, 0, 0};
        int[] nums2 = new int[]{1};
        mergeTwoOrderedArrays.merge(nums1, 0, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[index--] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
        }
        while (n >= 0) {
            nums1[n] = nums2[n--];
        }
    }
}
