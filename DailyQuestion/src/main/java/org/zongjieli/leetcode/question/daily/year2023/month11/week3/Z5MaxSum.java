package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

import java.util.*;

/**
 * 给定两个长度为 n、下标从 0 开始的整数数组 nums1 和 nums2
 * 另给定一个下标从 1 开始的二维数组 queries,其中 queries[i] = [xi, yi]
 * 对于第 i 个查询,在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中
 * 找出 nums1[j] + nums2[j] 的最大值,如果不存在满足条件的 j 则返回 -1
 * 返回数组 answer,其中 answer[i] 是第 i 个查询的答案
 *
 * nums1.length == nums2.length
 * n == nums1.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^9
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * xi == queries[i][1]
 * yi == queries[i][2]
 * 1 <= xi, yi <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/17
 */
public class Z5MaxSum {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int length = nums1.length;
        int[][] values = new int[length][2];
        for (int i = 0; i < length; i++) {
            values[i][0] = nums1[i];
            values[i][1] = nums2[i];
        }
        Arrays.sort(values, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int x = values[length - 1][0], y = values[length - 1][1], sum;
        TreeMap<Integer, TreeMap<Integer, Integer>> xMap = new TreeMap<>();
        TreeMap<Integer, Integer> yMap = new TreeMap<>();
        yMap.put(y, x + y);
        xMap.put(x, yMap);
        Map.Entry<Integer, TreeMap<Integer, Integer>> xEntry;
        Map.Entry<Integer, Integer> yEntry;
        for (int i = length - 2; i >= 0; i--) {
            if ((x = values[i][0]) == values[i + 1][0]) {
                continue;
            }
            yMap = xMap.ceilingEntry(x).getValue();
            yEntry = yMap.ceilingEntry(y = values[i][1]);
            if (yEntry != null) {
                continue;
            }
            yMap = new TreeMap<>(yMap);
            sum = x + y;
            while (!yMap.isEmpty()) {
                yEntry = yMap.lastEntry();
                if (yEntry.getValue() <= sum) {
                    yMap.pollLastEntry();
                } else {
                    break;
                }
            }
            yMap.put(y, sum);
            xMap.put(x, yMap);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = (xEntry = xMap.ceilingEntry(queries[i][0])) == null || (yEntry = xEntry.getValue().ceilingEntry(queries[i][1])) == null ? -1 : yEntry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Z5MaxSum test = new Z5MaxSum();
        // [-1]
//        System.out.println(Arrays.toString(test.maximumSumQueries(new int[]{2, 1}, new int[]{2, 3}, new int[][]{{3, 3}})));
//        // [6, 10, 7]
//        System.out.println(Arrays.toString(test.maximumSumQueries(new int[]{4, 3, 1, 2}, new int[]{2, 4, 9, 5}, new int[][]{{4, 1}, {1, 3}, {2, 5}})));
        int[] nums1 = new int[100000];
        int[] nums2 = new int[100000];
        int[][] queries = new int[100000][2];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = i;
            nums2[i] = 1;
            queries[i][0] = 1;
            queries[i][1] = 2;
        }
        nums2[0] = 2;
        // [-1]
        System.out.println(Arrays.toString(test.maximumSumQueries(nums1, nums2, queries)));
    }
}
