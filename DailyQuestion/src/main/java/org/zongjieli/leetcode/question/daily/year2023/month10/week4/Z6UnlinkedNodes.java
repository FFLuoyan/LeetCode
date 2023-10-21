package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

/**
 * 给定一个整数 n,表示一张无向图中有 n 个节点,编号为 0 到 n - 1
 * 同时给定一个二维整数数组 edges,其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条无向边
 * 请返回无法互相到达的不同点对数目
 *
 * 1 <= n <= 10^5
 * 0 <= edges.length <= 2 * 10^5
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不会有重复边
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/21
 */
public class Z6UnlinkedNodes {

    public long countPairs(int n, int[][] edges) {
        int[] group = new int[n], count = new int[n];
        for (int i = 0; i < group.length; i++) {
            group[i] = i;
        }
        int first, second;
        for (int[] edge : edges) {
            first = findFather(group, edge[0]);
            second = findFather(group, edge[1]);
            if (first < second) {
                group[second] = first;
            } else {
                group[first] = second;
            }
        }
        for (int i = 0; i < group.length; i++) {
            count[findFather(group, i)]++;
        }
        long result = 0;
        for (int num : count) {
            result += (long) num * (n - num);
        }
        return result / 2;
    }

    public int findFather(int[] group, int num) {
        while (num != group[num]) {
            num = group[num];
        }
        return num;
    }

    public static void main(String[] args) {
        Z6UnlinkedNodes test = new Z6UnlinkedNodes();
        // 0
        System.out.println(test.countPairs(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        // 14
        System.out.println(test.countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));
        // 0
        System.out.println(test.countPairs(11, new int[][]{{5, 0}, {1, 0}, {10, 7}, {9, 8}, {7, 2}, {1, 3}, {0, 2}, {8, 5}, {4, 6}, {4, 2}}));
    }
}
