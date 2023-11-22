package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

/**
 * 给定一个下标从 0 开始的整数矩阵 grid
 * 矩阵大小为 m x n,由从 0 到 m * n - 1 的不同整数组成
 * 可以在此矩阵中,从一个单元格移动到下一行的任何其他单元格
 * 如果位于单元格 (x, y),且满足 x < m - 1
 * 可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格
 * 注意,在最后一行中的单元格不能触发移动
 * 每次可能的移动都需要付出对应的代价
 * 代价用一个下标从 0 开始的二维数组 moveCost 表示,该数组大小为 (m * n) x n
 * 其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价
 * 从 grid 最后一行的单元格移动的代价可以忽略
 * grid 一条路径的代价是:所有路径经过的单元格的值之和加上所有移动的代价之和
 * 从第一行任意单元格出发,返回到达最后一行任意单元格的最小路径代价
 *
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * grid 由从 0 到 m * n - 1 的不同整数组成
 * moveCost.length == m * n
 * moveCost[i].length == n
 * 1 <= moveCost[i][j] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/22
 */
public class Z3MinPath {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[] minRow = new int[grid[0].length];
        System.arraycopy(grid[0], 0, minRow, 0, grid[0].length);
        for (int i = 1; i < grid.length; i++) {
            int[] nextMin = new int[grid[i].length];
            for (int j = 0; j < nextMin.length; j++) {
                nextMin[j] = minRow[0] + moveCost[grid[i - 1][0]][j];
                for (int k = 1; k < minRow.length; k++) {
                    nextMin[j] = Math.min(nextMin[j], minRow[k] + moveCost[grid[i - 1][k]][j]);
                }
                nextMin[j] += grid[i][j];
            }
            minRow = nextMin;
        }
        int result = Integer.MAX_VALUE;
        for (int i : minRow) {
            result = Math.min(i, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Z3MinPath test = new Z3MinPath();
        // 17
        System.out.println(test.minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }

}
