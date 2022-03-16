package org.zongjieli.leetcode.question.daily.year2022.month2.week3;

/**
 * 在一个 n x n 的国际象棋棋盘上
 * 一个骑士从单元格 (row, column) 开始,并尝试进行 k 次移动
 * 行和列是从 0 开始的,所以左上单元格是 (0,0),右下单元格是 (n - 1, n - 1)
 *
 * 象棋骑士有 8 种可能的走法 (类似中国象棋马)
 * 每次移动在基本方向上是两个单元格,然后在正交方向上是一个单元格
 * 每次骑士要移动时,它都会随机从 8 种可能的移动中选择一种 (即使棋子会离开棋盘),然后移动到那里
 *
 * 骑士继续移动,直到它走了 k 步或离开了棋盘
 * 返回骑士在棋盘停止移动后仍留在棋盘上的概率
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 *
 * @author   Li.zongjie
 * @date     2022/2/17
 * @version  1.0
 */
public class Z4KnightProbability {

    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        }
        if (n <= 2) {
            return 0;
        }
        double[][][] probability = new double[k + 1][n][n];
        double[][] zero = probability[0];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                zero[i][j] = 1;
            }
        }
        return calProbability(row, column, probability, k, n);
    }

    private double calProbability(int row, int column, double[][][]probability, int k, int n) {
        double p = probability[k][row][column];
        if (p != 0) {
            return probability[k][row][column];
        }
        if (row >= 2) {
            if (column >= 1) {
                p += calProbability(row - 2, column - 1, probability, k - 1, n);
            }
            if (column < n - 1) {
                p += calProbability(row - 2, column + 1, probability, k - 1, n);
            }
        }
        if (row >= 1) {
            if (column >= 2) {
                p += calProbability(row - 1, column - 2, probability, k - 1, n);
            }
            if (column < n - 2) {
                p += calProbability(row - 1, column + 2, probability, k - 1, n);
            }
        }
        if (row < n - 1) {
            if (column >= 2) {
                p += calProbability(row + 1, column - 2, probability, k - 1, n);
            }
            if (column < n - 2) {
                p += calProbability(row + 1, column + 2, probability, k - 1, n);
            }
        }
        if (row < n - 2) {
            if (column >= 1) {
                p += calProbability(row + 2, column - 1, probability, k - 1, n);
            }
            if (column < n - 1) {
                p += calProbability(row + 2, column + 1, probability, k - 1, n);
            }
        }
        return probability[k][row][column] = p / 8;
    }

    public static void main(String[] args) {
        Z4KnightProbability test = new Z4KnightProbability();
        // 0.0625
        System.out.println(test.knightProbability(3, 2, 0, 0));
        // 1
        System.out.println(test.knightProbability(1, 0, 0, 0));
    }
}
