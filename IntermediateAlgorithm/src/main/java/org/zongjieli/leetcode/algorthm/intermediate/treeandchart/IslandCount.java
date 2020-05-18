package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import java.util.LinkedList;
import java.util.Vector;

/**
 * @ClassName: IslandCount
 * @Description:
 * 根据给定的二维数组, 计算出数组中岛屿的数量
 * '1' 表示陆地,'0' 表示海水
 * 岛屿总是被水包围着,并且每座岛屿只能由水平方向竖直方向上相邻的陆地连接形成
 * 可以假想该网格的四周均被水包裹
 * @Author: Zongjie.Li
 * @Date: 2020/5/15
 * @Version: 1.0
 **/
public class IslandCount {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        LinkedList<Integer> checkIndexList = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (check(i, j, grid, checkIndexList)) {
                    count++;
                    while (checkIndexList.size() != 0) {
                        int rowIndex = checkIndexList.poll();
                        int columnIndex = checkIndexList.poll();
                        if (rowIndex > 0) {
                            check(rowIndex - 1, columnIndex, grid, checkIndexList);
                        }
                        if (columnIndex > 0) {
                            check(rowIndex, columnIndex - 1, grid, checkIndexList);
                        }
                        if (rowIndex < grid.length - 1) {
                            check(rowIndex + 1, columnIndex, grid, checkIndexList);
                        }
                        if (columnIndex < grid[rowIndex].length - 1) {
                            check(rowIndex, columnIndex + 1, grid, checkIndexList);
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean check(int rowIndex, int columnIndex, char[][] grid, LinkedList<Integer> checkIndexList) {
        if (grid[rowIndex][columnIndex] == '1') {
            checkIndexList.addLast(rowIndex);
            checkIndexList.addLast(columnIndex);
            grid[rowIndex][columnIndex] = '0';
            return true;
        }
        return false;
    }
}
