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

    int base = 1000000007;

    public int numTilings(int n) {
        // Sn = 2 * S(n - 1) + S(n - 3)
        int a = 0, b = 1, c = 1;
        while (--n > 0) {
            int temp = c;
            c = ((2 * c) % base + a) % base;
            a = b;
            b = temp;
        }
        return c;
    }

    public static void main(String[] args) {
        Z6DominoCount test = new Z6DominoCount();
        // 5
        System.out.println(test.numTilings(3));
        // 2
        System.out.println(test.numTilings(2));
        // 11
        System.out.println(test.numTilings(4));
    }

}
