package org.zongjieli.leetcode.competion.singleweekly.order373;

/**
 * 给定一个大小为 m x n 的整数矩阵 mat 和一个整数 k
 * 将矩阵中的奇数行循环右移 k 次,偶数行循环左移 k 次
 * 如果初始矩阵和最终矩阵完全相同则返回 true,否则返回 false
 *
 * 1 <= mat.length <= 25
 * 1 <= mat[i].length <= 25
 * 1 <= mat[i][j] <= 25
 * 1 <= k <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/26
 */
public class O373N1MoveSame {

    public boolean areSimilar(int[][] mat, int k) {
        int n  = mat[0].length;
        k %= n;
        for (int[] rows : mat) {
            // 向左向右一样
            for (int j = 0; j < rows.length; j++) {
                if (rows[j] != rows[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }

}
