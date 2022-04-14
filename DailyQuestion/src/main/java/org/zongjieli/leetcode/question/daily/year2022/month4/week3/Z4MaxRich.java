package org.zongjieli.leetcode.question.daily.year2022.month4.week3;
/**
 * 给定一个 m x n 的整数网格 accounts
 * 其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量
 * 返回最富有客户所拥有的资产总量
 *
 * 客户的资产总量就是他们在各家银行托管的资产数量之和
 * 最富有客户就是资产总量最大的客户
 *
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/4/14
 * @version  1.0
 */
public class Z4MaxRich {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int current = 0;
            for (int m : account) {
                current += m;
            }
            max = Math.max(current, max);
        }
        return max;
    }
}
