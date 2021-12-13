package org.zongjieli.leetcode.question.daily.year2021.month12.week3;
/**
 * 在二维数组grid中,grid[i][j]代表位于某处的建筑物的高度
 * 允许增加任何数量(不同建筑物的数量可能不同)的建筑物的高度
 * 高度 0 也被认为是建筑物
 *
 * 最后,从新数组的所有四个方向(即顶部,底部,左侧和右侧)观看的天际线必须与原始数组的天际线相同
 * 城市的天际线是从远处观看时,由所有建筑物形成的矩形的外部轮廓
 *
 * 求建筑物高度可以增加的最大总和
 *
 * 1 < grid.length = grid[0].length <= 50
 *  grid[i][j] 的高度范围是: [0, 100]
 * 一座建筑物占据一个grid[i][j]
 * 换言之,它们是 1 x 1 x grid[i][j] 的长方体
 *
 * @author   Li.zongjie
 * @date     2021/12/13
 * @version  1.0
 */
public class Z1KeepSkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] columnMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += (Math.min(rowMax[i], columnMax[j]) - grid[i][j]);
            }
        }
        return result;
    }
}
