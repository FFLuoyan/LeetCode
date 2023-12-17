package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

/**
 * 给定一个 m x n 的二进制矩阵 grid,每个格子要么为 0(空),要么为 1(被占据)
 * 给定邮票的尺寸为 stampHeight x stampWidth
 * 想将邮票贴进二进制矩阵中,且满足以下限制和要求:
 *  覆盖所有空格子
 *  不覆盖任何被占据的格子
 *  可以放入任意数目的邮票
 *  邮票可以相互有重叠部分
 *  邮票不允许旋转
 *  邮票必须完全在矩阵内
 * 如果在满足上述要求的前提下可以放入邮票,请返回 true,否则返回 false
 *
 * m == grid.length
 * n == grid[r].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 2 * 10^5
 * grid[r][c] 要么是 0,要么是 1
 * 1 <= stampHeight, stampWidth <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/14
 */
public class Z4StampFull {

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        int[][] disableCount = new int[m][n];
        int[] rowCount = new int[n];
        for (int i = 0 ; i < stampHeight - 1 && i < m; i++) {
            for (int j = 0 ; j < n ; j++) {
                rowCount[j] += grid[i][j];
            }
        }
        for (int i = 0; i <= m - stampHeight; i++) {
            for (int j = 0; j < n; j++) {
                rowCount[j] += grid[i + stampHeight - 1][j];
            }
            int current = 0;
            for (int j = 0 ; j < stampWidth - 1; j++) {
                current += rowCount[j];
            }
            for (int j = 0 ; j <= n - stampWidth ; j++) {
                current += rowCount[j + stampWidth - 1];
                disableCount[i][j] = current;
                current -= rowCount[j];
            }
            for (int j = 0; j < n; j++) {
                rowCount[j] -= grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            a: for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int ie = Math.min(i, m - stampHeight);
                int je = Math.min(j, n - stampWidth);
                for (int is = Math.max(0, i - stampHeight + 1) ; is <= ie ; is++) {
                    for (int js = Math.max(0, j - stampWidth + 1) ; js <= je ; js++) {
                        if (disableCount[is][js] == 0) {
                            continue a;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z4StampFull test = new Z4StampFull();
        int[][] grid = new int[3][33333];
        for (int i = 0 ; i < 100 ; i++) {
            grid[0][i] = grid[1][i] = grid[2][i] = grid[0][33332 - i] = grid[1][33332 - i] = grid[2][33332 - i] = 1;
        }
        // true
        System.out.println(test.possibleToStamp(grid, 3, 26303));
        // false
        System.out.println(test.possibleToStamp(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 2, 2));
        // false
        System.out.println(test.possibleToStamp(new int[][]{{1, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 1}}, 13, 6));
        // true
        System.out.println(test.possibleToStamp(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 9, 4));
        // false
        System.out.println(test.possibleToStamp(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}}, 3, 3));
    }
}
