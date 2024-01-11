package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

/**
 * 给定平面上 n 对互不相同的点 points,其中 points[i] = [xi, yi]
 * 回旋镖是由点 (i, j, k) 表示的元组
 * 其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等(直线距离,且需要考虑元组的顺序)
 * 返回平面上所有回旋镖的数量
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/8
 */
public class Z1CountBoomerang {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = points.length - 1; i >= 0; i--) {
            int fx = points[i][0], fy = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int sx = points[j][0], sy = points[j][1];
                int ax = fx - sx, ay = fy - sy, l1 = ax * ax + ay * ay;
                for (int k = j + 1; k < points.length; k++) {
                    int tx = points[k][0], ty = points[k][1];
                    int bx = tx - sx, by = ty - sy, l2 = bx * bx + by * by;
                    int cx = tx - fx, cy = ty - fy, l3 = cx * cx + cy * cy;
                    if (l1 == l2) {
                        result += 2;
                    }
                    if (l1 == l3) {
                        result += 2;
                    }
                    if (l2 == l3) {
                        result += 2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z1CountBoomerang test = new Z1CountBoomerang();
        // 20
        System.out.println(test.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));
    }
}
