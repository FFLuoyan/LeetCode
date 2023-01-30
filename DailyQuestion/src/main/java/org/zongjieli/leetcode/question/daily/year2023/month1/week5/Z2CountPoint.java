package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 给定一个数组 points,其中 points[i] = [xi, yi]
 * 表示第 i 个点在二维平面上的坐标,多个点可能会有相同的坐标
 * 同时给定一个数组 queries,其中 queries[j] = [xj, yj, rj]
 * 表示一个圆心在 (xj, yj) 且半径为 rj 的圆
 * 对于每一个查询 queries[j],计算在第 j 个圆内点的数目
 * 如果一个点在圆的边界上,我们同样认为它在圆内
 * 请返回一个数组 answer,其中 answer[j]是第 j 个查询的答案
 *
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= xi, yi <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/30
 */
public class Z2CountPoint {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int cx = query[0], cy = query[1], r = query[2], r2 = r * r, xv, yv;
            for (int[] point : points) {
                if ((xv = point[0] - cx) * xv + (yv = point[1] - cy) * yv <= r2) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

}
