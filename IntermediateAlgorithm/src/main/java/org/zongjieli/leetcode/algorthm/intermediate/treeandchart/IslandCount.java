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

    public int numIslandsByRecursion(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    recursion(grid,i,j);
                }
            }
        }
        return count;
    }

    public void recursion(char[][] grid, int rowIndex, int columnIndex) {
        grid[rowIndex][columnIndex] = '0';
        if (rowIndex > 0 && grid[rowIndex - 1][columnIndex] == '1') {
            recursion(grid, rowIndex - 1, columnIndex);
        }
        if (rowIndex < grid.length - 1 && grid[rowIndex + 1][columnIndex] == '1') {
            recursion(grid, rowIndex + 1, columnIndex);
        }
        if (columnIndex > 0 && grid[rowIndex][columnIndex - 1] == '1') {
            recursion(grid, rowIndex, columnIndex - 1);
        }
        if (columnIndex < grid[rowIndex].length - 1 && grid[rowIndex][columnIndex + 1] == '1') {
            recursion(grid, rowIndex, columnIndex + 1);
        }
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
                if (unionSets.size() != 0 && grid[0][i - 1] == '1') {
                    // 如果上一个数不为 '1',则直接加入最后一个 Set 中
                    unionSets.getLast().add(i);
                } else {
                    // 上一个数为 '0',或者当前没有小岛,则该小岛应为一个新的小岛
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
                // 遍历第一个节点,将该节点放入 Set 中
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
                    int leftIndex = currentIndex - 1;
                    int upperIndex = currentIndex - grid[i].length;
                    if (unionSets.size() == 0) {
                        // 当前小岛为独立的小岛
                        Set<Integer> newSet = new HashSet<>();
                        newSet.add(currentIndex);
                        unionSets.addLast(newSet);
                    } else if (grid[i - 1][j] == '0') {
                        // 上节点为海,则只用判断 left 节点
                        if (grid[i][j - 1] == '0') {
                            // Left 节点为海,新建一个小岛
                            Set<Integer> newSet = new HashSet<>();
                            newSet.add(currentIndex);
                            unionSets.addLast(newSet);
                        } else {
                            // 只存在 Left 节点为连接点
                            Iterator<Set<Integer>> setIterator = unionSets.iterator();
                            while (setIterator.hasNext()) {
                                Set<Integer> set = setIterator.next();
                                if (set.contains(leftIndex)) {
                                    set.add(currentIndex);
                                    break;
                                }
                            }
                        }
                    } else if (grid[i][j - 1] == '0') {
                        // 上节点为连接点,左节点为海
                        Iterator<Set<Integer>> setIterator = unionSets.iterator();
                        while (setIterator.hasNext()) {
                            Set<Integer> set = setIterator.next();
                            if (set.contains(upperIndex)) {
                                set.add(currentIndex);
                                break;
                            }
                        }
                    } else {
                        // 左右两个均为连接点
                        Set<Integer> leftSet = null;
                        Set<Integer> upperSet = null;
                        Iterator<Set<Integer>> setIterator = unionSets.iterator();
                        while ((leftSet == null || upperSet == null) && setIterator.hasNext()) {
                            Set<Integer> set = setIterator.next();
                            if (leftSet == null && set.contains(leftIndex)) {
                                leftSet = set;
                            }
                            if (upperSet == null && set.contains(upperIndex)) {
                                upperSet = set;
                            }
                        }
                        // 两个 Set 均有值
                        if (leftSet == upperSet) {
                            leftSet.add(currentIndex);
                        } else {
                            // 两个 Set 不一样,则合并
                            if (upperSet.size() > leftSet.size()) {
                                upperSet.add(currentIndex);
                                upperSet.addAll(leftSet);
                                unionSets.remove(leftSet);
                            } else {
                                leftSet.add(currentIndex);
                                leftSet.addAll(upperSet);
                                unionSets.remove(upperSet);
                            }
                        }
                    }
                }
            }
        }
        return unionSets.size();
    }

    /**
     * 并查集算法的数组实现
     *
     * @param grid Param Description
     * @return int
     * @Author Zongjie.Li
     * @Date 2020/5/20
     * @Version 1.0
     */
    public int numIslandsByUnionFindSetsByArray(char[][] grid) {
        // 获取每个元素的下标为 rowIndex * columnLength + columnIndex
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        LinkedList<Set<Integer>> unionSets = new LinkedList<>();
        int setCount = 1;
        int[][] gridSet = new int[grid.length][grid[0].length];

        // 计算第一行第一个节点
        if (grid[0][0] == '1') {
            Set set = new HashSet();
            set.add(setCount);
            unionSets.addFirst(set);
            gridSet[0][0] = setCount;
            setCount++;
        }

        // 计算第一行的剩余节点
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == '1') {
                // 此时需要判断前一个节点是否为陆地,如果为陆地则为同一个
                if (gridSet[0][i - 1] != 0) {
                    gridSet[0][i] = gridSet[0][i - 1];
                } else {
                    // 构建一个新的小岛
                    Set set = new HashSet();
                    set.add(setCount);
                    unionSets.addFirst(set);
                    gridSet[0][i] = setCount;
                    setCount++;
                }
            }
        }

        // 计算第二行至最后一行
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == '1') {
                // 计算第一个节点
                if (gridSet[i - 1][0] != 0) {
                    gridSet[i][0] = gridSet[i - 1][0];
                } else {
                    // 独立小岛
                    Set set = new HashSet();
                    set.add(setCount);
                    unionSets.addFirst(set);
                    gridSet[i][0] = setCount;
                    setCount++;
                }
            }

            // 计算第二行起的每行的剩余节点
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果左节点有值
                    int leftSet = gridSet[i][j - 1];
                    int upperSet = gridSet[i - 1][j];
                    if (leftSet != 0) {
                        if (upperSet != 0) {
                            // 如果上节点也有值
                            gridSet[i][j] = leftSet;
                            if (leftSet != upperSet) {
                                // 两个节点值不相等
                                Set<Integer> leftGroup = null;
                                Set<Integer> upperGroup = null;
                                Iterator<Set<Integer>> iterator = unionSets.iterator();
                                while (iterator.hasNext() && (leftGroup == null || upperGroup == null)) {
                                    Set<Integer> set = iterator.next();
                                    if (leftGroup == null && set.contains(leftSet)) {
                                        leftGroup = set;
                                    }
                                    if (upperGroup == null && set.contains(upperSet)) {
                                        upperGroup = set;
                                    }
                                }
                                if (leftGroup == upperGroup) {
                                    gridSet[i][j] = leftSet;
                                } else {
                                    if (leftGroup.size() > upperGroup.size()) {
                                        leftGroup.addAll(upperGroup);
                                        unionSets.remove(upperGroup);
                                    } else {
                                        upperGroup.addAll(leftGroup);
                                        unionSets.remove(leftGroup);
                                    }
                                }
                            }
                        } else {
                            // 左节点有值,上节点无值
                            gridSet[i][j] = leftSet;
                        }
                    } else if (upperSet != 0) {
                        // 左节点无值,上节点有值
                        gridSet[i][j] = upperSet;
                    } else {
                        // 左右节点都无值,构建新的小岛
                        Set set = new HashSet();
                        set.add(setCount);
                        unionSets.addFirst(set);
                        gridSet[i][j] = setCount;
                        setCount++;
                    }

                }
            }
        }
        return unionSets.size();
    }


    public static void main(String[] args) {
        IslandCount islandCount = new IslandCount();
        //char[][] island = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] island = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(islandCount.numIslandsByRecursion(island));
    }
}
