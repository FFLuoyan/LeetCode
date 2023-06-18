package org.zongjieli.leetcode.question.daily.year2023.month6.week3;

/**
 * 二维矩阵 grid 由 0(土地) 和 1(水) 组成
 * 岛是由最大的 4 个方向连通的 0 组成的群
 * 封闭岛是一个完全由 1 包围(左、上、右、下)的岛
 * 请返回封闭岛屿的数目
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/18
 */
public class Z7IslandCount {

    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int[] judge = new int[]{1};
                    removeLand(i, j, grid, judge);
                    result += judge[0];
                }
            }
        }
        return result;
    }

    public void removeLand(int i, int j, int[][] grid, int[] judge) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            judge[0] = 0;
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = -1;
            removeLand(i + 1, j, grid, judge);
            removeLand(i - 1, j, grid, judge);
            removeLand(i, j - 1, grid, judge);
            removeLand(i, j + 1, grid, judge);
        }
    }

    public static void main(String[] args) {
        Z7IslandCount test = new Z7IslandCount();
        // 2
        System.out.println(test.closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
        // 5
        System.out.println(test.closedIsland(new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}));
    }
}
