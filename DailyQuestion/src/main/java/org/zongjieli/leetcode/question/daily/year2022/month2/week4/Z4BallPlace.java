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
        int cols = grid[0].length;
        int[] result = new int[cols];
        for (int i = 0 ; i < cols ; i++) {
            result[i] = getResult(grid, 0, i);
        }
        return result;
    }

    public int getResult(int[][] grid, int row, int col) {
        if (row == grid.length) {
            return col;
        }
        int[] currentRow = grid[row];
        int current = currentRow[col];
        int nextCol = col + current;
        return nextCol < 0 || nextCol >= currentRow.length || current != currentRow[nextCol] ? -1 : getResult(grid, row + 1, nextCol);
    }

    public static void main(String[] args) {
        Z4BallPlace test = new Z4BallPlace();
        // 0, 1, 2, 3, 4, -1
        System.out.println(Arrays.toString(test.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}})));
        // 1, -1, -1, -1, -1
        System.out.println(Arrays.toString(test.findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}})));
        // -1,-1,-1,2,3,4,5,6,-1,-1,9,10,11,14,-1,-1,15,16,19,20,-1,-1,21,24,-1,-1,25,-1,-1,28,29,30,31,32,33,34,35,-1,-1,-1,-1,40,41,42,43,44,45,-1,-1,48,-1,-1,-1,-1,53,56,-1,-1,-1,-1,59,60,61,64,65,66,67,68,-1,-1,71,72,-1,-1,75,76,-1,-1,77,78,-1,-1,-1,-1,83,86,-1,-1,87,-1,-1,-1,-1,94,95,-1,-1,96,97,98
        System.out.println(Arrays.toString(test.findBall(new int[][]{{-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,1,-1,-1,1,1,-1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,1,1,1,-1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1,1,1,1,-1,-1,-1,-1}})));

    }
}
