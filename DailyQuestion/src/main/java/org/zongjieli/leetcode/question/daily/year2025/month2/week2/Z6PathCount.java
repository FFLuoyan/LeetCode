package org.zongjieli.leetcode.question.daily.year2025.month2.week2;

/**
 * 给定一个 m x n 的整数数组 grid
 * 一个机器人初始位于左上角(即 grid[0][0])
 * 机器人尝试移动到右下角(即 grid[m - 1][n - 1])
 * 机器人每次只能向下或者向右移动一步
 * 网格中的障碍物和空位置分别用 1 和 0 来表示
 * 机器人的移动路径中不能包含任何有障碍物的方格
 * 返回机器人能够到达右下角的不同路径数量
 * 测试用例保证答案小于等于 2 * 10^9
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/8
 */
public class Z6PathCount {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] pathCount = new int[m][n];
        pathCount[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (j != 0) {
                    pathCount[i][j] += pathCount[i][j - 1];
                }
                if (i != 0) {
                    pathCount[i][j] += pathCount[i - 1][j];
                }
            }
        }
        return pathCount[m - 1][n - 1];
    }

}
