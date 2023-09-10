package org.zongjieli.leetcode.competion.singleweekly.order362;

/**
 * 给定四个整数 sx、sy、fx、fy 以及一个非负整数 t
 * 在一个无限的二维网格中,从单元格 (sx, sy) 开始出发
 * 每一秒必须移动到任一与之前所处单元格相邻的单元格中
 * 如果能在恰好 t 秒后到达单元格(fx, fy),返回 true,否则返回 false
 * 单元格的相邻单元格是指该单元格周围与其至少共享一个角的 8 个单元格,可以多次访问同一个单元格
 *
 * 1 <= sx, sy, fx, fy <= 10^9
 * 0 <= t <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/10
 */
public class O362N2CanMove {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minX = Math.abs(sx - fx), minY = Math.abs(sy - fy);
        if (minX == 0 && minY == 0) {
            return t != 1;
        }
        return minX + minY - Math.min(minX, minY) <= t;
    }

}
