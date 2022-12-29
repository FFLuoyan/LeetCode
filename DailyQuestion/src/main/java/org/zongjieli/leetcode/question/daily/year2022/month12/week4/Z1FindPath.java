package org.zongjieli.leetcode.question.daily.year2022.month12.week4;

import java.util.*;

/**
 * 有一个具有 n 个顶点的双向图
 * 其中每个顶点标记从 0 到 n - 1(包含 0 和 n - 1)
 * 图中的边用一个二维整数数组 edges 表示
 * 其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边
 * 每个顶点对由最多一条边连接,并且没有顶点存在与自身相连的边
 * 请确定是否存在从顶点 source 开始,到顶点 destination 结束的有效路径
 * 给定数组 edges 和整数 n、source 和 destination
 * 如果从 source 到 destination 存在有效路径,则返回 true,否则返回 false
 *
 * 1 <= n <= 2 * 10^5
 * 0 <= edges.length <= 2 * 10^5
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * 不存在重复边
 * 不存在指向顶点自身的边
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/29
 */
public class Z1FindPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] checked = new boolean[n];
        checked[source] = true;
        boolean isChange = true;
        while (isChange && !checked[destination]) {
            isChange = false;
            for (int[] edge : edges) {
                if (checked[edge[0]] ^ checked[edge[1]]) {
                    isChange = true;
                    checked[edge[0]] = true;
                    checked[edge[1]] = true;
                }
            }
        }
        return checked[destination];
    }
}
