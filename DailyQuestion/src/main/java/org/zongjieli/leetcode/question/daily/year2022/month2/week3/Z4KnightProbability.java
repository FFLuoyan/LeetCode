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
        if (n == 3) {
            if (column == 1 && row == 1) {
                return 0;
            }
            double p = 1;
            while (k-- > 0) {
                p /= 4;
            }
            return p;
        }
        int size = (n + 1) / 2;
        double[][][] probability = new double[k + 1][size][size];
        double[][] zero = probability[0];
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                zero[i][j] = 1;
            }
        }
        return calProbability(row, column, probability, k, n, size);
    }

    private double calProbability(int row, int column, double[][][]probability, int k, int n, int size) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        row = row < size ? row : n - 1 - row;
        column = column < size ? column : n - 1 - column;
        if (row > column) {
            int temp = row;
            row = column;
            column = temp;
        }
        double p = probability[k][row][column];
        if (p != 0) {
            return p;
        }
        p += calProbability(row - 2, column - 1, probability, k - 1, n, size);
        p += calProbability(row - 2, column + 1, probability, k - 1, n, size);
        p += calProbability(row - 1, column - 2, probability, k - 1, n, size);
        p += calProbability(row - 1, column + 2, probability, k - 1, n, size);
        p += calProbability(row + 1, column - 2, probability, k - 1, n, size);
        p += calProbability(row + 1, column + 2, probability, k - 1, n, size);
        p += calProbability(row + 2, column - 1, probability, k - 1, n, size);
        p += calProbability(row + 2, column + 1, probability, k - 1, n, size);
        return probability[k][row][column] = p / 8;
    }

    public static void main(String[] args) {
        Z4KnightProbability test = new Z4KnightProbability();
        // 0.0625
        System.out.println(test.knightProbability(3, 2, 0, 0));
        // 1
        System.out.println(test.knightProbability(1, 0, 0, 0));
        // 0
        System.out.println(test.knightProbability(3, 1, 1, 1));
        // 1.9052566E-4
        System.out.println(test.knightProbability(8, 30, 6, 4));
    }
}
