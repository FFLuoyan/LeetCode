package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

import java.util.Arrays;

/**
 * 给定一个大小为 n x n 的整数矩阵 grid
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵 maxLocal,并满足:
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的最大值
 * 换句话说,找出 grid 中每个 3 x 3 矩阵中的最大值
 * 返回生成的矩阵
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/1
 */
public class Z3MaxMatrix {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];
        for (int i = 0 ; i < result.length ; i++) {
            for (int j = 0 ; j < result.length ; j++) {
                int max = 0;
                for (int c = i ; c <= i + 2 ; c++) {
                    for (int d = j ; d <= j + 2 ; d++) {
                        max = Math.max(max, grid[c][d]);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z3MaxMatrix test = new Z3MaxMatrix();
        // {{9, 9}, {8, 6}}
        System.out.println(Arrays.deepToString(test.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
    }

}
