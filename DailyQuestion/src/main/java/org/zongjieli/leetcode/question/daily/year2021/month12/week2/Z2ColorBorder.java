package org.zongjieli.leetcode.question.daily.year2021.month12.week2;

import java.util.Arrays;

/**
 * 给定一个大小为 m x n 的整数矩阵 grid,表示一个网格
 * 另给定三个整数 row、col 和 color
 * 网格中的每个值表示该位置处的网格块的颜色
 *
 * 当两个网格块的颜色相同,而且在四个方向中任意一个方向上相邻时,它们属于同一连通分量
 * 连通分量的边界是指连通分量中的所有与不在分量中的网格块相邻(四个方向上)的所有网格块
 * 或者在网格的边界上(第一行/列或最后一行/列)的所有网格块
 *
 * 请使用指定颜色 color 为所有包含网格块 grid[row][col] 的连通分量的边界进行着色
 * 并返回最终的网格 grid
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *  
 * @author   Li.zongjie
 * @date     2021/12/7
 * @version  1.0
 */
public class Z2ColorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] read = new boolean[grid.length][grid[0].length];
        find(grid, read, row, col, grid[row][col], color);
        return grid;
    }

    public void find(int[][] grid, boolean[][] read, int row, int column, int target, int color){
        if (read[row][column]){
            return;
        }
        read[row][column] = true;
        boolean upChange = row == 0 || grid[row - 1][column] != target;
        boolean leftChange = column == 0 || grid[row][column - 1] != target;
        boolean downChange = row == grid.length - 1 || grid[row + 1][column] != target;
        boolean rightChange = column == grid[row].length - 1 || grid[row][column + 1] != target;

        if (!upChange){
            find(grid, read, row - 1, column, target, color);
        }
        if (!leftChange){
            find(grid, read, row, column - 1, target, color);
        }
        if (!downChange){
            find(grid, read, row + 1, column, target, color);
        }
        if (!rightChange){
            find(grid, read, row, column + 1, target, color);
        }
        grid[row][column] = (upChange || leftChange || downChange || rightChange) ? color : target;
    }

    public static void main(String[] args) {
        Z2ColorBorder test = new Z2ColorBorder();
//        System.out.println(Arrays.toString(test.colorBorder(new int[][]{{1,1},{1,2}}, 0, 0, 3)));
//        System.out.println(Arrays.toString(test.colorBorder(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, 1, 1, 2)));
        System.out.println(Arrays.toString(test.colorBorder(new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}}, 1, 3, 1)));
    }
}
