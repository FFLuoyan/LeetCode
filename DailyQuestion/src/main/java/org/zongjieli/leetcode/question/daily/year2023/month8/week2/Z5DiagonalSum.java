package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

/**
 * 给定一个正方形矩阵 mat,请返回矩阵对角线元素的和
 * 请返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和
 *
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/11
 */
public class Z5DiagonalSum {

    public int diagonalSum(int[][] mat) {
        int n = mat.length, last = n - 1, result = 0;
        for (int i = 0 ; i < n ; i++) {
            result += mat[i][i];
            result += mat[i][last - i];
        }
        return n % 2 == 0 ? result : result - mat[n / 2][n / 2];
    }

}
