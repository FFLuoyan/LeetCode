package org.zongjieli.leetcode.competion.singleweekly.order362;

/**
 * 给定一个大小为 3 * 3,下标从 0 开始的二维整数矩阵 grid
 * 分别表示每一个格子里石头的数目,网格图中总共恰好有 9 个石头,一个格子里可能会有多个石头
 * 每一次操作中,你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子
 * 请返回每个格子恰好有一个石头的最少移动次数
 *
 * grid.length == grid[i].length == 3
 * 0 <= grid[i][j] <= 9
 * grid 中元素之和为 9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/10
 */
public class O362N3ScatterStone {

    public int minimumMoves(int[][] grid) {
        int need = 0, index;
        long remain = 0, value;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                index = i * 3 + j;
                value = grid[i][j];
                if (value == 0) {
                    need |= (1 << index);
                } else if (value > 1) {
                    remain |= ((value - 1) << (4 * index));
                }
            }
        }
        return minMove(need, remain);
    }

    public int minMove(int needs, long remains) {
        if (needs == 0) {
            return 0;
        }
        int need = findNeed(needs), remainIndex = 0, result = Integer.MAX_VALUE;
        long compare = remains;
        while (compare != 0) {
            if ((compare & 15) != 0) {
                result = Math.min(result, Math.abs(remainIndex / 3 - need / 3) + Math.abs(remainIndex % 3 - need % 3) + minMove(needs - (1 << need), remains - (1L << (4 * remainIndex))));
            }
            remainIndex++;
            compare >>= 4;
        }
        return result;
    }

    private int findNeed(int need) {
        int result = 0, current = 1;
        while ((need & current) == 0) {
            current <<= 1;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        O362N3ScatterStone test = new O362N3ScatterStone();
        // 4
        System.out.println(test.minimumMoves(new int[][]{{1, 3, 0}, {1, 0, 0}, {1, 0, 3}}));
    }
}
