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
        int[] columnCount = new int[grid[0].length];
        for (int[] row : grid) {
            int rc = 0, li = -1;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    rc++;
                    columnCount[li = i]++;
                }
            }
            if (rc == 1) {
                columnCount[li] += 256;
            }
        }
        int result = 0;
        for (int i : columnCount) {
            if (i != 257) {
                result += (i & 255);
            }
        }
        return result;
    }

}
