package org.zongjieli.leetcode.question.daily.year2023.month1.week6;

/**
 * 如果一个正方形矩阵满足下述全部条件,则称之为一个 X 矩阵:
 *  矩阵对角线上的所有元素都不是 0
 *  矩阵中所有其他元素都是 0
 *  给定一个大小为 n x n 的二维整数数组 grid 表示一个正方形矩阵
 *  如果 grid 是一个 X 矩阵,返回 true,否则返回 false
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 0 <= grid[i][j] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/31
 */
public class Z2CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < length; j++) {
                if ((i == j || length - 1 - j == i) ^ row[j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
