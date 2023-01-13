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

    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        for (int i = lowLimit ; i <= highLimit ; i++) {
            int num = i, sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        return max;
    }

}
