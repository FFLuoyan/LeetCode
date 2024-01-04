package org.zongjieli.leetcode.question.daily.year2024.month1.week1;

/**
 * 给定一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix
 * 另给定一个整数 numSelect,表示必须从 matrix 中选择的不同列的数量
 * 如果一行中所有的 1 都被选中的列所覆盖,则认为这一行被覆盖了
 * 形式上,假设 s = {c1, c2, ...., cNumSelect} 是选择的列的集合
 * 对于矩阵中的某一行 row,如果满足下述条件,则认为这一行被集合 s 覆盖:
 *  对于满足 matrix[row][col] == 1 的每个单元格
 *      matrix[row][col](0 <= col <= n - 1), col 均存在于 s 中
 *  或者 row 中不存在值为 1 的单元格
 * 需要从矩阵中选出 numSelect 个列,使集合覆盖的行数最大化
 * 返回一个整数,表示可以由 numSelect 列构成的集合覆盖的最大行数
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 12
 * matrix[i][j] 要么是 0 要么是 1
 * 1 <= numSelect <= n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/4
 */
public class Z4CoverLine {

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] |= (1 << j);
                }
            }
        }
        int max = 1 << n, result = 0, currentResult;
        for (int i = 1 ; i < max ; i++) {
            if (Integer.bitCount(i) != numSelect) {
                continue;
            }
            currentResult = 0;
            for (int row : rows) {
                if ((row & i) == row) {
                    currentResult++;
                }
            }
            result = Math.max(result, currentResult);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4CoverLine test = new Z4CoverLine();
        //
        System.out.println(test.maximumRows(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}}, 2));
    }
}
