package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

/**
 * 在一个 n x n 的矩阵 grid 中,除了在数组 mines 中给出的元素为 0,其他每个元素都为 1
 * mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * 返回 grid 中包含 1 的最大的轴对齐加号标志的阶数,如果未找到加号标志则返回 0
 * 一个 k 阶由 1 组成的 "轴对称" 加号标志具有中心网格 grid[r][c] == 1
 * 以及 4 个从中心向上、向下、向左、向右延伸,长度为 k-1,由 1 组成的臂
 * 注意,只有加号标志的所有网格要求为 1,别的网格可能为 0 也可能为 1
 *
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都不重复
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z3MaxPlus {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (mines.length == n * n) {
            return 0;
        }
        int[][] grid = new int[n][n];
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = -1;
        }
        int[] rowCount = new int[n];
        for (int i = 0; i < grid.length; i++) {
            int columnCount = 0;
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == -1) {
                    rowCount[j] = columnCount = 0;
                } else {
                    row[j] = ((++rowCount[j]) << 9) + (++columnCount);
                }
            }
        }
        int result = 1;
        rowCount = new int[n];
        for (int i = grid.length - 1; i >= 0; i--) {
            int columnCount = 0;
            int[] row = grid[i];
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] == -1) {
                    rowCount[j] = columnCount = 0;
                } else {
                    int leftCount = row[j] & 511;
                    int upCount = row[j] >> 9;
                    result = Math.max(Math.min(Math.min(leftCount, upCount), Math.min(++rowCount[j], ++columnCount)), result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z3MaxPlus test = new Z3MaxPlus();
        // 2
        System.out.println(test.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }
}
