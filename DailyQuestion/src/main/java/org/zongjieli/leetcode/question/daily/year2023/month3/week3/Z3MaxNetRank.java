package org.zongjieli.leetcode.question.daily.year2023.month3.week3;

/**
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络
 * 每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路
 * 两座不同城市构成的城市对的网络秩定义为:
 *  与这两座城市直接相连的道路总数,如果存在一条道路直接连接这两座城市,则这条道路只计算一次
 * 整个基础设施网络的最大网络秩是所有不同城市对中的最大网络秩
 * 给定整数 n 和数组 roads,返回整个基础设施网络的最大网络秩
 *
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi <= n-1
 * ai != bi
 * 每对城市之间最多只有一条道路相连
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/15
 */
public class Z3MaxNetRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[][] connects = new int[n][n];
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            connects[a][b] = connects[b][a] = 1;
            count[a]++;
            count[b]++;
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = i + 1; j < count.length; j++) {
                result = Math.max(result, count[i] + count[j] - connects[i][j]);
            }
        }
        return result;
    }

}
