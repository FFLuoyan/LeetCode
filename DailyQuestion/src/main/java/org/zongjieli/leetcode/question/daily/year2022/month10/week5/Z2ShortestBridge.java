package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

/**
 * 给定一个大小为 n x n 的二元矩阵 grid,其中 1 表示陆地,0 表示水域
 * 岛是由四面相连的 1 形成的一个最大组,即不会与非组内的任何其他 1 相连,grid 中恰好存在两座岛
 * 你可以将任意数量的 0 变为 1,以使两座岛连接起来,变成一座岛
 * 返回必须翻转的 0 的最小数目
 *
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/11/1
 */
public class Z2ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int[] result = new int[]{Integer.MAX_VALUE};
        a: for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    setIsland(i, j, grid);
                    grid[i][j] = Integer.MIN_VALUE;
                    getDistance(i, j, grid, result, -1);
                    break a;
                }
            }
        }
        return result[0];
    }

    private void setIsland(int i, int j, int[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = Integer.MIN_VALUE;
            setIsland(i - 1, j, grid);
            setIsland(i + 1, j, grid);
            setIsland(i, j - 1, grid);
            setIsland(i, j + 1, grid);
        }
    }

    private void getDistance(int i, int j, int[][] grid, int[] result, int targetValue) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            int current = grid[i][j];
            if (current == 1) {
                result[0] = Math.min(result[0], -targetValue - 1);
            } else if (current == Integer.MIN_VALUE) {
                grid[i][j] = Integer.MAX_VALUE;
                getDistance(i - 1, j, grid, result, -1);
                getDistance(i + 1, j, grid, result, -1);
                getDistance(i, j - 1, grid, result, -1);
                getDistance(i, j + 1, grid, result, -1);
            } else if (current == 0 || current < targetValue) {
                grid[i][j] = targetValue;
                getDistance(i - 1, j, grid, result, targetValue - 1);
                getDistance(i + 1, j, grid, result, targetValue - 1);
                getDistance(i, j - 1, grid, result, targetValue - 1);
                getDistance(i, j + 1, grid, result, targetValue - 1);
            }
        }
    }

    public static void main(String[] args) {
        Z2ShortestBridge test = new Z2ShortestBridge();
        // 1
        System.out.println(test.shortestBridge(new int[][]{{1, 0}, {0, 1}}));
    }
}
