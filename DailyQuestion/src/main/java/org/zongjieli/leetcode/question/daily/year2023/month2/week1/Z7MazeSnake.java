package org.zongjieli.leetcode.question.daily.year2023.month2.week1;

/**
 * 在一个 n*n 的网格上构建了新的迷宫地图,蛇的长度为 2,也就是说它会占去两个单元格
 * 蛇会从左上角((0, 0),(0, 1))开始移动
 * 用 0 表示空单元格,用 1 表示障碍物
 * 蛇需要移动到迷宫的右下角((n-1, n-2),(n-1, n-1))
 * 每次移动,蛇可以这样走:
 *  如果没有障碍,则向右移动一个单元格,并仍然保持身体的水平 / 竖直状态
 *  如果没有障碍,则向下移动一个单元格,并仍然保持身体的水平 / 竖直状态
 *  如果它处于水平状态并且其下面的两个单元都是空的,就顺时针旋转 90 度
 *      从((r, c),(r, c+1)) 移动到 ((r, c),(r+1, c))
 *  如果它处于竖直状态并且其右面的两个单元都是空的,就逆时针旋转 90 度
 *      从((r, c),(r+1, c)) 移动到((r, c),(r, c+1))
 * 返回蛇抵达目的地所需的最少移动次数
 * 如果无法到达目的地,请返回 -1
 *
 * 2 <= n <= 100
 * 0 <= grid[i][j] <= 1
 * 蛇保证从空单元格开始出发
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z7MazeSnake {

    public int minimumMoves(int[][] grid) {
        int rl = grid.length, cl = grid[0].length;
        int[][][] save = new int[rl][cl][2];
        move(grid, 0, 1, 0, save, 0);
        int result = save[rl - 1][cl - 1][0];
        return result > 0 ? result : -1;
    }

    public void move(int[][] grid, int row, int column, int direction, int[][][] save, int step) {
        if (save[row][column][direction] != 0 && save[row][column][direction] <= step) {
            return;
        }
        save[row][column][direction] = step;
        if (direction == 0) {
            // 蛇水平,可以右,下,顺时针旋转
            if (column < grid[row].length - 1 && grid[row][column + 1] == 0) {
                // 右移
                move(grid, row, column + 1, direction, save, step + 1);
            }
            if (row < grid.length - 1 && grid[row + 1][column] == 0 && grid[row + 1][column - 1] == 0) {
                // 下移
                move(grid, row + 1, column, direction, save, step + 1);
                // 旋转
                move(grid, row + 1, column - 1, 1, save, step + 1);
            }
        } else {
            // 蛇竖直,可以右,下,逆时针旋转
            if (row < grid.length - 1 && grid[row + 1][column] == 0) {
                // 下移
                move(grid, row + 1, column, direction, save, step + 1);
            }
            if (column < grid[row].length - 1 && grid[row - 1][column + 1] == 0 && grid[row][column + 1] == 0) {
                // 右移
                move(grid, row, column + 1, direction, save, step + 1);
                // 旋转
                move(grid, row - 1, column + 1, 0, save, step + 1);
            }
        }
    }

    public static void main(String[] args) {
        Z7MazeSnake test = new Z7MazeSnake();
        // 11
        System.out.println(test.minimumMoves(new int[][]{{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 0, 0}}));
        // 9
        System.out.println(test.minimumMoves(new int[][]{{0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 0}}));
        // 37
        System.out.println(test.minimumMoves(new int[][]{{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
