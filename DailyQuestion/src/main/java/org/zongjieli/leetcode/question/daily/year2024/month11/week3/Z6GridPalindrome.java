package org.zongjieli.leetcode.question.daily.year2024.month11.week3;

/**
 * 给定一个 m x n 的二进制矩阵 grid
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的,那么称这一行或者这一列是回文的
 * 可以将 grid 中任意格子的值翻转,也就是将格子里的值从 0 变成 1,或者从 1 变成 0
 * 请返回最少翻转次数,使得矩阵中所有行和列都是回文的,且矩阵中 1 的数目可以被 4 整除
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m * n <= 2 * 10^5
 * 0 <= grid[i][j] <= 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/11/16
 */
public class Z6GridPalindrome {

    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length, hm = m / 2, hn = n / 2, result = 0;
        for (int i = 0 ; i < hm ; i++) {
            for (int j = 0 ; j < hn ; j++) {
                // 矩阵分为四块(不包含单数的中间那列或行),则列和行需要回文则需要中心对称
                // 这部分的翻转次数按最小的即可
                int flipCount = grid[i][j] + grid[i][n - 1 - j] + grid[m - i - 1][j] + grid[m - i - 1][n - j - 1];
                result += (flipCount == 3 ? 1 : (flipCount == 4 ? 0 : flipCount));
            }
        }
        // 计算单列、单行需要反转的次数,即不需翻转时 1 的数量
        // 如果需要反转的次数大于等于 2 则最小翻转次数可以保证结果被 4 整除,否则需要与不需翻转的数据做计算
        int flipCount = 0, oneCount = 0;
        if (m % 2 != 0) {
            if (n % 2 != 0) {
                // 最中心的点必须为 0
                result += grid[hm][hn];
                // 翻转中间列
                for (int i = 0 ; i < hm ; i++) {
                    if (grid[i][hn] != grid[m - 1 - i][hn]) {
                        flipCount++;
                    } else if (grid[i][hn] == 1) {
                        oneCount++;
                    }
                }
            }
            // 翻转中间行
            for (int j = 0 ; j < hn ; j++) {
                if (grid[hm][j] != grid[hm][n - 1 - j]) {
                    flipCount++;
                } else if (grid[hm][j] == 1) {
                    oneCount++;
                }
            }
        } else if (n % 2 != 0) {
            // 翻转中间列
            for (int i = 0 ; i < hm ; i++) {
                if (grid[i][hn] != grid[m - 1 - i][hn]) {
                    flipCount++;
                } else if (grid[i][hn] == 1) {
                    oneCount++;
                }
            }
        }
        if (flipCount >= 1) {
            // 只要存在一次可用的翻转次数,便可通过控制翻转 0 还是 1 控制结果
            return result + flipCount;
        }
        // 此时无法翻转,根据 oneCount 计算最终翻转次数
        return result + (oneCount % 2) * 2;
    }

    public static void main(String[] args) {
        Z6GridPalindrome test = new Z6GridPalindrome();
        // 4
        System.out.println(test.minFlips(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

}
