package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

/**
 * 给定一个由若干 0 和 1 组成的二维网格 grid
 * 请找出边界全部由 1 组成的最大正方形子网格
 * 并返回该子网格中的元素数量,如果不存在则返回 0
 *
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/17
 */
public class Z5LargestSquare {

    public int largest1BorderedSquare(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            b: for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    continue;
                }
                result = Math.max(result, 1);
                int max = Math.min(i, j);
                int current = 0;
                c: while (current < max) {
                    int startRow = i - current - 1, startColumn = j - current - 1;
                    int[] compareRow = grid[startRow];
                    if (compareRow[j] == 0 || grid[i][startColumn] == 0) {
                        continue b;
                    }
                    for (int k = startColumn ; k < j ; k++) {
                        if (compareRow[k] == 0) {
                            current++;
                            continue c;
                        }
                    }
                    for (int k = startRow + 1 ; k < i ; k++) {
                        if (grid[k][startColumn] == 0) {
                            current++;
                            continue c;
                        }
                    }
                    result = Math.max(result, ++current + 1);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        Z5LargestSquare test = new Z5LargestSquare();
        // 9
        System.out.println(test.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        // 1
        System.out.println(test.largest1BorderedSquare(new int[][]{{1, 1}, {0, 1}}));
        // 4
        System.out.println(test.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 1, 1}, {0, 1, 1}, {1, 1, 1}}));
    }

}
