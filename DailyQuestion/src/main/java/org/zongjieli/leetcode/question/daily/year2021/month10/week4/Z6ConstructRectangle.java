package org.zongjieli.leetcode.question.daily.year2021.month10.week4;
/**
 * 给定一个具体的矩形页面面积
 * 设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面
 * 要求:
 *  1. 设计的矩形页面必须等于给定的目标面积
 *  2. 宽度 W 不应大于长度 L,换言之,要求 L >= W
 *  3. 长度 L 和宽度 W 之间的差距应当尽可能小
 *
 * 按顺序输出设计的页面的长度 L 和宽度 W
 *
 * 给定的面积不大于 10,000,000 且为正整数
 * 设计的页面的长度和宽度必须都是正整数
 *
 * @author   Li.zongjie
 * @date     2021/10/27
 * @version  1.0
 */
public class Z6ConstructRectangle {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0){
            w = area / ((area / w) + 1);
        }
        return new int[]{area / w, w};
    }
}
