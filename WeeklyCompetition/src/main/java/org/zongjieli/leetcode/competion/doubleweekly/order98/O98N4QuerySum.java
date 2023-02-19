package org.zongjieli.leetcode.competion.doubleweekly.order98;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个下标从 0 开始的数组 nums1 和 nums2
 * 和一个二维数组 queries 表示一些操作,总共有 3 种类型的操作:
 *  操作类型 1 为 queries[i] = [1, l, r]
 *      需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1,将 1 反转成 0,l 和 r 下标都从 0 开始
 *  操作类型 2 为 queries[i] = [2, p, 0]
 *      对于 0 <= i < n 中的所有下标,令 nums2[i] = nums2[i] + nums1[i] * p
 *  操作类型 3 为 queries[i] = [3, 0, 0]
 *      求 nums2 中所有元素的和
 * 请返回一个数组,包含所有第三种操作类型的答案
 *
 * 1 <= nums1.length,nums2.length <= 10^5
 * nums1.length = nums2.length
 * 1 <= queries.length <= 10^5
 * queries[i].length = 3
 * 0 <= l <= r <= nums1.length - 1
 * 0 <= p <= 10^6
 * 0 <= nums1[i] <= 1
 * 0 <= nums2[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/18
 */
public class O98N4QuerySum {

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> result = new ArrayList<>();
        long sum = 0, count = 0;
        for (int i : nums2) {
            sum += i;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1[i] = -1;
            } else {
                count++;
            }
        }
        for (int[] query : queries) {
            if (query[0] == 1) {
                int end = query[2];
                for (int i = query[1] ; i <= end ; i++) {
                    count += (nums1[i] = -nums1[i]);
                }
            } else if (query[0] == 2){
                sum += count * query[1];
            } else {
                result.add(sum);
            }
        }
        long[] r = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

}
