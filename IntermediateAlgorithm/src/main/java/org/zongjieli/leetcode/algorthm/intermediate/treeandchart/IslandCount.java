package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import java.util.*;

/**
 * @ClassName: IslandCount
 * @Description: 根据给定的二维数组, 计算出数组中岛屿的数量
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


    /**
     * 并查集的算法
     *
     * @param grid Param Description
     * @return int
     * @Author Zongjie.Li
     * @Date 2020/5/19
     * @Version 1.0
     */
    public int numIslandsByUnionFindSets(char[][] grid) {
        // 获取每个元素的下标为 rowIndex * columnLength + columnIndex
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        LinkedList<Set<Integer>> unionSets = new LinkedList<>();
        if (grid[0][0] == '1') {
            // 如果第一个数就有值,则将其新建放入 List 中
            Set<Integer> firstSet = new HashSet<>();
            firstSet.add(0);
            unionSets.addLast(firstSet);
        }
        for (int i = 1; i < grid[0].length; i++) {
            // 遍历第一行,每一个数只需要和前一个数进行比较
            if (grid[0][i] == '1') {
                if (unionSets.size() == 0) {
                    // 此为第一个发现的小岛
                    Set<Integer> firstSet = new HashSet<>();
                    firstSet.add(i);
                    unionSets.addLast(firstSet);
                } else if (grid[0][i - 1] == '1') {
                    // 如果上一个数不为 '1',则直接加入最后一个 Set 中
                    unionSets.getLast().add(i);
                } else {
                    // 上一个数为 '0',则该小岛应为一个新的小岛
                    Set<Integer> newSet = new HashSet<>();
                    newSet.add(i);
                    unionSets.addLast(newSet);
                }
            }
        }
        // 遍历第二行直至最后一行
        for (int i = 1; i < grid.length; i++) {
            // 遍历每一行
            if (grid[i][0] == '1') {
                // 遍历第一个节点
                // 将该节点放入 Set 中
                if (unionSets.size() > 0 && grid[i - 1][0] == '1') {
                    // 存在有一个 Set 可以包含当前节点
                    int index = (i - 1) * grid[i].length;
                    Iterator<Set<Integer>> setIterator = unionSets.iterator();
                    while (setIterator.hasNext()) {
                        Set<Integer> set = setIterator.next();
                        if (set.contains(index)) {
                            set.add(i * grid[i].length);
                            break;
                        }
                    }
                } else {
                    // 构建一个新的小岛
                    Set<Integer> firstSet = new HashSet<>();
                    firstSet.add(i * grid[i].length);
                    unionSets.addLast(firstSet);
                }
            }
            // 遍历第一个节点外的所有节点
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    int currentIndex = i * grid[i].length + j;
                    if (unionSets.size() == 0 || (grid[i - 1][j] == '0' && grid[i][j - 1] == '0')) {
                        Set<Integer> firstSet = new HashSet<>();
                        firstSet.add(currentIndex);
                        unionSets.addLast(firstSet);
                    } else {
                        int leftIndex = currentIndex - 1;
                        int upperIndex = currentIndex - grid[i].length;
                        Set<Integer> leftSet = null;
                        Set<Integer> upperSet = null;
                        Iterator<Set<Integer>> setIterator = unionSets.iterator();
                        while (setIterator.hasNext()) {
                            Set<Integer> set = setIterator.next();
                            if (set.contains(leftIndex)) {
                                leftSet = set;
                            }
                            if (set.contains(upperIndex)) {
                                upperSet = set;
                            }
                        }
                        if (leftSet == null) {
                            upperSet.add(currentIndex);
                        } else if (upperSet == null) {
                            leftSet.add(currentIndex);
                        } else if (leftSet == upperSet) {
                            leftSet.add(currentIndex);
                        } else {
                            leftSet.addAll(upperSet);
                            leftSet.add(currentIndex);
                            unionSets.remove(upperSet);
                        }
                    }
                }
            }
        }
        return unionSets.size();
    }


    public static void main(String[] args) {
        IslandCount islandCount = new IslandCount();
//        char[][] island = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] island = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(islandCount.numIslandsByUnionFindSets(island));
    }
}
