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
        if (n <= 2 && k > 0) {
            return 0;
        }
        int size = n * n;
        double[] probability = new double[size];
        probability[n * row + column] = 1;
        int[][] indexes = new int[size][9];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int current = i * n + j;
                if (i >= 2) {
                    if (j >= 1) {
                        indexes[current][indexes[current][8]++] = (i - 2) * n + j - 1;
                    }
                    if (j < n - 1) {
                        indexes[current][indexes[current][8]++] = (i - 2) * n + j + 1;
                    }
                }

                if (i >= 1) {
                    if (j >= 2) {
                        indexes[current][indexes[current][8]++] = (i - 1) * n + j - 2;
                    }
                    if (j < n - 2) {
                        indexes[current][indexes[current][8]++] = (i - 1) * n + j + 2;
                    }
                }

                if (i < n - 1) {
                    if (j >= 2) {
                        indexes[current][indexes[current][8]++] = (i + 1) * n + j - 2;
                    }
                    if (j < n - 2) {
                        indexes[current][indexes[current][8]++] = (i + 1) * n + j + 2;
                    }
                }

                if (i < n - 2) {
                    if (j >= 1) {
                        indexes[current][indexes[current][8]++] = (i + 2) * n + j - 1;
                    }
                    if (j < n - 1) {
                        indexes[current][indexes[current][8]++] = (i + 2) * n + j + 1;
                    }
                }
            }
        }
        while (k-- > 0) {
            double[] next = new double[size];
            for (int i = 0 ; i < size ; i++) {
                int loopSize = indexes[i][8];
                for (int j = 0 ; j < loopSize ; j++) {
                    next[i] += probability[indexes[i][j]] / 8;
                }
            }
            probability = next;
        }

        double result = 0;
        for (double v : probability) {
            result += v;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4KnightProbability test = new Z4KnightProbability();
        // 0.0625
        System.out.println(test.knightProbability(3, 2, 0, 0));
        // 1
        System.out.println(test.knightProbability(1, 0, 0, 0));
        System.out.println(test.knightProbability(8, 30, 6, 4));
    }
}
