package org.zongjieli.leetcode.question.daily.year2023.month12.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵 n 个节点的树(一个无向、连通、无环图)
 * 每个节点表示一个城市,编号从 0 到 n - 1,且恰好有 n - 1 条路,0 是首都
 * 给定一个二维整数数组 roads,其中 roads[i] = [ai, bi]
 * 表示城市 ai 和 bi 之间有一条双向路
 * 每个城市里有一个代表,他们都要去首都参加一个会议
 * 每座城市里有一辆车,给定一个整数 seats 表示每辆车里面座位的数目
 * 城市里的代表可以选择乘坐所在城市的车,或者乘坐其他城市的车
 * 相邻城市之间一辆车的油耗是一升汽油
 * 请返回到达首都最少需要多少升汽油
 *
 * 1 <= n <= 10^5
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads 表示一棵合法的树
 * 1 <= seats <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/17
 */
public class Z2MinCost {

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) {
            return 0;
        }
        List<Integer>[] sons = new List[roads.length + 1];
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            if (sons[a] == null) {
                sons[a] = new ArrayList<>();
            }
            sons[a].add(b);
            if (sons[b] == null) {
                sons[b] = new ArrayList<>();
            }
            sons[b].add(a);
        }
        boolean[] reaches = new boolean[sons.length];
        reaches[0] = true;
        return count(0, sons, reaches, seats)[1];
    }

    public long[] count(int index, List<Integer>[] sons, boolean[] reaches, int seat) {
        long[] count = new long[]{1, 0};
        for (Integer son : sons[index]) {
            if (!reaches[son]) {
                reaches[son] = true;
                long[] sonCount = count(son, sons, reaches, seat);
                count[0] += sonCount[0];
                count[1] += (sonCount[1] + (sonCount[0] + seat - 1) / seat);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Z2MinCost test = new Z2MinCost();
        // 3
        System.out.println(test.minimumFuelCost(new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5));
        // 7
        System.out.println(test.minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
        // 0
        System.out.println(test.minimumFuelCost(new int[][]{}, 1));
    }

}
