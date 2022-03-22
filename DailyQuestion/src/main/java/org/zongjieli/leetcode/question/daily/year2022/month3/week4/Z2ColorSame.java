package org.zongjieli.leetcode.question.daily.year2022.month3.week4;
/**
 * 总共有 n 个颜色片段排成一列,每个颜色片段要么是 'A' 要么是 'B'
 * 给定一个长度为 n 的字符串 colors,其中 colors[i] 表示第 i 个颜色片段的颜色
 *
 * Alice 和 Bob 在玩一个游戏,他们轮流从这个字符串中删除颜色,Alice 先手
 * 如果一个颜色片段为 'A' 且相邻两个颜色都是颜色 'A',那么 Alice 可以删除该颜色片段
 * Alice 不可以删除任何颜色 'B' 片段
 * 如果一个颜色片段为 'B' 且相邻两个颜色都是颜色 'B',那么 Bob 可以删除该颜色片段
 * Bob 不可以删除任何颜色 'A' 片段
 * Alice 和 Bob 不能从字符串两端删除颜色片段
 * 如果其中一人无法继续操作,则该玩家输掉游戏且另一玩家获胜
 *
 * 假设 Alice 和 Bob 都采用最优策略,如果 Alice 获胜,请返回 true,否则 Bob 获胜,返回 false
 *
 * 1 <= colors.length <= 10^5
 * colors 只包含字母 'A' 和 'B'
 *
 * @author   Li.zongjie
 * @date     2022/3/22
 * @version  1.0
 */
public class Z2ColorSame {

    public boolean winnerOfGame(String colors) {
        byte[] colorBytes = colors.getBytes();
        byte lc = colorBytes[0];
        int currentCount = 1;
        int[] count = new int[67];
        for (int i = 1 ; i < colorBytes.length ; i++) {
            if (colorBytes[i] != lc) {
                if (currentCount >= 3) {
                    count[lc] += (currentCount - 2);
                }
                currentCount = 1;
                lc = colorBytes[i];
            } else {
                currentCount++;
            }
        }
        if (currentCount >= 3) {
            count[lc] += (currentCount - 2);
        }
        return count['A'] > count['B'];
    }

    public static void main(String[] args) {
        Z2ColorSame test = new Z2ColorSame();
        // true
        System.out.println(test.winnerOfGame("AAABAB"));
    }
}
