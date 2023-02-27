package org.zongjieli.leetcode.competion.singleweekly.order334;

import java.util.*;

/**
 * 给定一个 m x n 的矩阵 grid,每个元素都为非负整数
 * 其中 grid[row][col] 表示可以访问格子 (row, col) 的最早时间
 * 也就是说当访问格子 (row, col) 时,最少已经经过的时间为 grid[row][col]
 * 从最左上角出发,出发时刻为 0,必须一直移动到上下左右相邻四个格子中的任意一个格子(即不能停留在格子上)
 * 每次移动都需要花费 1 单位时间
 * 请返回最早到达右下角格子的时间,如果无法到达右下角的格子,请返回 -1
 *
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 10^5
 * 0 <= grid[i][j] <= 10^5
 * grid[0][0] == 0
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/26
 */
public class O334N4MinTime {

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int[][] minTimes = new int[m--][n--];
        for (int[] row : minTimes) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        LinkedList<Integer> wait = new LinkedList<>();
        minTimes[0][0] = 0;
        wait.add(0);
        while (!wait.isEmpty()) {
            move(wait.poll(), grid, minTimes, m, n, wait);
        }
        return minTimes[m][n];
    }

    public void move(int position, int[][] grid, int[][] minTime, int m, int n, LinkedList<Integer> wait) {
        int x = position >> 10, y = position & 1023;
        if (x == m && y == n) {
            return;
        }
        int currentTime = minTime[x][y] + 1;
        if (x < m) {
            addMove(x + 1, y, currentTime, grid, minTime, wait);
        }
        if (x > 0){
            addMove(x - 1, y, currentTime, grid, minTime, wait);
        }
        if (y > 0) {
            addMove(x, y - 1, currentTime, grid, minTime, wait);
        }
        if (y < n) {
            addMove(x, y + 1, currentTime, grid, minTime, wait);
        }
    }

    private void addMove(int i, int j, int currentTime, int[][] grid, int[][] minTimes, LinkedList<Integer> wait) {
        if (grid[i][j] > currentTime) {
            int diff = grid[i][j] - currentTime;
            currentTime += (diff % 2 == 0 ? diff : diff + 1);
        }
        if (minTimes[i][j] > currentTime) {
            minTimes[i][j] = currentTime;
            wait.add((i << 10) + j);
        }
    }

    public static void main(String[] args) {
        O334N4MinTime test = new O334N4MinTime();
        // 7
        System.out.println(test.minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}}));
        // -1
        System.out.println(test.minimumTime(new int[][]{{0, 2, 4}, {3, 2, 1}, {1, 0, 4}}));

        Random random = new Random();
        int[][] v = new int[400][400];
        for (int[] ints : v) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = random.nextInt(100000);
            }
        }
        v[0][1] = 0;
        long time = System.currentTimeMillis();
        System.out.println(test.minimumTime(v));
        System.out.println("Time Cost: " + (time - System.currentTimeMillis()));
    }

}
