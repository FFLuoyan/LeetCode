package org.zongjieli.leetcode.question.daily.year2021.month4.week4;
/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k
 * 找出并返回矩阵内部矩形区域的不超过 k 的最大数值和
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -10^5 <= k <= 10^5
 *  
 * @author   Zongjie.Li
 * @date     2021/4/22
 * @version  1.0
 */
public class MaxMatrixSum {
    public int maxSumSubMatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int columnLength = (1 + n) * n / 2;
        int rowLength = (1 + m) * m / 2;
        int[][] calculator = new int[rowLength][columnLength];
        int rowIndex = 0;
        for (int row = 0 ; row < m ; row++){
            for (int rowLoop = row;rowLoop < m ; rowLoop++){
                int columnIndex = 0;
                for (int column = 0 ; column < n ; column++){
                    for (int columnLoop = column ; columnLoop < n ; columnLoop++){
                        calculator[rowIndex][columnIndex] = matrix[rowLoop][columnLoop];
                        if (columnLoop != column){
                            calculator[rowIndex][columnIndex] += calculator[rowIndex][columnIndex - 1];
                        }
                        if (rowLoop != row){
                            calculator[rowIndex][columnIndex] += calculator[rowIndex - 1][columnIndex];
                        }
                        if (rowLoop != row && columnLoop != column){
                            calculator[rowIndex][columnIndex] -= calculator[rowIndex - 1][columnIndex - 1];

                        }
                        if (calculator[rowIndex][columnIndex] == k){
                            return k;
                        }
                        if (calculator[rowIndex][columnIndex] < k){
                            result = Math.max(result,calculator[rowIndex][columnIndex]);
                        }
                        columnIndex++;
                    }
                }
                rowIndex++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        MaxMatrixSum sum = new MaxMatrixSum();
        System.out.println(sum.maxSumSubMatrix(new int[][]{{1,2},{3,4}},20));
    }
}
