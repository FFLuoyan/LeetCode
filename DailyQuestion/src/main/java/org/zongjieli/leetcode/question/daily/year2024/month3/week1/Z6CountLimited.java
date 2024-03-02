package org.zongjieli.leetcode.question.daily.year2024.month3.week1;

/**
 * 现有一棵由 n 个节点组成的无向树,节点编号从 0 到 n - 1,共有 n - 1 条边
 * 给定一个二维整数数组 edges,长度为 n - 1
 *  其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边
 * 另给定一个整数数组 restricted 表示受限节点
 * 在不访问受限节点的前提下,返回可以从节点 0 到达的最多节点数目
 * 注意,节点 0 不会标记为受限节点
 *
 * 2 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/2
 */
public class Z6CountLimited {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] cant = new boolean[n], reached = new boolean[n];
        for (int i : restricted) {
            cant[i] = true;
        }
        reached[0] = true;
        int result = 1, lastLength = n - 1, currentLength = n - 2, l, r;
        while (currentLength < lastLength) {
            lastLength = currentLength;
            for (int i = 0 ; i <= currentLength ; i++) {
                if (cant[l = edges[i][0]] || cant[r = edges[i][1]]) {
                    edges[i] = edges[currentLength--];
                } else  if (reached[l] || reached[r]) {
                    edges[i] = edges[currentLength--];
                    if (reached[l] ^ reached[r]) {
                        reached[l] = reached[r] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z6CountLimited test = new Z6CountLimited();
        // 4
//        System.out.println(test.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5}));
        // 8
        System.out.println(test.reachableNodes(10, new int[][]{{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}}, new int[]{2, 7}));
    }
}
