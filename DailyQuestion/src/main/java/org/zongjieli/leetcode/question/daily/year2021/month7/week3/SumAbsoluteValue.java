package org.zongjieli.leetcode.question.daily.year2021.month7.week3;

import java.util.*;

/**
 * 给你两个正整数数组 nums1 和 nums2,数组的长度都是 n
 * 数组 nums1 和 nums2 的绝对差值和定义为:
 *  所有 |nums1[i] - nums2[i]|(0 <= i < n) 的总和
 *
 * 你可以选用 nums1 中的任意一个元素来替换 nums1 中的至多一个元素以最小化绝对差值和
 * 在替换数组 nums1 中最多一个元素之后返回最小绝对差值和
 *
 * 因为答案可能很大，所以需要对 10^9 + 7 取余后返回
 * |x| 定义为：
 *  如果 x >= 0,值为 x
 *  如果 x <= 0,值为 -x
 *  
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^5
 *
 *
 * @author   Zongjie.Li
 * @date     2021/7/14
 * @version  1.0
 */
public class SumAbsoluteValue {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeMap<Integer, List<Integer>> absMap = new TreeMap<>();
        TreeSet<Integer> nums1Set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            List<Integer> indexes = absMap.computeIfAbsent(abs, k -> new ArrayList<>());
            indexes.add(i);
            nums1Set.add(nums1[i]);
        }
        int max = 0;
        Integer abs = absMap.lastKey();
        while (abs != null && abs > max){
            List<Integer> nums1Indexes = absMap.get(abs);
            for (int index : nums1Indexes) {
                int start = nums2[index] > nums1[index] ? nums1[index] : nums2[index] - abs;
                int end = start + 2 * abs;
                Integer loopKey = nums1Set.ceiling(start);
                while (loopKey != null && loopKey < end) {
                    int updateAbs = Math.abs(nums2[index] - loopKey);
                    max = Math.max(max, abs - updateAbs);
                    loopKey = nums1Set.higher(loopKey);
                }
                if (max >= abs){
                    break;
                }
            }
            abs = absMap.lowerKey(abs);
        }
        long[] result = new long[]{0};
        absMap.forEach((k,v) -> result[0] += k * v.size());
        return (int) ((result[0] - max) % 1000000007);
    }

    public static void main(String[] args) {
        SumAbsoluteValue test = new SumAbsoluteValue();
//        int[] nums1 = new int[]{1,2,3};
//        int[] nums2 = new int[]{2,3,4};
//        int[] nums1 = new int[]{1,7,5};
//        int[] nums2 = new int[]{2,3,5};
        int[] nums1 = new int[100000];
        int[] nums2 = new int[100000];
        Random random = new Random();
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = random.nextInt(100000);
            nums2[i] = random.nextInt(100000);
        }
        System.out.println(test.minAbsoluteSumDiff(nums1,nums2));
    }
}
