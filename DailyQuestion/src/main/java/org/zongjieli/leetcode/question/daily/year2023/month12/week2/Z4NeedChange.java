package org.zongjieli.leetcode.question.daily.year2023.month12.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * n 座城市,从 0 到 n - 1 编号,其间共有 n - 1 条路线
 * 因此,要想在两座不同城市之间旅行只有唯一一条路线可供选择(路线网形成一颗树)
 * 去年,交通运输部决定重新规划路线,以改变交通拥堵的状况
 * 路线用 connections 表示,其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线
 * 今年,城市 0 将会举办一场大型比赛,很多游客都想前往城市 0
 * 请帮助重新规划路线方向,使每个城市都可以访问城市 0
 * 返回需要变更方向的最小路线数
 * 题目数据保证每个城市在重新规划路线方向后都能到达城市 0
 *
 * 2 <= n <= 5 * 10^4
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n - 1
 * connections[i][0] != connections[i][1]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/7
 */
public class Z4NeedChange {

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] fathers = new List[n];
        List<Integer>[] sons = new List[n];
        for (int[] connection : connections) {
            int son = connection[0], father = connection[1];
            if (fathers[son] == null) {
                fathers[son] = new ArrayList<>();
            }
            fathers[son].add(father);
            if (sons[father] == null) {
                sons[father] = new ArrayList<>();
            }
            sons[father].add(son);
        }
        LinkedList<Integer> trans = new LinkedList<>();
        trans.add(0);
        int result = 0;
        boolean[] reaches = new boolean[n];
        reaches[0] = true;
        while (!trans.isEmpty()) {
            int current = trans.pollFirst();
            if (fathers[current] != null) {
                for (Integer father : fathers[current]) {
                    if (!reaches[father]) {
                        result++;
                        reaches[father] = true;
                        trans.add(father);
                    }
                }
            }
            if (sons[current] != null) {
                for (Integer son : sons[current]) {
                    if (!reaches[son]) {
                        reaches[son] = true;
                        trans.add(son);
                    }
                }
            }
        }
        return result;
    }

}
