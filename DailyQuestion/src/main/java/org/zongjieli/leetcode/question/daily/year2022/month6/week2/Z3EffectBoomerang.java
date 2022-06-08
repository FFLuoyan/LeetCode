package org.zongjieli.leetcode.question.daily.year2022.month6.week2;
/**
 * 给定一个数组 points,其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点
 * 如果这些点构成一个回旋镖则返回 true
 * 回旋镖定义为一组三个点,这些点各不相同且不在一条直线上
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 *
 * @author   Li.zongjie
 * @date     2022/6/8
 * @version  1.0
 */
public class Z3EffectBoomerang {

    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[1][0]) != (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]);
    }
}
