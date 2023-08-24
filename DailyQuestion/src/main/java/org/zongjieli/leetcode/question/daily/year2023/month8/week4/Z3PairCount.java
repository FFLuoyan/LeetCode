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
        int[] pointCount = new int[n + 1], pcc, resultCount, result = new int[queries.length];
        Map<Integer, Integer> existCount = new HashMap<>();
        int a, b, max = 0;
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(++pointCount[a = edge[0]], ++pointCount[b = edge[1]]));
            existCount.merge((Math.min(a, b) << 15) + Math.max(a, b), 1, Integer::sum);
        }

        pcc = new int[max + 1];
        for (int i = 1; i < pointCount.length; i++) {
            max = Math.max(max, ++pcc[pointCount[i]]);
        }

        resultCount = new int[(max *= 2) + 1];
        for (int i = 0; i < pcc.length; i++) {
            if ((a = pcc[i]) == 0) {
                continue;
            }
            resultCount[i << 1] += a * (a - 1) / 2;
            for (int j = i + 1 ; j < pcc.length ; j++) {
                resultCount[i + j] += a * pcc[j];
            }
        }

        existCount.forEach((k, v) -> {
            int sum = pointCount[k >> 15] + pointCount[k & 32767];
            resultCount[sum]--;
            resultCount[sum - v]++;
        });

        for (int i = resultCount.length - 2; i >= 0; i--) {
            resultCount[i] += resultCount[i + 1];
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = queries[i] >= max ? 0 : resultCount[queries[i] + 1];
        }
        return result;

    }

    public static void main(String[] args) {
        Z3PairCount test = new Z3PairCount();
        // [6, 5]
        System.out.println(Arrays.toString(test.countPairs(4, new int[][]{{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}}, new int[]{2, 3})));
        // [10, 10, 9, 8, 6]
        System.out.println(Arrays.toString(test.countPairs(5, new int[][]{{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}}, new int[]{1, 2, 3, 4, 5})));
        // [15, 13, 15, 15, 15, 15, 15, 15, 15, 15, 13, 15, 15, 15, 15, 13, 15, 0, 14, 13]
        System.out.println(Arrays.toString(test.countPairs(6, new int[][]{{5, 2}, {3, 5}, {4, 5}, {1, 5}, {1, 4}, {3, 5}, {2, 6}, {6, 4}, {5, 6}, {4, 6}, {6, 2}, {2, 6}, {5, 4}, {6, 1}, {6, 1}, {2, 5}, {1, 3}, {1, 3}, {4, 5}}, new int[]{6, 9, 2, 1, 2, 3, 6, 6, 6, 5, 9, 7, 0, 4, 5, 9, 1, 18, 8, 9})));
        // [10, 8, 10, 10, 8, 8, 10, 10, 10, 10, 8, 10, 10, 8, 10, 8, 8, 3]
        System.out.println(Arrays.toString(test.countPairs(5, new int[][]{{4, 5}, {1, 3}, {1, 4}}, new int[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 2})));
    }

}
