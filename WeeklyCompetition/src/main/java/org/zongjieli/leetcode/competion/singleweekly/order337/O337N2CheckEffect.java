package org.zongjieli.leetcode.competion.singleweekly.order337;

/**
 * 骑士在一张 n x n 的棋盘上巡视
 * 在有效的巡视方案中,骑士会从棋盘的左上角出发,并且访问棋盘上的每个格子恰好一次
 * 给定一个 n x n 的整数矩阵 grid,由范围 [0, n * n - 1] 内的不同整数组成
 * 其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格
 * 骑士的行动是从下标 0 开始的
 * 如果 grid 表示了骑士的有效巡视方案,返回 true,否则返回 false
 * 注意,骑士行动时可以垂直移动两个格子且水平移动一个格子
 * 或水平移动两个格子且垂直移动一个格子(如象棋马)
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/19
 */
public class O337N2CheckEffect {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[] position = new int[n * n];
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (position[row[j]] != 0) {
                    return false;
                }
                position[row[j]] = (i << 4) + j;
            }
        }
        if (grid[0][0] != 0) {
            return false;
        }
        for (int i = 1; i < position.length; i++) {
            int cr = position[i] >> 4, cc = position[i] & 15;
            int br = position[i - 1] >> 4, bc = position[i - 1] & 15;
            if (Math.abs(cr - br) == 2 && Math.abs(cc - bc) == 1) {
                continue;
            }
            if (Math.abs(cr - br) == 1 && Math.abs(cc - bc) == 2) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        O337N2CheckEffect test = new O337N2CheckEffect();
        // false
        System.out.println(test.checkValidGrid(new int[][]{{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}}));
    }
}
