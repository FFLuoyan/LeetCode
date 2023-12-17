package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

/**
 * 参加一场远足活动,给定一个二维 rows x columns 的地图 heights
 * 其中 heights[row][col] 表示格子 (row, col) 的高度
 * 一开始在最左上角的格子 (0, 0),且希望去最右下角的格子 (rows - 1, columns - 1)
 * 注意: 下标从 0 开始编号
 * 每次可以往上、下、左、右四个方向之一移动
 * 想要找到耗费体力最小的一条路径
 * 一条路径耗费的体力值是路径上相邻格子之间高度差绝对值的最大值决定的
 * 请返回从左上角走到右下角的最小体力消耗值
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/17
 */
public class Z1MinPath {

    private int m, n, length;

    public int[] values, indexes;

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        values = new int[length = m * n];
        indexes = new int[length];
        indexes[0] = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(heights[i], 0, values, i * n, n);
        }
        int min = 0, max = 1000000;
        while (min < max) {
            int middle = (min + max) / 2;
            if (canReach(middle)) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        return min;
    }

    public boolean canReach(int minCost) {
        boolean[] reaches = new boolean[values.length];
        reaches[0] = true;
        int left = 0, right = 1, ci, cv, ni;
        while (left < right) {
            ci = indexes[left++];
            cv = values[ci];
            if (ci < length - n && !reaches[ni = ci + n] && Math.abs(cv - values[ni]) <= minCost) {
                // 下
                reaches[ni] = true;
                indexes[right++] = ni;
            }
            if ((ci % n) < (n - 1) && !reaches[ni = ci + 1] && Math.abs(cv - values[ni]) <= minCost) {
                // 右
                reaches[ni] = true;
                indexes[right++] = ni;
            }
            if (ci >= n && !reaches[ni = ci - n] && Math.abs(cv - values[ni]) <= minCost) {
                // 上
                reaches[ni] = true;
                indexes[right++] = ni;
            }
            if ((ci % n) > 0 && !reaches[ni = ci - 1] && Math.abs(cv - values[ni]) <= minCost) {
                // 左
                reaches[ni] = true;
                indexes[right++] = ni;
            }
        }
        return reaches[length - 1];
    }

    public static void main(String[] args) {
        Z1MinPath test = new Z1MinPath();
        // 5
        System.out.println(test.minimumEffortPath(new int[][]{{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}}));
    }
}
