package org.zongjieli.leetcode.question.daily.year2021.month9.week3;
/**
 * 你和你的朋友,两个人一起玩 Nim 游戏
 *
 * 桌子上有一堆石头
 * 你们轮流进行自己的回合,你作为先手
 * 每一回合,轮到的人拿掉 1 - 3 块石头
 * 拿掉最后一块石头的人就是获胜者
 * 假设你们每一步都是最优解
 * 编写一个函数,来判断你是否可以在给定石头数量为 n 的情况下赢得游戏
 * 如果可以赢,返回 true,否则返回 false
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class Z6NimGame {
    public boolean canWinNim(int n) {
        return (n & 3) > 0;
    }
}
