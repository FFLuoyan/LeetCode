package org.zongjieli.leetcode.question.daily.year2021.month2;
/**
 * 转置矩阵
 *
 * 给定一个二维证书数组 matrix,返回 matrix 的转置矩阵
 * 矩阵的转置是指将矩阵的主对角线翻转,交换矩阵的行索引和列索引
 *
 * @author   Zongjie.Li
 * @date     2021/2/25
 * @version  1.0
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return matrix;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
