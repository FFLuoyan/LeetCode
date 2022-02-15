package org.zongjieli.leetcode.question.daily.year2022.month2.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m * n 的矩阵,矩阵中的数字各不相同
 * 请按任意顺序返回矩阵中的所有幸运数
 * 幸运数是指矩阵中满足同时下列两个条件的元素:
 *  在同一行的所有元素中最小
 *  在同一列的所有元素中最大
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 *
 * 矩阵中的所有元素都是不同的
 *
 * @author   Li.zongjie
 * @date     2022/2/15
 * @version  1.0
 */
public class Z2LuckyNumber {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length);
        for (int[] row : matrix) {
            int min = row[0];
            int minIndex = 0;
            for (int column = 1; column < row.length; column++) {
                if (row[column] < min) {
                    min = row[minIndex = column];
                }
            }

            int max = row[minIndex];
            int maxIndex = 0;
            while (maxIndex < matrix.length) {
                if (matrix[maxIndex][minIndex] > max) {
                    break;
                }
                ++maxIndex;
            }

            if (maxIndex == matrix.length) {
                result.add(max);
            }
        }
        return result;
    }
}
