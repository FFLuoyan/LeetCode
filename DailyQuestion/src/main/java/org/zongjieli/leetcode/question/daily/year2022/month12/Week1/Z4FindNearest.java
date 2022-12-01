package org.zongjieli.leetcode.question.daily.year2022.month12.Week1;

/**
 * 给定两个整数 x 和 y,表示在一个笛卡尔坐标系下的 (x, y) 处
 * 同时,在同一个坐标系下给定一个数组 points
 * 其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点
 * 当一个点与位置 (x, y) 有相同的 x 坐标或者相同的 y 坐标时,称这个点是有效的
 * 请返回距离当前位置曼哈顿距离最近的有效点的下标(下标从 0 开始)
 * 如果有多个最近的有效点,请返回下标最小的一个,如果没有有效点则返回 -1
 * 两个点 (x1, y1) 和 (x2, y2) 之间的曼哈顿距离为 abs(x1 - x2) + abs(y1 - y2)
 *
 * 1 <= points.length <= 10^4
 * points[i].length == 2
 * 1 <= x, y, ai, bi <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/1
 */
public class Z4FindNearest {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = points.length;
        int length = 10000;
        for (int i = 0; i < points.length; i++) {
            int cl = length;
            if (points[i][0] == x) {
                cl = Math.abs(y - points[i][1]);
            } else if (points[i][1] == y) {
                cl = Math.abs(x - points[i][0]);
            }
            if (cl < length) {
                length = cl;
                result = i;
            }
        }
        return result == points.length ? -1 : result;
    }
}
