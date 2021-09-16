package org.zongjieli.leetcode.question.daily.year2021.month9.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对互不相同的点 points,其中 points[i] = [xi, yi]
 * 回旋镖是由点 (i, j, k) 表示的元组
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等(需要考虑元组的顺序)
 *
 * 返回平面上所有回旋镖的数量
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都互不相同
 *
 * @author   Li.zongjie
 * @date     2021/9/13
 * @version  1.0
 */
public class Z1BoomerangNumber {
    public int numberOfBoomerangs(int[][] points) {
        int[][] length = new int[points.length][points.length];
        for (int firstPoint = 0 ; firstPoint < points.length ; firstPoint++){
            for (int secondPoint = 1 ; secondPoint < points.length ; secondPoint++){
                int xL = points[firstPoint][0] - points[secondPoint][0];
                int yL = points[firstPoint][1] - points[secondPoint][1];
                int lengthPower = xL * xL + yL * yL;
                length[firstPoint][secondPoint] = lengthPower;
                length[secondPoint][firstPoint] = lengthPower;
            }
        }

        int result = 0;
        Map<Integer,Integer> count = new HashMap<>(2 * points.length);
        for (int[] lengths : length) {
            for (int i : lengths) {
                result += (count.merge(i,1,Integer::sum) - 1);
            }
            count.clear();
        }

        return 2 * result;
    }

    public static void main(String[] args) {
        Z1BoomerangNumber test = new Z1BoomerangNumber();
        System.out.println(test.numberOfBoomerangs(new int[][]{new int[]{0,0},new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}}));; // 20
    }
}
