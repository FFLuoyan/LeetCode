package org.zongjieli.leetcode.question.daily.year2021.month9.week5;
/**
 * 给定二维平面上两个由直线构成的矩形,请计算并返回两个矩形覆盖的总面积
 * 每个矩形由其左下顶点和右上顶点坐标表示:
 *  第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义
 *  第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义
 *  
 * -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 *
 * @author   Li.zongjie
 * @date     2021/9/30
 * @version  1.0
 */
public class Z4RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aX = ax2 - ax1;
        int aY = ay2 - ay1;
        int bX = bx2 - bx1;
        int bY = by2 - by1;
        int xB = ax2 - bx1;
        int xA = bx2 - ax1;
        int yB = by2 - ay1;
        int yA = ay2 - by1;
        int areaA = aX * aY;
        int areaB = bX * bY;

        if (xB <= 0 || xA <= 0|| yB <= 0 || yA <= 0){
            // 矩形无相交区域
            return areaA + areaB;
        }
        // 相加区域 x 长度

        int xLength = bx1 > ax1 ? (bx2 > ax2 ? xB : bX) : (bx2 > ax2 ? aX : xA);
        int yLength = by1 > ay1 ? (by2 > ay2 ? yA : bY) : (by2 > ay2 ? aY : yB);

        return areaA + areaB - xLength * yLength;
    }
}
