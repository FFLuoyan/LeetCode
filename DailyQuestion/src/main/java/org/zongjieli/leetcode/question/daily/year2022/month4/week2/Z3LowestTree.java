package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import java.util.*;

/**
 * 树是一个无向图,其中任何两个顶点只通过一条路径连接
 * 换句话说,一个任何没有简单环路的连通图都是一棵树
 * 给定一棵包含 n 个节点的树,标记为 0 到 n - 1
 * 给定数字 n 和一个有 n - 1 条无向边的 edges 列表(每一个边都是一对标签)
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边
 * 可选择树中任何一个节点作为根,当选择节点 x 作为根节点时,设结果树的高度为 h
 * 在所有可能的树中,具有最小高度的树(即,min(h))被称为最小高度树
 * 请找到所有的最小高度树并按任意顺序返回它们的根节点标签列表
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量
 *
 * 1 <= n <= 2 * 10^4
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入保证是一棵树,并且不会有重复的边
 *
 * @author   Li.zongjie
 * @date     2022/4/6
 * @version  1.0
 */
public class Z3LowestTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        int[] treeHeight = new int[n];
        int currentRoot = edges[0][0];
        setTreeSize(tree, treeHeight, currentRoot, -1);
        while (true) {
            Set<Integer> subTree = tree.get(currentRoot);
            // max, maxTree, subMax, subMaxTree
            int[] v = new int[]{-1, -1, -1, -1};
            subTree.forEach(s -> {
                if (treeHeight[s] > v[0]) {
                    v[2] = v[0];
                    v[3] = v[1];
                    v[0] = treeHeight[s];
                    v[1] = s;
                } else if (treeHeight[s] > v[2]) {
                    v[2] = treeHeight[s];
                    v[3] = s;
                }
            });
            if (v[0] == v[2]) {
                return Collections.singletonList(currentRoot);
            }
            if (v[0] == v[2] + 1) {
                return Arrays.asList(currentRoot, v[1]);
            }
            if (v[3] == -1) {
                treeHeight[currentRoot] = 0;
            } else {
                treeHeight[currentRoot] = v[2] + 1;
            }
            currentRoot = v[1];
        }
    }

    public int setTreeSize(Map<Integer, Set<Integer>> tree, int[] treeSize, int current, int parent) {
        Set<Integer> subTree = tree.get(current);
        int[] max = new int[]{-1};
        subTree.forEach(s -> {
            if (s == parent) {
                return;
            }
            max[0] = Math.max(max[0], setTreeSize(tree, treeSize, s, current));
        });
        return treeSize[current] = (max[0] == -1 ? 0 : max[0] + 1);
    }

    public static void main(String[] args) {
        Z3LowestTree test = new Z3LowestTree();
        // [0]
        System.out.println(test.findMinHeightTrees(1, new int[0][0]));
        // [0, 1]
        System.out.println(test.findMinHeightTrees(2, new int[][]{{0, 1}}));
        // [1, 2]
        System.out.println(test.findMinHeightTrees(7, new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
        // [5]
        System.out.println(test.findMinHeightTrees(10, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 4}, {0, 5}, {5, 6}, {6, 7}, {2, 8}, {7, 9}}));
    }
}
