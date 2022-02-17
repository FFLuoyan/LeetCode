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
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0){
            return 1;
        }
        double[][] probability = new double[n][n];
        probability[row][column] = 1;
        while (k-- > 0) {
            double[][] next = new double[n][n];
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    double current = probability[i][j] / 8;
                    if (i >= 2) {
                        if (j >= 1) {
                            next[i - 2][j - 1] += current;
                        }
                        if (j < n - 1) {
                            next[i - 2][j + 1] += current;
                        }
                    }
                    if (i >= 1) {
                        if (j >= 2) {
                            next[i - 1][j - 2] += current;
                        }
                        if (j < n - 2) {
                            next[i - 1][j + 2] += current;
                        }
                    }
                    if (i < n - 1) {
                        if (j >= 2) {
                            next[i + 1][j - 2] += current;
                        }
                        if (j < n - 2) {
                            next[i + 1][j + 2] += current;
                        }
                    }
                    if (i < n - 2) {
                        if (j >= 1) {
                            next[i + 2][j - 1] += current;
                        }
                        if (j < n - 1) {
                            next[i + 2][j + 1] += current;
                        }
                    }
                }
            }
            probability = next;
        }
        double result = 0;
        for (double[] rowD : probability) {
            for (double v : rowD) {
                result += v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4KnightProbability test = new Z4KnightProbability();
        System.out.println(test.knightProbability(8, 30, 6, 4));
    }
}
