package org.zongjieli.leetcode.question.daily.year2022.month4.week2;
/**
 * 给定四个整数 sx, sy, tx 和 ty
 * 如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty),则返回 true,否则返回 false
 * 从点 (x, y) 可以转换到 (x, x + y)  或者 (x + y, y)
 *
 * 1 <= sx, sy, tx, ty <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/4/9
 * @version  1.0
 */
public class Z6Transform {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) {
            return false;
        }
        if (sx == tx && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % sy == 0) {
            return true;
        }
        return tx > ty ? reachingPoints(sx, sy, tx % ty, ty) : reachingPoints(sx, sy, tx, ty % tx);
    }

    public static void main(String[] args) {
        Z6Transform test = new Z6Transform();
        // true
        System.out.println(test.reachingPoints(1, 1, 1000000000, 1));
        // true
        System.out.println(test.reachingPoints(1, 1, 3, 5));
        // false
        System.out.println(test.reachingPoints(1, 1, 2, 2));
    }
}
