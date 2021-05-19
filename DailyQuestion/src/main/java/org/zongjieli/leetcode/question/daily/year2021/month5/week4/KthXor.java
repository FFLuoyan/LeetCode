package org.zongjieli.leetcode.question.daily.year2021.month5.week4;

import java.util.Arrays;

/**
 * 给一个二维矩阵 matrix 和一个整数 k,矩阵大小为 m x n 由非负整数组成
 * 矩阵中坐标 (a, b) 的值可由对所有满足
 * 0 <= i <= a < m 且 0 <= j <= b < n
 * 的元素 matrix[i][j] (下标从 0 开始计数) 执行异或运算得到
 *
 * 请找出 matrix 的所有坐标中第 k 大的值 (k 的值从 1 开始计数)
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 10^6
 * 1 <= k <= m * n
 *
 * @author   Zongjie.Li
 * @date     2021/5/19
 * @version  1.0
 */
public class KthXor {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int valueLength = m * n;
        int [] values = new int[valueLength];
        values[0] = matrix[0][0];
        for (int i = 1 ; i < n ; i++){
            values[i] = values[i - 1] ^ matrix[0][i];
        }
        for (int i = 1 ; i < m ; i++){
            int rowValue = 0;
            for (int j = 0 ; j < n ; j++){
                rowValue = rowValue ^ matrix[i][j];
                int lastValueIndex = (i - 1) * n + j;
                values[i * n + j] = values[lastValueIndex] ^ rowValue;
            }
        }
        Arrays.sort(values);
        return values[valueLength - k];
    }
}
