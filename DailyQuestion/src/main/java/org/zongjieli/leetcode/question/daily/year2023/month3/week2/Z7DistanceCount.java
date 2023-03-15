package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

import java.util.Arrays;

/**
 * 给定 n 个城市,编号为从 1 到 n
 * 同时给定一个大小为 n-1 的数组 edges
 * 其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边
 * 题目保证任意城市之间只有唯一的一条路径,换句话说,所有城市形成了一棵树
 * 一棵子树是城市的一个子集,且子集中任意城市之间可以通过子集中的其他城市和边到达
 * 两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在,但在另一棵子树中不存在
 * 对于 d 从 1 到 n-1,请找到城市间最大距离恰好为 d 的所有子树数目
 * 请返回一个大小为 n-1 的数组,其中第 d 个元素(下标从 1 开始)是城市间最大距离恰好等于 d 的子树数目
 * 请注意,两个城市间距离定义为它们之间需要经过的边的数目
 *
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 题目保证 (ui, vi) 所表示的边互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/12
 */
public class Z7DistanceCount {

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] connects = new int[n];
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            connects[a] |= (1 << b);
            connects[b] |= (1 << a);
        }
        int max = 1 << n;
        int[] result = new int[n - 1];
        for (int i = 1 ; i < max ; i++) {
            int find = findFirst(i);
            int value = i - (1 << find);
            if (value != 0) {
                int reachableDistance = reachableDistance(find, value, connects, 0);
                if (reachableDistance < 256) {
                    result[(reachableDistance >> 4) - 1]++;
                }
            }
        }
        return result;
    }

    public int findFirst(int value) {
        int position = 0;
        while (true) {
            if ((value & (1 << position)) > 0) {
                return position;
            }
            position++;
        }
    }
    public int reachableDistance(int find, int value, int[] connects, int deep) {
        int connect = value & connects[find];
        if (connect == 0) {
            return (value << 8) + (deep << 4);
        }
        value -= connect;
        int a = 0, b = 0, maxDistance = 0, unreachable = value << 8;
        while (connect > 0) {
            int first = findFirst(connect);
            connect -= (1 << first);
            int reachableDistance = reachableDistance(first, value, connects, deep + 1);
            int distance = (reachableDistance & 15) + 1;
            maxDistance = Math.max(maxDistance, (reachableDistance >> 4) & 15);
            unreachable &= reachableDistance;
            if (distance >= a) {
                b = a;
                a = distance;
            } else if (distance >= b) {
                b = distance;
            }
        }
        return unreachable + (Math.max(maxDistance, Math.max(a + deep, a + b)) << 4) + a;
    }

    public static void main(String[] args) {
        Z7DistanceCount test = new Z7DistanceCount();
        // 3, 4, 0
        System.out.println(Arrays.toString(test.countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}})));
        // 3, 2, 1
        System.out.println(Arrays.toString(test.countSubgraphsForEachDiameter(4, new int[][]{{1, 3}, {1, 4}, {2, 3}})));
        // 4, 3, 2, 1
        System.out.println(Arrays.toString(test.countSubgraphsForEachDiameter(5, new int[][]{{1, 2}, {1, 5}, {2, 4}, {3, 5}})));
    }

}
