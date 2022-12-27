package org.zongjieli.leetcode.question.daily.year2022.month12.week4;

/**
 * 一个单人游戏,面前放置着大小分别为 a、b 和 c 的 三堆石子
 * 每回合都要从两个不同的非空堆中取出一个石子
 * 并在得分上加 1 分,当存在两个或更多的空堆时,游戏停止
 * 给定三个整数 a 、b 和 c,返回可以得到的最大分数
 *
 * 1 <= a, b, c <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/27
 */
public class Z3MaxScore {

    public int maximumScore(int a, int b, int c) {
        return a < b ? maximumScore(b, a, c) : b < c ? maximumScore(a, c, b) : Math.min(b + c, (a + b + c) >> 1);
    }
}
