package org.zongjieli.leetcode.competion.singleweekly.order260;
/**
 * 给定一个下标从 0 开始的二维数组 grid
 * 数组大小为 2 x n,其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数
 * 现在有两个机器人正在矩阵上参与一场游戏
 * 两个机器人初始位置都是 (0, 0),目标位置是 (1, n-1)
 * 每个机器人只会向右 ((r, c) 到 (r, c + 1)) 或向下 ((r, c) 到 (r + 1, c))
 * 游戏开始,第一个 机器人从 (0, 0) 移动到 (1, n-1),并收集路径上单元格的全部点数
 * 对于路径上所有单元格 (r, c),途经后 grid[r][c] 会重置为 0
 * 然后,第二个 机器人从 (0, 0) 移动到 (1, n-1),同样收集路径上单元的全部点数
 * 注意,它们的路径可能会存在相交的部分。
 *
 * 第一个机器人想要打击竞争对手,使第二个机器人收集到的点数最小化
 * 与此相对,第二个机器人想要最大化自己收集到的点数
 * 两个机器人都发挥出自己的最佳水平的前提下,返回第二个机器人收集到的点数
 *
 * grid.length == 2
 * n == grid[r].length
 * 1 <= n <= 5 * 10^4
 * 1 <= grid[r][c] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class GridGame {
    public long gridGame(int[][] grid) {
        int length = grid[0].length;
        if (length <= 1){
            return 0;
        }
        long row1 = 0;
        for (int i = 1 ; i < length ; i++){
            row1 += grid[0][i];
        }
        long row2 = 0;
        long result = row1;
        for (int i = 1 ; i < length ; i++){
            row2 += grid[1][i - 1];
            row1 -= grid[0][i];
            result = Math.min(result,Math.max(row1,row2));
        }
        return result;
    }
}
