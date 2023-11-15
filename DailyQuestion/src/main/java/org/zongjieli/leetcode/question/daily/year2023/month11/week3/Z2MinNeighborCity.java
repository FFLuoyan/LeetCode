package org.zongjieli.leetcode.question.daily.year2023.month11.week3;

/**
 * 有 n 个城市,按从 0 到 n - 1 编号
 * 给定一个边数组 edges,其中 edges[i] = [fromII, toI, weightI]
 * 代表 fromI 和 toI 两个城市之间的双向加权边
 * 距离阈值是一个整数 distanceThreshold
 * 返回能通过某些路径到达其他城市数目最少、且路径距离最大为 distanceThreshold 的城市
 * 如果有多个这样的城市,则返回编号最大的城市
 * 注意,连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和
 *
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromI < toI < n
 * 1 <= weightI, distanceThreshold <= 10^4
 * 所有 (fromU, toI) 都是不同的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/14
 */
public class Z2MinNeighborCity {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] weights = new int[n][n];
        for (int[] edge : edges) {
            weights[edge[0]][edge[1]] = edge[2];
            weights[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            int[] currentReach = weights[i];
            currentReach[i] = 1;
            for (int j = 0; j < currentReach.length; j++) {
                if (i != j && currentReach[j] != 0) {
                    calculate(i, j, currentReach[j], weights);
                }
            }
        }
        int result = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentCount = 0;
            for (int j = 0; j < weights[i].length; j++) {
                if (i != j && weights[i][j] <= distanceThreshold) {
                    currentCount++;
                }
            }
            if (currentCount <= minCount) {
                minCount = currentCount;
                result = i;
            }
        }
        return result;
    }

    public void calculate(int start, int currentCity, int beforeCount, int[][] weight) {
        for (int i = 0; i < weight[currentCity].length; i++) {
            int singleDistance = weight[currentCity][i], originDistance, currentDistance;
            if (singleDistance != 0 && ((originDistance = weight[start][i]) > (currentDistance = beforeCount + weight[currentCity][i]) || originDistance == 0)) {
                weight[start][i] = currentDistance;
                weight[i][start] = currentDistance;
                calculate(start, i, currentDistance, weight);
            }
        }
    }

    public static void main(String[] args) {
        Z2MinNeighborCity test = new Z2MinNeighborCity();
        // 3
        System.out.println(test.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
    }
}
