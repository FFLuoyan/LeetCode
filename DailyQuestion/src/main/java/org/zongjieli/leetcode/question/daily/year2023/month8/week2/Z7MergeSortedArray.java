package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

/**
 * 给定两个按非递减顺序排列的整数数组 nums1 和 nums2
 * 另有两个整数 m 和 n,分别表示 nums1 和 nums2 中的元素数目
 * 请合并 nums2 到 nums1 中,使合并后的数组同样按非递减顺序排列
 * 注意: 最终,合并后数组不应由函数返回,而是存储在数组 nums1 中
 * 为了应对这种情况,nums1 的初始长度为 m + n
 * 其中前 m 个元素表示应合并的元素后 n 个元素为 0,应忽略
 * nums2 的长度为 n
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/13
 */
public class Z7MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            nums1[m + n - 1] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
        while (n > 0) {
            nums1[n - 1] = nums2[--n];
        }
    }
}
