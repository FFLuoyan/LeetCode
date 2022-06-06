package org.zongjieli.leetcode.question.daily.year2022.month6.week2;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定圆的半径和圆心的位置,实现函数 randPoint,在圆中产生均匀随机点
 *
 * 实现 Z1RandomPoint 类:
 *
 * Z1RandomPoint(double radius, double x_center, double y_center)
 *  用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 
 *  返回圆内的一个随机点,圆周上的一点被认为在圆内,答案作为数组返回 [x, y]
 *  
 * 0 < radius <= 10^8
 * -10^7 <= x_center, y_center <= 10^7
 * randPoint 最多被调用 3 * 10^4 次
 *
 * @author   Li.zongjie
 * @date     2022/6/6
 * @version  1.0
 */
public class Z1RandomPoint {

    private Random random;
    private double r;
    private double x;
    private double y;

    public Z1RandomPoint(double radius, double x_center, double y_center) {
        this.random = new Random();
        this.r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double rx = (random.nextDouble() * 2 - 1) * r + x;
        double ry = (random.nextDouble() * 2 - 1) * r + y;
        return (rx - x) * (rx - x) + (ry - y) * (ry - y) <= r * r ? new double[]{rx, ry} : randPoint();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Z1RandomPoint(0.01, 0.000001, 999999).randPoint()));
    }
}
