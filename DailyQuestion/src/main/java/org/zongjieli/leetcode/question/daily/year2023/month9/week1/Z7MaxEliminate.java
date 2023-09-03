package org.zongjieli.leetcode.question.daily.year2023.month9.week1;

/**
 * 一款电子游戏,在游戏中需要保护城市免受怪物侵袭
 * 给定一个下标从 0 开始且长度为 n 的整数数组 dist
 * 其中 dist[i] 是第 i 个怪物与城市的初始距离(单位: 米),怪物以恒定的速度走向城市
 * 给定一个长度为 n 的整数数组 speed 表示每个怪物的速度
 * 其中 speed[i] 是第 i 个怪物的速度(单位: 米/分),怪物从第 0 分钟时开始移动
 * 有一把武器,可以选择在每一分钟的开始时使用,包括第 0 分钟
 * 但是无法在一分钟的中间使用武器,这种武器威力惊人,一次可以消灭任一还活着的怪物
 * 一旦任一怪物到达城市,就输掉了这场游戏
 * 如果某个怪物恰在某一分钟开始时到达城市,这会被视为输掉游戏,在可以使用武器之前,游戏就会结束
 * 返回在输掉游戏前可以消灭的怪物的最大数量
 * 如果可以在所有怪物到达城市前将它们全部消灭,返回  n
 *
 * n == dist.length == speed.length
 * 1 <= n <= 10^5
 * 1 <= dist[i], speed[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/4
 */
public class Z7MaxEliminate {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[100001];
        for (int i = 0; i < dist.length; i++) {
            time[(dist[i] - 1) / speed[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < time.length && sum < dist.length; i++) {
            if ((sum += time[i]) > i + 1) {
                return i + 1;
            }
        }
        return sum;
    }

}
