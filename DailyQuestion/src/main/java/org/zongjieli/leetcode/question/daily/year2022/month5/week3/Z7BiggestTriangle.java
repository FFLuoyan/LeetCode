package org.zongjieli.leetcode.question.daily.year2022.month5.week3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定包含多个点的集合,从其中取三个点组成三角形,返回能组成的最大三角形的面积
 *
 * 3 <= points.length <= 50
 * 不存在重复的点
 * -50 <= points[i][j] <= 50
 * 结果误差值在 10^-6 以内都认为是正确答案
 *
 * @author   Li.zongjie
 * @date     2022/5/18
 * @version  1.0
 */
public class Z7BiggestTriangle {

    public double largestTriangleArea(int[][] points) {
        // 按照 x 坐标排序
        double max = 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        for (int i = 0 ; i < points.length ; i++) {
            int p1x = points[i][0];
            int p1y = points[i][1];
            for (int j = i + 1 ; j < points.length ; j++) {
                int p2x = points[j][0];
                int p2y = points[j][1];
                for (int k = j + 1 ; k < points.length ; k++) {
                    int p3x = points[k][0];
                    int p3y = points[k][1];
                    if (p3x == p1x) {
                        continue;
                    }
                    if (p1x == p2x) {
                        max = Math.max(max, Math.abs(p1y - p2y) * (p3x - p1x) / 2.0);
                    } else if (p3x == p2x) {
                        max = Math.max(max, Math.abs(p3y - p2y) * (p3x - p1x) / 2.0);
                    } else if (p1y == p2y) {
                        max = Math.max(max, (p2x - p1x) * Math.abs(p3y - p1y) / 2.0);
                    } else if (p3y == p2y) {
                        max = Math.max(max, (p3x - p2x) * Math.abs(p3y - p1y) / 2.0);
                    } else {
                        double yt = 1d * (p3x - p1x) * (p2y - p1y) / (p2x - p1x) + p1y;
                        max = Math.max(max, Math.abs(yt - p3y) * (p2x - p1x) / 2);
                    }
                }
            }
        }
        return max;
    }
}
