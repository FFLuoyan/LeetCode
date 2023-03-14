package org.zongjieli.leetcode.question.daily.year2023.month3.week3;

/**
 * 给定两个非负整数数组 rowSum 和 colSum
 * 其中 rowSum[i] 是二维矩阵中第 i 行元素的和
 * colSum[j] 是第 j 列元素的和
 * 换言之不知道矩阵里的每个元素,但是知道每一行和每一列的和
 * 请找到大小为 rowSum.length x colSum.length 的任意非负整数矩阵
 * 且该矩阵满足 rowSum 和 colSum 的要求
 * 请返回任意一个满足题目要求的二维矩阵,题目保证存在至少一个可行矩阵
 *
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 10^8
 * sum(rowSum) == sum(colSum)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/14
 */
public class Z2MatrixSum {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int ri = 0, ci = 0, m = rowSum.length, n = colSum.length;
        int[][] result = new int[m][n];
        while (ri < m && ci < n) {
            int min = Math.min(rowSum[ri], colSum[ci]);
            result[ri][ci] = min;
            if ((rowSum[ri] -= min) == 0) {
                ri++;
            }
            if ((colSum[ci] -= min) == 0) {
                ci++;
            }
        }
        return result;
    }

}
