package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

/**
 * 给定两个下标从 0 开始的整数数组 player1 和 player2,分别表示玩家 1 和玩家 2 击中的瓶数
 * 保龄球比赛由 n 轮组成,每轮的瓶数恰好为 10
 * 假设玩家在第 i 轮中击中 xi 个瓶子,玩家第 i 轮的价值为:
 *  如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子则为 2xi,否则为 xi
 * 玩家的得分是其 n 轮价值的总和
 * 返回
 *  如果玩家 1 的得分高于玩家 2 的得分,则为 1
 *  如果玩家 2 的得分高于玩家 1 的得分,则为 2
 *  如果平局则为 0
 *
 * n == player1.length == player2.length
 * 1 <= n <= 1000
 * 0 <= player1[i], player2[i] <= 10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/27
 */
public class Z3GameWinner {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0, score2 = 0, multiple, result1 = 0, result2 = 0;
        for (int score : player1) {
            multiple = 1;
            if (score1 == 10 || score2 == 10) {
                multiple = 2;
            }
            result1 += multiple * score;
            score1 = score2;
            score2 = score;
        }
        score1 = 0;
        score2 = 0;
        for (int score : player2) {
            multiple = 1;
            if (score1 == 10 || score2 == 10) {
                multiple = 2;
            }
            result2 += multiple * score;
            score1 = score2;
            score2 = score;
        }
        return result1 > result2 ? 1 : result1 < result2 ? 2 : 0;
    }

}
