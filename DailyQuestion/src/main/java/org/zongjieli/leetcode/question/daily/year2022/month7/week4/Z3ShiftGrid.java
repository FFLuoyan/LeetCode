package org.zongjieli.leetcode.question.daily.year2022.month7.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m 行 n 列的二维网格 grid 和一个整数 k
 * 需要将 grid 迁移 k 次
 * 每次迁移操作将会引发下述活动:
 *  位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 *  位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 *  位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请返回 k 次迁移操作后最终得到的二维网格
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * @author   Li.zongjie
 * @date     2022/7/20
 * @version  1.0
 */
public class Z3ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int sr = m - 1 - k / n;
        int sc = n - k % n;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cr = new ArrayList<>();
        result.add(cr);
        for (int i = sc ; i < n ; i++) {
            cr.add(grid[sr][i]);
        }
        for (int i = sr + 1 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (cr.size() == n) {
                    cr = new ArrayList<>();
                    result.add(cr);
                }
                cr.add(grid[i][j]);
            }
        }
        for (int i = 0 ; i < sr ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (cr.size() == n) {
                    cr = new ArrayList<>();
                    result.add(cr);
                }
                cr.add(grid[i][j]);
            }
        }
        if (cr.size() == n) {
            cr = new ArrayList<>();
            result.add(cr);
        }
        for (int i = 0 ; i < sc ; i++) {
            cr.add(grid[sr][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Z3ShiftGrid test = new Z3ShiftGrid();
        // [[6], [5], [1], [2], [3], [4], [7]]
        System.out.println(test.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
    }
}
