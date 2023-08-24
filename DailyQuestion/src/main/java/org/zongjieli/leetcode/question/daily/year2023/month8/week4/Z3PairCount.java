package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

import java.util.*;

/**
 * 给定一个无向图,无向图由整数 n 和数组 edges 组成
 * 其中 n 表示图中节点的数目,edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边
 * 同时给定一个代表查询的整数数组 queries
 * 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目:
 *  a < b
 *  cnt 是与 a 或者 b 相连的边的数目,且 cnt 严格大于 queries[j]
 * 请返回一个数组 answers,其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案
 * 请注意,图中可能会有重复边
 *
 * 2 <= n <= 2 * 10^4
 * 1 <= edges.length <= 10^5
 * 1 <= ui, vi <= n
 * ui != vi
 * 1 <= queries.length <= 20
 * 0 <= queries[j] < edges.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/23
 */
public class Z3PairCount {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] pointCount = new int[n];
        Map<Integer, Integer> existCount = new HashMap<>();
        int a, b;
        for (int[] edge : edges) {
            pointCount[a = (edge[0] - 1)]++;
            pointCount[b = (edge[1] - 1)]++;
            existCount.merge((Math.min(a, b) << 15) + Math.max(a, b), 1, Integer::sum);
        }

        int[] origin = new int[pointCount.length];
        System.arraycopy(pointCount, 0, origin, 0, pointCount.length);
        Arrays.sort(pointCount);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i], left = 0, right = n - 1, need;
            while (left < right) {
                need = query - pointCount[right];
                while (left < right && pointCount[left] <= need) {
                    left++;
                }
                result[i] += (right - left);
                right--;
            }
            for (Map.Entry<Integer, Integer> entry : existCount.entrySet()) {
                int k = entry.getKey(), min = k >> 15, max = k & 32767, pMin = origin[min], pMax = origin[max];
                if (pMin + pMax > query && pMin + pMax - entry.getValue() <= query) {
                    result[i]--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Z3PairCount test = new Z3PairCount();
        // [6, 5]
        System.out.println(Arrays.toString(test.countPairs(4, new int[][]{{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}}, new int[]{2, 3})));
        // [10, 10, 9, 8, 6]
        System.out.println(Arrays.toString(test.countPairs(5, new int[][]{{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}}, new int[]{1, 2, 3, 4, 5})));
    }

}
