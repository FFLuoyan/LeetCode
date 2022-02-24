package org.zongjieli.leetcode.question.daily.year2022.month2.week4;

import java.util.Arrays;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子
 * 现在有 n 颗球,箱子的顶部和底部都是开着的
 * 箱子中的每个单元格都有一个对角线挡板,跨过单元格的两个角,可以将球导向左侧或者右侧
 *  将球导向右侧的挡板跨过左上角和右下角,在网格中用 1 表示
 *  将球导向左侧的挡板跨过右上角和左下角,在网格中用 -1 表示
 * 在箱子每一列的顶端各放一颗球,每颗球都可能卡在箱子里或从底部掉出来
 * 如果球恰好卡在两块挡板之间的 "V" 形图案
 * 或者被一块挡导向到箱子的任意一侧边上,就会卡住
 * 返回一个大小为 n 的数组 answer
 * 其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标
 * 如果球卡在盒子里,则返回 -1
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 *
 * @author   Li.zongjie
 * @date     2022/2/24
 * @version  1.0
 */
public class Z4BallPlace {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0 ; i < result.length ; i++){
            int row = 0;
            int column = i;
            while (row < grid.length && column >= 0 && column < result.length) {
                if (grid[row][column] == 1) {
                    if (column == result.length - 1 || grid[row][column + 1] == -1) {
                        break;
                    }
                    row++;
                    column++;
                } else if (column == 0 || grid[row][column - 1] == 1) {
                    break;
                } else {
                    row++;
                    column--;
                }
            }
            result[i] = row == grid.length && column >= 0 && column < result.length ? column : -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4BallPlace test = new Z4BallPlace();
        // 0, 1, 2, 3, 4, -1
        System.out.println(Arrays.toString(test.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}})));
    }
}
