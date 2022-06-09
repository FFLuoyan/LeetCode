package org.zongjieli.leetcode.question.daily.year2022.month6.week2;

import java.util.*;

/**
 * 给定一个由非重叠的轴对齐矩形的数组 rects
 * 其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点
 * (xi, yi) 是第 i 个矩形的右上角点
 * 设计一个算法来随机挑选一个被某一矩形覆盖的整数点
 * 矩形周长上的点也算做是被矩形覆盖
 * 所有满足要求的点必须等概率被返回
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回
 * 请注意,整数点是具有整数坐标的点
 *
 * 实现 Z4RandomPointRectangles 类:
 *  Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象
 *  int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内
 *  
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -10^9 <= ai < xi <= 10^9
 * -10^9 <= bi < yi <= 10^9
 * xi - ai <= 2000
 * yi - bi <= 2000
 * 所有的矩形不重叠
 * pick 最多被调用 10^4 次
 *
 * @author   Li.zongjie
 * @date     2022/6/9
 * @version  1.0
 */
public class Z4RandomPointRectangles {

    private int[] sum;
    private int[][] rects;
    private Random random = new Random();

    public Z4RandomPointRectangles(int[][] rects) {
        this.rects = rects;
        sum = new int[rects.length];
        int currentCount = 0;
        for (int i = 0 ; i < rects.length ; i++) {
            int[] rect = rects[i];
            sum[i] = (currentCount += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1));
        }
    }

    public int[] pick() {
        int cp = random.nextInt(sum[sum.length - 1]);
        int index = 0;
        while (cp >= sum[index]) {
            index++;
        }
        if (index > 0) {
            cp -= sum[index - 1];
        }
        int[] rect = rects[index];
        int xl = rect[2] - rect[0] + 1;
        return new int[]{rect[0] + cp % xl, rect[1] + cp / xl};
    }

    public static void main(String[] args) {
        Z4RandomPointRectangles test = new Z4RandomPointRectangles(new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(Arrays.toString(test.pick()));
        }
    }
}
