package org.zongjieli.leetcode.question.daily.year2022.month7.week3;
/**
 * 给定一个 m x n 的矩阵,最开始的时候每个单元格中的值都是 0
 * 另有一个二维索引数组 indices
 * indices[i] = [ri, ci] 指向矩阵中的某个位置
 * 其中 ri 和 ci 分别表示指定的行和列(从 0 开始编号)
 * 对 indices[i] 所指向的每个位置,应同时执行下述增量操作:
 *  ri 行上的所有单元格加 1
 *  ci 列上的所有单元格加 1
 * 给定 m、n 和 indices
 * 请在执行完所有 indices 指定的增量操作后
 * 返回矩阵中奇数值单元格的数目
 *
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 *
 * 设计一个时间复杂度为 O(n + m + indices.length)
 * 且仅用 O(n + m) 额外空间的算法来解决此问题
 *
 * @author   Li.zongjie
 * @date     2022/7/12
 * @version  1.0
 */
public class Z2OddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] columns = new int[n];
        int ro = 0, re = m, co = 0, ce = n;
        for (int[] index : indices) {
            int oa = ++rows[index[0]] % 2 == 0 ? 1 : -1;
            ro -= oa;
            re += oa;
            oa = ++columns[index[1]] % 2 == 0 ? 1 : -1;
            co -= oa;
            ce += oa;
        }
        return ro * ce + re * co;
    }

    public static void main(String[] args) {
        Z2OddCells test = new Z2OddCells();
        // 6
        System.out.println(test.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
