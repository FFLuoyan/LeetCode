package org.zongjieli.leetcode.question.daily.year2022.month2.week2;
/**
 * 给定一个大小为 m x n 的二进制矩阵 grid
 * 其中 0 表示一个海洋单元格,1 表示一个陆地单元格
 * 一次移动是指从一个陆地单元格走到另一个相邻(上、下、左、右)的陆地单元格或跨过 grid 的边界
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 *
 * @author   Li.zongjie
 * @date     2022/3/16
 * @version  1.0
 */
public class Z6EnclaveCount {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0 ; i < columns ; i++) {
            move(grid, 0, i, rows, columns);
            move(grid, rows - 1, i, rows, columns);
        }
        for (int i = 0 ; i < rows ; i++) {
            move(grid, i, 0, rows, columns);
            move(grid, i, columns - 1, rows, columns);
        }
        int result = 0;
        for (int[] r : grid) {
            for (int c : r) {
                if (c == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public void move(int[][] grid, int row, int column, int rows, int columns) {
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] <= 0) {
            return;
        }
        grid[row][column] = -1;
        move(grid, row - 1, column, rows, columns);
        move(grid, row + 1, column, rows, columns);
        move(grid, row, column - 1, rows, columns);
        move(grid, row, column + 1, rows, columns);
    }

    public static void main(String[] args) {
        Z6EnclaveCount test = new Z6EnclaveCount();
        // 3
        System.out.println(test.numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
    }
}
