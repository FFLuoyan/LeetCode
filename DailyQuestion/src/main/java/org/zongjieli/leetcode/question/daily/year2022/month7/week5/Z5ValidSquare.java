package org.zongjieli.leetcode.question.daily.year2022.month7.week5;

/**
 * 给定 2D 空间中四个点的坐标 p1, p2, p3 和 p4
 * 如果这四个点构成一个正方形,则返回 true
 * 点的坐标 pi 表示为 [xi, yi]
 * 输入不是按任何顺序给出的
 * 一个有效的正方形有四条等边和四个等角(90度角)
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -104 <= xi, yi <= 104
 *
 * @author   Li.zongjie
 * @date     2022/7/29
 * @version  1.0
 */
public class Z5ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return validSquareOrdered(p1, p2, p3, p4)
                || validSquareOrdered(p1, p2, p4, p3)
                || validSquareOrdered(p1, p3, p2, p4)
                || validSquareOrdered(p1, p3, p4, p2)
                || validSquareOrdered(p1, p4, p2, p3)
                || validSquareOrdered(p1, p4, p3, p2);
    }

    public boolean validSquareOrdered(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x , y;
        return (x = p2[0] - p1[0]) == p2[1] - p3[1] && x == p3[0] - p4[0] && x == p1[1] - p4[1]
                && (y = p2[1] - p1[1]) == p3[0] - p2[0] && y == p3[1] - p4[1] && y == p4[0] - p1[0] && !(x == 0 && y == 0);
    }

    public static void main(String[] args) {
        Z5ValidSquare test = new Z5ValidSquare();
        // true
        System.out.println(test.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }
}
