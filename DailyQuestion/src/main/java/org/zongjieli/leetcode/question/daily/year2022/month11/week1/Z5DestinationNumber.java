package org.zongjieli.leetcode.question.daily.year2022.month11.week1;

/**
 * 在一根无限长的数轴上,站在 0 的位置,终点在 target 的位置
 * 可以做一些数量的移动 numMoves:
 *  每次可以选择向左或向右移动
 *  第 i 次移动(从  i == 1 开始,到 i == numMoves)在选择的方向上走 i 步
 * 给定整数 target,返回到达目标所需的最小移动次数(即最小 numMoves )
 *
 * -10^9 <= target <= 10^9
 * target != 0
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/7
 */
public class Z5DestinationNumber {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int result = (int) (Math.sqrt(2 * target + 0.25) - 0.5);
        long sum = (1 + result) * result / 2;
        if (sum < target) {
            sum = sum + ++result;
        }
        if ((sum - target) % 2 == 0) {
            return result;
        }
        return (result + 1) % 2 == 0 ? result + 2 : result + 1;
    }

}
