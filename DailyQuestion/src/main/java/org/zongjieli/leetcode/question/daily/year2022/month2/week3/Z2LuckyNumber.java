package org.zongjieli.leetcode.question.daily.year2022.month2.week3;

import java.util.ArrayList;
import java.util.Collections;
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
        /*
             幸运数必定只有一个
             假设矩阵中存在幸运数 N(r1,c1),N(r2,c2)
             对幸运数 1,有 N(r1,c1) > N(r2,c1), N(r1,c1) < N(r1,c2)
             而幸运数 2 同样有 N(r2,c2) > N(r1,c2), N(r2,c2) < N(r2,c1)
             则 N(r1,c1) > N(r2,c1) > N(r2,c2) > N(r1,c2)
             与 N(r1,c1) < N(r1,c2) 矛盾

             对于每一行的最小值组成的数组 m1,m2,...,mn
             如果存在幸运数,则必定为数组中的最大值
             反证法,若存在幸运数 N(r1,c1),及一个比它大的数 N(r2,c2)
             由定义知,c1 ≠ c2,且由于不同行,r1 ≠ r2
             则有 N(r2,c2) > N(r1,c1) > N(r2,c1)
             而 N(r2,c2) 是 r2 行最小值,与假设矛盾
         */
        int max = 0;
        int maxColumn = 0;
        for (int[] row : matrix) {
            int minIndex = 0;
            int min = row[0];
            for (int column = 1; column < row.length; column++) {
                if (row[column] < min) {
                    min = row[minIndex = column];
                }
            }
            if (min > max) {
                max = min;
                maxColumn = minIndex;
            }
        }

        for (int[] row : matrix) {
            if (row[maxColumn] > max) {
                return new ArrayList<>();
            }
        }
        return Collections.singletonList(max);
    }
}
