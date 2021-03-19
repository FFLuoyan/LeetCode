package org.zongjieli.leetcode.question.daily.year2021.month3.week3;

import java.util.Arrays;

/**
 * 给定一个正整数 n,生成一个包含 1~ n^2 所有元素
 * 且元素按照顺时针螺旋排列的 n x n 正方形矩阵 matrix
 *
 * @author   Zongjie.Li
 * @date     2021/3/16
 * @version  1.0
 */
public class SpiralMatrix {

    public int[][] generateMatrix(int n) {
        if (n == 1){
            return new int[][]{{1}};
        }
        if (n == 2){
            return new int[][]{{1,2},{4,3}};
        }
        int[][] matrix = new int[n][n];
        int number = 1;
        for (int i = 0 ; i < n ; i++){
            matrix[0][i] = number++;
        }
        for (int i = 1 ; i < n ; i++){
            matrix[i][n - 1] = number++;
        }
        for (int i = n - 2 ; i >= 0 ; i--){
            matrix[n - 1][i] = number++;
        }
        for (int i = n - 2 ; i >= 1 ; i--){
            matrix[i][0] = number++;
        }
        int x = 1;
        int y = 1;
        int limit = n * n;

        while (number <= limit){
            matrix[x][y] = number++;
            int upper = matrix[x - 1][y];
            int bottom = matrix[x + 1][y];
            int left = matrix[x][y - 1];
            int right = matrix[x][y + 1];
            if (upper == 0){
                if (left == 0){
                    y--;
                    continue;
                }
                x--;
                continue;
            }
            // upper 不为 0
            if (right == 0){
                y++;
                continue;
            }
            if (bottom == 0){
                x++;
                continue;
            }
            y--;

        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = spiralMatrix.generateMatrix(5);
        for (int[] x : matrix){
            System.out.println(Arrays.toString(x));
        }
    }
}
