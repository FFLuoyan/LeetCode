package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import java.util.LinkedList;

/**
 * @ClassName: IslandCount
 * @Description: 根据给定的二维数组,计算出数组中岛屿的数量
 *               '1' 表示陆地,'0' 表示海水
 *               岛屿总是被水包围着,并且每座岛屿只能由水平方向竖直方向上相邻的陆地连接形成
 *               可以假想该网格的四周均被水包裹
 * @Author: Zongjie.Li
 * @Date: 2020/5/15
 * @Version: 1.0
 **/
public class IslandCount {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        boolean[][] checkedGrid = new boolean[grid.length][grid[0].length];
        LinkedList<Integer> checkRowIndex = new LinkedList<>();
        LinkedList<Integer> checkColumnIndex = new LinkedList<>();
        int count = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0 ; j < grid[i].length ; j++){
                if (check(i,j,grid,checkedGrid,checkRowIndex,checkColumnIndex)){
                    count ++;
                }
                while (checkRowIndex.size() != 0){
                    int rowIndex = checkRowIndex.poll();
                    int columnIndex = checkColumnIndex.poll();
                    if (rowIndex > 0){
                        check(rowIndex - 1,columnIndex,grid,checkedGrid,checkRowIndex,checkColumnIndex);
                    }
                    if (columnIndex > 0){
                        check(rowIndex,columnIndex - 1,grid,checkedGrid,checkRowIndex,checkColumnIndex);
                    }
                    if (rowIndex < grid.length - 1){
                        check(rowIndex + 1,columnIndex,grid,checkedGrid,checkRowIndex,checkColumnIndex);
                    }
                    if (columnIndex < grid[rowIndex].length - 1){
                        check(rowIndex,columnIndex + 1,grid,checkedGrid,checkRowIndex,checkColumnIndex);
                    }
                }
            }
        }
        return count;
    }

    public boolean check(int rowIndex,int columnIndex,char[][] grid,boolean[][] checkedGrid,LinkedList<Integer> checkRowIndex,LinkedList<Integer> checkColumnIndex){
        if (!checkedGrid[rowIndex][columnIndex]){
            checkedGrid[rowIndex][columnIndex] = true;
            if (grid[rowIndex][columnIndex] == '1'){
                checkRowIndex.addLast(rowIndex);
                checkColumnIndex.addLast(columnIndex);
                return true;
            }
        }
        return false;
    }
}
