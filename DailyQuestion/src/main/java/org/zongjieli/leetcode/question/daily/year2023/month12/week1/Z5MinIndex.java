package org.zongjieli.leetcode.question.daily.year2023.month12.week1;

/**
 * 给定一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数矩阵 mat
 * arr 和 mat 都包含范围 [1, m * n] 内的所有整数
 * 从下标 0 开始遍历 arr 中的每个下标 i,并将包含整数 arr[i] 的 mat 单元格涂色
 * 请找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素,并返回其下标 i
 *
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数互不相同
 * mat 中的所有整数互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/4
 */
public class Z5MinIndex {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row, rowCount = new int[m], columnCount = new int[n];
        long index;
        long[] indexes = new long[m * n + 1];
        for (int i = 0; i < mat.length; i++) {
            index = ((long) i) << 32;
            row = mat[i];
            for (int j = 0; j < row.length; j++) {
                indexes[row[j]] = index + j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            index = indexes[arr[i]];
            if (++rowCount[(int) (index >> 32)] == n || ++columnCount[(int) index] == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Z5MinIndex test = new Z5MinIndex();
        // 2
        System.out.println(test.firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
    }

}
