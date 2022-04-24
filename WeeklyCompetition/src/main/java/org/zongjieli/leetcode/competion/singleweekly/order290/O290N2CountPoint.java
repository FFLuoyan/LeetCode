package org.zongjieli.leetcode.competion.singleweekly.order290;
/**
 * 给定一个二维整数数组 circles
 * 其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi)
 * 且半径为 ri 的第 i 个圆,返回出现在至少一个圆内的格点数目
 *
 * 注意:
 *  格点是指整数坐标对应的点
 *  圆周上的点也被视为出现在圆内的点
 *
 * 1 <= circles.length <= 200
 * circles[i].length == 3
 * 1 <= xi, yi <= 100
 * 1 <= ri <= min(xi, yi)
 *
 * @author   Li.zongjie
 * @date     2022/4/24
 * @version  1.0
 */
public class O290N2CountPoint {

    public int countLatticePoints(int[][] circles) {
        boolean[][] save = new boolean[201][201];
        for (int i = 0; i < circles.length; i++) {
            int x = circles[i][0], y = circles[i][1], r = circles[i][2];
            int rv = r * r;
            int xMax = x + r;
            for (int xv = x - r ; xv <= xMax ; xv++) {
                int yMax = y + r;
                for (int yv = y - r ; yv <= yMax ; yv++) {
                    if (!save[xv][yv] && (x - xv) * (x - xv) + (y - yv) * (y - yv) <= rv) {
                        save[xv][yv] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean[] r : save) {
            for (boolean v : r) {
                if (v) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        O290N2CountPoint test = new O290N2CountPoint();
        // 5
        System.out.println(test.countLatticePoints(new int[][]{{2, 2, 1}}));
    }
}
