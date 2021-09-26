package org.zongjieli.leetcode.competion.singleweekly.order260;
/**
 * 给定一个 m x n 的矩阵 board,它代表一个填字游戏当前的状态
 * 填字游戏格子中包含
 *  小写英文字母(已填入的单词)
 *  表示空格的 ' '
 *  表示障碍格子的 '#'
 *
 * 如果满足以下条件,那么我们可以水平(从左到右或者从右到左)或竖直(从上到下或者从下到上)填入一个单词:
 *  该单词不占据任何 '#' 对应的格子
 *  每个字母对应的格子要么是 ' ' (空格)要么与 board 中已有字母匹配
 *  如果单词是水平放置的,那么该单词左边和右边相邻格子不能为 ' ' 或小写英文字母
 *  如果单词是竖直放置的,那么该单词上边和下边相邻格子不能为 ' ' 或小写英文字母
 *  给定一个字符串 word,如果 word 可以被放入 board 中,请返回 true,否则请返回 false
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m * n <= 2 * 10^5
 * board[i][j] 可能为 ' ' ，'#' 或者一个小写英文字母
 * 1 <= word.length <= max(m, n)
 * word 只包含小写英文字母
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class FillWord {
}
