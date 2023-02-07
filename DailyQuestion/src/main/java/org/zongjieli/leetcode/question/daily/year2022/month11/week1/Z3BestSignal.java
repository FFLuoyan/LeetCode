package org.zongjieli.leetcode.question.daily.year2022.month11.week1;

import java.util.Arrays;

/**
 * 给定一个数组 towers 和一个整数 radius
 * 数组 towers 中包含一些网络信号塔
 * 其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi
 * 所有坐标都是在 X-Y 坐标系内的整数坐标
 * 两个坐标之间的距离用欧几里得距离计算
 * 整数 radius 表示一个塔能到达的最远距离
 * 如果一个坐标跟塔的距离在 radius 以内,那么该塔的信号可以到达该坐标
 * 在这个范围以外信号会很微弱,所以 radius 以外的距离该塔是不能到达的
 * 如果第 i 个塔能到达 (x, y),那么该塔在此处的信号为 floor((qi / (1 + d))(向下取整)
 * 其中 d 是塔跟此坐标的距离,一个坐标的信号强度是所有能到达该坐标的塔的信号强度之和
 * 请返回数组 [cx, cy],表示信号强度最大的整数坐标点 (cx, cy)
 * 如果有多个坐标网络信号一样大,请返回字典序最小的非负坐标
 * 注意:
 *  坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小,需满足以下条件之一:
 *      要么 x1 < x2
 *      要么 x1 == x2 且 y1 < y2
 *
 * 1 <= towers.length <= 50
 * towers[i].length == 3
 * 0 <= xi, yi, qi <= 50
 * 1 <= radius <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/7
 */
public class Z3BestSignal {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] result = new int[]{50, 50, -1};
        int[][] grid = new int[150][150];
        for (int[] tower : towers) {
            int x = tower[0] + 50, y = tower[1] + 50;
            int maxD = Math.min(tower[2] - 1, radius);
            int minX = x - maxD;
            int maxX = x + maxD;
            int minY = y - maxD;
            int maxY = y + maxD;
            for (int i = minX ; i <= maxX ; i++) {
                for (int j = minY ; j <= maxY ; j++) {
                    double distance = Math.sqrt((i - x) * (i - x) + (j - y) * (j - y));
                    if (distance <= radius) {
                        int v = grid[i][j] += Math.floor(tower[2] / (1 + distance));
                        if (v > result[2]) {
                            result[0] = i;
                            result[1] = j;
                            result[2] = v;
                        } else if (v == result[2]) {
                            if (i < result[0]) {
                                result[0] = i;
                                result[1] = j;
                            } else if (i == result[0] && j < result[1]) {
                                result[1] = j;
                            }
                        }
                    }
                }
            }
        }
        return new int[]{result[0] - 50, result[1] - 50};
    }

    public static void main(String[] args) {
        Z3BestSignal test = new Z3BestSignal();
        // [0, 0]
        System.out.println(Arrays.toString(test.bestCoordinate(new int[][]{{42, 0, 0}}, 7)));
    }
}
