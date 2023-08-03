package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

/**
 * 在二维网格 grid 上,有 4 种类型的方格:
 *  1 表示起始方格,且只有一个起始方格
 *  2 表示结束方格,且只有一个结束方格
 *  0 表示可以走的空方格
 * -1 表示无法跨越的障碍
 * 返回在四个方向(上、下、左、右)上行走时,从起始方格到结束方格的不同路径的数目
 * 每一个无障碍方格都要通过一次,但是一条路径中不能重复通过同一个方格
 *
 * 1 <= grid.length * grid[0].length <= 20
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/4
 */
public class Z5DifferentPath {

    int row = 0, column = 0, full = 0, end = 0;
    int[] result = new int[]{0};

    public int uniquePathsIII(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        full = (1 << (row * column)) - 1;
        int position = 0, current = 0, loop = 0, loopBit = 1;
        for (int[] row : grid) {
            for (int column : row) {
                if (column == -1) {
                    current |= loopBit;
                } else if (column == 1) {
                    position = loop;
                    current |= loopBit;
                } else if (column == 2) {
                    end = loop;
                    current |= loopBit;
                }
                loop++;
                loopBit <<= 1;
            }
        }
        move(current, position);
        return result[0];
    }

    public void move(int current, int position) {
        if (current == full && (Math.abs(position - end) == 1 || Math.abs(position - end) == column)) {
            result[0]++;
            return;
        }
        if (position >= column) {
            int next = position - column;
            if (((1 << next) & current) == 0) {
                move(current | (1 << next), next);
            }
        }
        if (position / column < row) {
            int next = position + column;
            if (((1 << next) & current) == 0) {
                move(current | (1 << next), next);
            }
        }
        if (position % column > 0) {
            int next = position - 1;
            if (((1 << next) & current) == 0) {
                move(current | (1 << next), next);
            }
        }
        if (position % column < column - 1) {
            int next = position + 1;
            if (((1 << next) & current) == 0) {
                move(current | (1 << next), next);
            }
        }
    }

    public static void main(String[] args) {
        Z5DifferentPath test = new Z5DifferentPath();
        // 2
        System.out.println(test.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }
}
