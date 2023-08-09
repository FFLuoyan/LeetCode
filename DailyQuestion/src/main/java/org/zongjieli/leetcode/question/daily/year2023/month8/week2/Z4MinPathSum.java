package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

/**
 * 给定一个 n x n 整数矩阵 grid,请返回非零偏移下降路径数字和的最小值
 * 非零偏移下降路径定义为:
 *  从 grid 数组中的每一行选择一个数字,且按顺序选出来的数字中,相邻数字不在原数组的同一列
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/10
 */
public class Z4MinPathSum {

    public int minFallingPathSum(int[][] grid) {
        int min = 0, sMin = 0, minIndex = 0;
        for (int[] row : grid) {
            int rowMin = Integer.MAX_VALUE, rowMinIndex = -1, sRowMin = rowMin, currentSum;
            for (int i = 0; i < row.length; i++) {
                currentSum = row[i] + (i == minIndex ? sMin : min);
                if (currentSum < rowMin) {
                    sRowMin = rowMin;
                    rowMin = currentSum;
                    rowMinIndex = i;
                } else if (currentSum < sRowMin) {
                    sRowMin = currentSum;
                }
            }
            min = rowMin;
            sMin = sRowMin;
            minIndex = rowMinIndex;
        }
        return min;
    }
}
