package org.zongjieli.leetcode.question.daily.year2021.month10.week5;
/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target
 * 该矩阵具有以下特性:
 *  每行的元素从左到右升序排列
 *  每列的元素从上到下升序排列
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/10/25
 * @version  1.0
 */
public class Z1SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (column >= 0 && row < matrix.length){
            if (matrix[row][column] == target){
                return true;
            }
            if (matrix[row][column] > target){
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
