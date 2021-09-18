package org.zongjieli.leetcode.algorithm.primary.array;
/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像
 * 请将图像顺时针旋转 90 度
 * 必须在原地旋转图像，这意味着需要直接修改输入的二维矩阵
 * 请不要使用另一个矩阵来旋转图像
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P11RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int rowLimit = (length + 1) / 2;
        int columnLimit = length / 2;
        length --;
        for (int row = 0 ; row < rowLimit ; row++){
            for (int column = 0 ; column < columnLimit ; column++){
                // 设 9 * 9
                // 0,0 -> 8,0 -> 8,8 -> 8,0 -> 0,0
                int temp = matrix[row][column];
                matrix[row][column] = matrix[length - column][row];
                matrix[length - column][row] = matrix[length - row][length - column];
                matrix[length - row][length - column] = matrix[column][length - row];
                matrix[column][length - row] = temp;
            }
        }
    }
}
