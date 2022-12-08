package org.zongjieli.leetcode.question.daily.year2022.month12.week2;

/**
 * 给定一个坐标 coordinates,它是一个字符串,表示国际象棋棋盘中一个格子的坐标
 * 下表是国际象棋棋盘示意图
 *
 *  8 白 黑 白 黑 白 黑 白 黑
 *  7 黑 白 黑 白 黑 白 黑 白
 *  6 白 黑 白 黑 白 黑 白 黑
 *  5 黑 白 黑 白 黑 白 黑 白
 *  4 白 黑 白 黑 白 黑 白 黑
 *  3 黑 白 黑 白 黑 白 黑 白
 *  2 白 黑 白 黑 白 黑 白 黑
 *  1 黑 白 黑 白 黑 白 黑 白
 *    a  b  c  d  e  f  g  h
 *
 * 如果所给格子的颜色是白色,请返回 true,如果是黑色,返回 false
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子,坐标第一个字符是字母,第二个字符是数字
 *
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/8
 */
public class Z4GridWhite {

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '1') & 1) == 1;
    }

}
