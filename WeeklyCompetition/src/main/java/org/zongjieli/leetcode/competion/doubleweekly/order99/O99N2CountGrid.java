package org.zongjieli.leetcode.competion.doubleweekly.order99;

/**
 * 有一个无穷大的二维网格图,一开始所有格子都未染色
 * 给定一个正整数 n,表示需要执行以下步骤 n 分钟:
 * 第一分钟,将任一格子染成蓝色
 * 之后的每一分钟,将与蓝色格子相邻的所有未染色格子染成蓝色
 * 下图分别是 1、2、3 分钟后的网格图
 * 1    1           1
 *    1 1 1       1 1 1
 *      1       1 1 1 1 1
 *                1 1 1
 *                  1
 * 请返回 n 分钟之后被染色的格子数目
 *
 * 1 <= n <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/4
 */
public class O99N2CountGrid {
    public long coloredCells(int n) {
        long r = 1L;
        for (int i = 1 ; i < n ; i++) {
            r += 4 * i;
        }
        return r;
    }
}
