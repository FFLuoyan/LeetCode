package org.zongjieli.leetcode.question.daily.year2022.month1.week3;

import java.util.*;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k
 * 定义一对值 (u,v),其中第一个元素来自 nums1,第二个元素来自 nums2
 * 请找到和最小的 k 个数对 (u1,v1),(u2,v2),...,(uk,vk)
 *
 * 1 <= nums1.length, nums2.length <= 10^4
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 *
 * @author   Li.zongjie
 * @date     2022/1/14
 * @version  1.0
 */
public class Z5FindSumMin {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[][] pairArray = new int[nums1.length][3];
        int[] pair;
        for (int i = 0; i < nums1.length; i++) {
            (pair = pairArray[i])[0] = i;
            pair[2] = nums1[i] + nums2[0];
        }
        List<List<Integer>> result = new ArrayList<>(k);
        while (result.size() < k && (pair = pairArray[0])[2] != Integer.MAX_VALUE){
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            pair[2] = ++pair[1] == nums2.length ? Integer.MAX_VALUE : nums1[pair[0]] + nums2[pair[1]];
            int replace = 0;
            while (++replace < pairArray.length && pair[2] > pairArray[replace][2]){
                pairArray[replace - 1] = pairArray[replace];
            }
            pairArray[replace - 1] = pair;
        }
        return result;
    }

    public static void main(String[] args) {
        Z5FindSumMin test = new Z5FindSumMin();
        // [1,2],[1,4],[1,6]
        System.out.println(test.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
        // [1,1],[1,1]
        System.out.println(test.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
        // [1,1],[1,1]
        System.out.println(test.kSmallestPairs(new int[]{1,1}, new int[]{1}, 2));
    }
}
