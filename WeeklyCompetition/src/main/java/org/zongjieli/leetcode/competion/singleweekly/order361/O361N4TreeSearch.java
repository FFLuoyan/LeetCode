package org.zongjieli.leetcode.competion.singleweekly.order361;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 现有一棵由 n 个节点组成的无向树,节点按从 0 到 n - 1 编号
 * 给定一个整数 n 和一个长度为 n - 1 的二维整数数组 edges
 * 其中 edges[i] = [ui, vi, wi] 表示树中存在一条位于节点 ui 和节点 vi 之间、权重为 wi 的边
 * 另给定一个长度为 m 的二维整数数组 queries,其中 queries[i] = [ai, bi]
 * 对于每条查询,请找出使从 ai 到 bi 路径上每条边的权重相等所需的最小操作次数
 * 在一次操作中,可以选择树上的任意一条边,并将其权重更改为任意值
 * 注意:
 *  查询之间相互独立的,这意味着每条新的查询时,树都会回到初始状态
 *  从 ai 到 bi的路径是一个由不同节点组成的序列,从节点 ai 开始,到节点 bi 结束,且序列中相邻的两个节点在树中共享一条边
 * 返回一个长度为 m 的数组 answer,其中 answer[i] 是第 i 条查询的答案
 *
 * 1 <= n <= 10^4
 * edges.length == n - 1
 * edges[i].length == 3
 * 0 <= ui, vi < n
 * 1 <= wi <= 26
 * 生成的输入满足 edges 表示一棵有效的树
 * 1 <= queries.length == m <= 2 * 10^4
 * queries[i].length == 2
 * 0 <= ai, bi < n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/4
 */
public class O361N4TreeSearch {

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int[] fathers = new int[n], weight = new int[n], level = new int[n], temp, result = new int[queries.length];
        int a, b, c;
        LinkedList<int[]> wait = new LinkedList<>();
        for (int[] edge : edges) {
            a = edge[0];
            b = edge[1];
            c = edge[2];
            if (a == 0) {
                weight[b] = c;
                level[b] = 1;
            } else if (b == 0) {
                weight[a] = c;
                level[a] = 1;
            } else {
                wait.add(edge);
            }
        }
        while (!wait.isEmpty()) {
            temp = wait.pollFirst();
            a = temp[0];
            b = temp[1];
            c = temp[2];
            if (weight[a] > 0) {
                fathers[b] = a;
                weight[b] = c;
                level[b] = level[a] + 1;
            } else if (weight[b] > 0) {
                fathers[a] = b;
                weight[a] = c;
                level[a] = level[b] + 1;
            } else {
                wait.add(temp);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] compute = new int[27];
            a = queries[i][0];
            b = queries[i][1];
            if (level[a] > level[b]) {
                c = a;
                a = b;
                b = c;
            }
            while (level[b] > level[a]) {
                compute[weight[b]]++;
                b = fathers[b];
            }
            while (a != b) {
                compute[weight[a]]++;
                compute[weight[b]]++;
                a = fathers[a];
                b = fathers[b];
            }
            int max = 0, sum = 0;
            for (int j : compute) {
                max = Math.max(max, j);
                sum += j;
            }
            result[i] = sum - max;
        }
        return result;
    }

    public static void main(String[] args) {
        O361N4TreeSearch test = new O361N4TreeSearch();
        // [0, 0, 1, 3]
        System.out.println(Arrays.toString(test.minOperationsQueries(7, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 4, 2}, {4, 5, 2}, {5, 6, 2}}, new int[][]{{0, 3}, {3, 6}, {2, 6}, {0, 6}})));
        // [1, 2, 2, 3]
        System.out.println(Arrays.toString(test.minOperationsQueries(8, new int[][]{{1, 2, 6}, {1, 3, 4}, {2, 4, 6}, {2, 5, 3}, {3, 6, 6}, {3, 0, 8}, {7, 0, 2}}, new int[][]{{4, 6}, {0, 4}, {6, 5}, {7, 4}})));
        // [1, 2, 1, 1, 0, 1, 1, 0, 2, 0]
        System.out.println(Arrays.toString(test.minOperationsQueries(10, new int[][]{{9, 7, 1}, {5, 9, 2}, {0, 9, 4}, {3, 9, 5}, {1, 9, 5}, {4, 0, 4}, {2, 0, 2}, {8, 7, 4}, {6, 3, 2}}, new int[][]{{4, 3}, {8, 1}, {9, 6}, {7, 0}, {1, 1}, {5, 0}, {4, 8}, {3, 6}, {8, 2}, {9, 7}})));
    }

}
