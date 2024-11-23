package org.zongjieli.leetcode.question.daily.year2024.month11.week4;

/**
 * 给定一个整数 n,表示在一个游戏中的玩家数目
 * 同时给定一个二维整数数组 pick,其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个颜色为 yi 的球
 * 如果玩家 i 获得的球中任意一种颜色球的数目严格大于 i 个,那么说玩家 i 是胜利玩家,换句话说:
 *  如果玩家 0 获得了任何的球,那么玩家 0 是胜利玩家
 *  如果玩家 1 获得了至少 2 个相同颜色的球,那么玩家 1 是胜利玩家
 *  如果玩家 i 获得了至少 i + 1 个相同颜色的球,那么玩家 i 是胜利玩家
 * 请返回游戏中胜利玩家的数目
 * 注意,可能有多个玩家是胜利玩家
 *
 * 2 <= n <= 10
 * 1 <= pick.length <= 100
 * pick[i].length == 2
 * 0 <= xi <= n - 1
 * 0 <= yi <= 10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/11/23
 */
public class Z6CountWinner {

    public int winningPlayerCount(int n, int[][] pick) {
        int[][] playerBallCount = new int[n][11];
        for (int[] playerBall : pick) {
            playerBallCount[playerBall[0]][playerBall[1]]++;
        }
        int winnerCount = 0;
        for (int i = 0; i < playerBallCount.length; i++) {
            for (int count : playerBallCount[i]) {
                if (count > i) {
                    winnerCount++;
                    break;
                }
            }
        }
        return winnerCount;
    }

}
