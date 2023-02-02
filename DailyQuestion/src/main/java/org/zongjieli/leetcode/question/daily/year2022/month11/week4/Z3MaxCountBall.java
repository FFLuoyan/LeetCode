package org.zongjieli.leetcode.question.daily.year2022.month11.week4;

/**
 * 在一家生产小球的玩具厂工作,有 n 个小球,编号从 lowLimit 开始,到 highLimit 结束
 * 包括 lowLimit 和 highLimit,即 n == highLimit - lowLimit + 1
 * 另有无限数量的盒子,编号从 1 到 infinity
 * 将每个小球放入盒子中,其中盒子的编号应当等于小球编号上每位数字的和
 * 例如,编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子
 * 而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子
 * 给定两个整数 lowLimit 和 highLimit,返回放有最多小球的盒子中的小球数量
 * 如果有多个盒子都满足放有最多小球,只需返回其中任一盒子的小球数量
 *
 * 1 <= lowLimit <= highLimit <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/13
 */
public class Z3MaxCountBall {

    // 从 0 开始至 9, 99, 999, 9999, 99999 各个盒子内共有多少个数
    int[][] count = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            , {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
            , {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1}
            , {1, 4, 10, 20, 35, 56, 84, 120, 165, 220, 282, 348, 415, 480, 540, 592, 633, 660, 670, 660, 633, 592, 540, 480, 415, 348, 282, 220, 165, 120, 84, 56, 35, 20, 10, 4, 1}
            , {1, 5, 15, 35, 70, 126, 210, 330, 495, 715, 996, 1340, 1745, 2205, 2710, 3246, 3795, 4335, 4840, 5280, 5631, 5875, 6000, 6000, 5875, 5631, 5280, 4840, 4335, 3795, 3246, 2710, 2205, 1745, 1340, 996, 715, 495, 330, 210, 126, 70, 35, 15, 5, 1}
    };

    public int countBalls(int lowLimit, int highLimit) {
        int[] high = getBallNumber(highLimit);
        int[] low = getBallNumber(lowLimit - 1);
        int result = 0;
        for (int i = 0; i < low.length; i++) {
            result = Math.max(result, high[i] - low[i]);
        }
        return result;
    }

    private int[] getBallNumber(int max) {
        int[] result = new int[count[4].length];
        if (max == 100000) {
            System.arraycopy(count[4], 0, result, 0, count[4].length);
            result[1]++;
            return result;
        }
        int[] value = new int[5];
        int i = 0;
        while (max > 0) {
            value[i++] = max % 10;
            max /= 10;
        }
        int before = 0;
        while (--i > 0) {
            int[] base = count[i - 1];
            for (int j = 0 ; j < value[i] ; j++) {
                for (int k = 0; k < base.length; k++) {
                    result[k + j + before] += base[k];
                }
            }
            before += value[i];
        }
        for (int j = 0 ; j <= value[0] ; j++) {
            result[before + j]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z3MaxCountBall test = new Z3MaxCountBall();
        // 2
        System.out.println(test.countBalls(19, 28));
        // 32
        System.out.println(test.countBalls(220, 548));
    }

}
