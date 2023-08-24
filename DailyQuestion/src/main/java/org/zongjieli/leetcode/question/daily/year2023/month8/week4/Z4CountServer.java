package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

/**
 * 这里有一幅服务器分布图,服务器的位置标识在 m * n 的整数矩阵网格 grid 中
 * 1 表示单元格上有服务器,0 表示没有
 * 如果两台服务器位于同一行或者同一列,就认为它们之间可以进行通信
 * 请统计并返回能够与至少一台其他服务器进行通信的服务器的数量
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/24
 */
public class Z4CountServer {

    public int countServers(int[][] grid) {
        int all = 0, single = 0;
        int[] rowCount = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j : grid[i]) {
                if (j == 1) {
                    rowCount[i]++;
                    all++;
                }
            }
        }
        for (int i = 0 ; i < grid[0].length ; i++) {
            int columnCount = 0, lastIndex = -1;
            for (int j = 0 ; j < grid.length ; j++) {
                if (grid[j][i] == 1) {
                    columnCount++;
                    lastIndex = j;
                }
            }
            if (columnCount == 1 && rowCount[lastIndex] == 1) {
                single++;
            }
        }
        return all - single;
    }

}
