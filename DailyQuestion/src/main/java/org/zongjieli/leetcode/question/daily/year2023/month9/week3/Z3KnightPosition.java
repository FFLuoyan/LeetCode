package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

/**
 * 骑士在一张 n x n 的棋盘上巡视
 * 在有效的巡视方案中,骑士会从棋盘的左上角出发,并且访问棋盘上的每个格子恰好一次
 * 给定一个 n x n 的整数矩阵 grid,由范围 [0, n * n - 1] 内的不同整数组成
 * 其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格
 * 骑士的行动是从下标 0 开始的
 * 如果 grid 表示了骑士的有效巡视方案,返回 true,否则返回 false
 * 注意,骑士行动时可以垂直移动两个格子且水平移动一个格子
 * 或水平移动两个格子且垂直移动一个格子
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/13
 */
public class Z3KnightPosition {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[] position = new int[n * n];
        boolean[] valid = new boolean[n * n];
        valid[n + 2] = true;
        valid[n - 2] = true;
        valid[2 * n - 1] = true;
        valid[2 * n + 1] = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                position[grid[i][j]] = i * n + j;
            }
        }
        for (int i = 1; i < n * n; i++) {
            if (!valid[Math.abs(position[i] - position[i - 1])]) {
                return false;
            }
        }
        return true;
    }

}
