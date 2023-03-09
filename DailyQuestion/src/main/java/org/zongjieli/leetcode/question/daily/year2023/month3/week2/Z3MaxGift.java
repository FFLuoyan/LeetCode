package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物
 * 每个礼物都有一定的价值(价值大于 0)
 * 可以从棋盘的左上角开始拿格子里的礼物
 * 每次向右或者向下移动一格、直到到达棋盘的右下角
 * 给定一个棋盘及其上面的礼物的价值
 * 请计算最多能拿到多少价值的礼物
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/8
 */
public class Z3MaxGift {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] max = new int[m][n];
        return maxValue(grid, max, m - 1, n - 1);
    }

    public int maxValue(int[][] grid, int[][] max, int i, int j) {
        return i < 0 || j < 0
                ? 0
                : max[i][j] > 0
                    ? max[i][j]
                    : (max[i][j] = Math.max(maxValue(grid, max, i - 1, j), maxValue(grid, max, i, j - 1)) + grid[i][j]);
    }
}
