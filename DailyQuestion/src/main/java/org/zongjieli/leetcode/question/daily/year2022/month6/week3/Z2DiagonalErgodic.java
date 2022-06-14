package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import java.util.Arrays;

/**
 * 给定一个大小为 m x n 的矩阵 mat
 * 以对角线遍历的顺序,用一个数组返回这个矩阵中的所有元素
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/6/14
 * @version  1.0
 */
public class Z2DiagonalErgodic {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        result[0] = mat[0][0];
        int max = m + n - 2;
        int ci = 1;
        for (int i = 1 ; i <= max ; i += 2) {
            // 先从右上向左下
            int sr, sc;
            if (i < n) {
                sr = 0;
                sc = i - sr;
            } else {
                sc = n - 1;
                sr = i - sc;
            }
            for (; sr < m && sc >= 0; sr++, sc--) {
                result[ci++] = mat[sr][sc];
            }
            if (sr == m) {
                sr--;
                sc += 2;
            } else {
                sc++;
            }
            for (; sr >= 0 && sc < n; sr--, sc++) {
                result[ci++] = mat[sr][sc];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z2DiagonalErgodic test = new Z2DiagonalErgodic();
        // 1, 2, 4, 7, 5, 3, 6, 8, 9
        System.out.println(Arrays.toString(test.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
