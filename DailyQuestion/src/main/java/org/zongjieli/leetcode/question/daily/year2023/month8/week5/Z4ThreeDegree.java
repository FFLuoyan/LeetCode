package org.zongjieli.leetcode.question.daily.year2023.month8.week5;

/**
 * 给定一个无向图,整数 n 表示图中节点的数目,edges 数组表示图中的边
 * 其中 edges[i] = [ui, vi], 表示 ui 和 vi 之间有一条无向边
 * 一个连通三元组指的是三个节点组成的集合且这三个点之间两两有边
 * 连通三元组的度数是所有满足此条件的边的数目:
 *  一个顶点在这个三元组内,而另一个顶点不在这个三元组内
 * 请返回所有连通三元组中度数的最小值,如果图中没有连通三元组,那么返回 -1
 *
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 图中没有重复的边。
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/31
 */
public class Z4ThreeDegree {

    public int minTrioDegree(int n, int[][] edges) {
        int[][] relation = new int[n + 1][n + 1];
        int a, b;
        for (int[] edge : edges) {
            relation[a = edge[0]][b = edge[1]] = 1;
            relation[b][a] = 1;
            relation[a][0]++;
            relation[b][0]++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            int[] row = relation[i];
            for (int j = i + 1 ; j <= n ; j++) {
                if (row[j] == 1) {
                    for (int k = j + 1 ; k <= n ; k++) {
                        if (row[k] == 1 && relation[j][k] == 1) {
                            result = Math.min(result, row[0] + relation[j][0] + relation[k][0] - 6);
                        }
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
