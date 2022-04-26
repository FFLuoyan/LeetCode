package org.zongjieli.leetcode.question.daily.year2022.month4.week5;
/**
 * 在 n x n 的网格 grid 中,放置了一些与 x,y,z 三轴对齐的 1 x 1 x 1 立方体
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上
 * 现在查看这些立方体在 xy 、yz 和 zx 平面上的投影
 * 投影就像影子,将三维形体映射到一个二维平面上
 * 从顶部、前面和侧面看立方体时,会看到 "影子"
 * 返回所有三个投影的总面积
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 *
 * @author   Li.zongjie
 * @date     2022/4/26
 * @version  1.0
 */
public class Z2ProjectedArea {

    public int projectionArea(int[][] grid) {
        int[] columnMax = new int[grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int rowMax = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] != 0) {
                    result++;
                    rowMax = Math.max(rowMax, row[j]);
                    columnMax[j] = Math.max(columnMax[j], row[j]);
                }
            }
            result += rowMax;
        }
        for (int max : columnMax) {
            result += max;
        }
        return result;
    }
}
