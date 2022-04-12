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
        /*
            对于同一个节点的所有子节点,可以将其表达为一个链表
            维护两个数组 value 以及 pre,将所有节点的子节点对应的链表关系全部记录下来
            其中 value 表示对应的子节点,pre 表示当前下标对应的前置下标
            对于链表的头部,其前置下标为 -1
            再维护一个数组 index,用于表达每个节点对应的子节点的链表的尾部
            三个数组就可以记录全部的父子关系
            另外再额外维护一个子节点长度的数组 count,可以简化计算过程
         */
        int[] value = new int[2 * n];
        int[] pre = new int[2 * n];
        int[] index = new int[n];
        Arrays.fill(index, -1);
        int[] count = new int[n];
        // currentIndex
        int ci = 0;
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
            // 节点 edge[0]

            pre[ci] = index[edge[0]];
            index[edge[0]] = ci;
            value[ci++] = edge[1];

            pre[ci] = index[edge[1]];
            index[edge[1]] = ci;
            value[ci++] = edge[0];
        }

        int[] delete = new int[n + 1];
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                delete[delete[n]++] = i;
            }
        }
        int last = 0;
        while (last < n - 2) {
            int end = delete[n];
            for (int i = last ; i < end ; i++) {
                int waitDelete = delete[i];
                ci = index[waitDelete];
                while (ci != -1) {
                    if (--count[value[ci]] == 1) {
                        delete[delete[n]++] = value[ci];
                    }
                    ci = pre[ci];
                }
            }
            last = end;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = last ; i < n ; i++) {
            result.add(delete[i]);
        }
        return result;
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
        // [2]
        System.out.println(test.findMinHeightTrees(15, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {0, 7}, {4, 8}, {5, 9}, {7, 10}, {6, 11}, {0, 12}, {0, 13}, {3, 14}}));
    }
}
