package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

/**
 * 给定一个长度为 n 的 3 跑道道路,它总共包含 n + 1 个 点,编号为 0 到 n
 * 一只青蛙从 0 号点第二条跑道出发,它想要跳到点 n 处,然而道路上可能有一些障碍
 * 给定一个长度为 n + 1 的数组 obstacles，其中 obstacles[i](取值范围从 0 到 3)
 * 表示在点 i 处的 obstacles[i] 跑道上有一个障碍,如果 obstacles[i] == 0,那么点 i 处没有障碍
 * 任何一个点的三条跑道中最多有一个障碍
 * 比方说,如果 obstacles[2] == 1,那么说明在点 2 处跑道 1 有障碍
 * 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍
 * 为了躲避障碍,这只青蛙也可以在同一个点处侧跳到另外一条跑道(这两条跑道可以不相邻)
 * 但前提是跳过去的跑道该点处没有障碍
 * 比方说,这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1
 * 这只青蛙从点 0 处跑道 2 出发,并想到达点 n 处的任一跑道,请返回最少侧跳次数
 * 注意: 点 0 处和点 n 处的任一跑道都不会有障碍
 *
 * obstacles.length == n + 1
 * 1 <= n <= 5 * 10^5
 * 0 <= obstacles[i] <= 3
 * obstacles[0] == obstacles[n] == 0
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/21
 */
public class Z6MinJump {

    public int minSideJumps(int[] obstacles) {
        int current = 4, before = 0, result = 0;
        for (int obstacle : obstacles) {
            obstacle = 1 << obstacle;
            if ((current & obstacle) > 0 && (current ^= obstacle) <= 1) {
                current = (obstacle ^ before) ^ 14;
                result++;
            }
            before = obstacle;
        }
        return result;
    }

    public static void main(String[] args) {
        Z6MinJump test = new Z6MinJump();
        // 2
        System.out.println(test.minSideJumps(new int[]{0, 1, 2, 3, 0}));
        // 1
        System.out.println(test.minSideJumps(new int[]{0, 0, 2, 0, 0, 0, 2, 1, 2, 0, 0}));
        // 21
        System.out.println(test.minSideJumps(new int[]{0, 0, 0, 0, 2, 1, 2, 0, 2, 2, 3, 3, 3, 0, 0, 1, 1, 3, 0, 0, 0, 1, 2, 2, 1, 2, 1, 3, 2, 2, 3, 1, 3, 0, 1, 1, 1, 3, 0, 0, 0, 2, 0, 2, 0, 3, 1, 2, 3, 3, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 2, 1, 2, 3, 1, 0, 3, 3, 2, 0, 1, 1, 0, 1, 0, 2, 2, 2, 1, 3, 0, 3, 0, 2, 1, 1, 3, 1, 0, 1, 2, 2, 0, 0}));
    }

}
