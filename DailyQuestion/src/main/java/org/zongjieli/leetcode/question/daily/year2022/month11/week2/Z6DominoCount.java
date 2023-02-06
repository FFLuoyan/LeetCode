package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

/**
 * 有两种形状的瓷砖: 一种是 2 x 1 的多米诺形,另一种是形如 "L" 的托米诺形,两种形状都可以旋转
 * 给定整数 n,返回可以平铺 2 x n 的面板的方法的数量, 返回对 10^9 + 7 取模的值
 * 平铺指的是每个正方形都必须有瓷砖覆盖
 * 两个平铺不同,当且仅当面板上有四个方向上的相邻单元中的两个,使得恰好有一个平铺有一个瓷砖占据两个正方形
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z6DominoCount {

    int[] result = new int[1001];
    int base = 1000000007;

    public int numTilings(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (result[n] != 0) {
            return result[n];
        }
        int cr = numTilings(n - 1) % base;
        cr = (cr + numTilings(n - 2)) % base;
        for (int i = 3 ; i <= n ; i++) {
            cr = ((2 * numTilings(n - i)) % base + cr) % base;
        }
        return result[n] = cr;
    }

    public static void main(String[] args) {
        Z6DominoCount test = new Z6DominoCount();
        // 5
        System.out.println(test.numTilings(3));
        // 2
        System.out.println(test.numTilings(2));
    }

}
