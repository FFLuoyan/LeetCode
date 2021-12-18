package org.zongjieli.leetcode.question.daily.year2021.month12.week3;
/**
 * 给定一个大小为 m x n 的矩阵 board 表示甲板
 * 其中,每个单元格可以是一艘战舰 'X' 或者是一个空位 '.'
 * 返回在甲板 board 上放置的战舰的数量
 *
 * 战舰只能水平或者垂直放置在 board 上
 * 换句话说,战舰只能按 1 x k(1 行,k 列)或 k x 1(k 行,1 列)的形状建造
 * 其中 k 可以是任意大小,两艘战舰之间至少有一个水平或垂直的空位分隔(即没有相邻的战舰)
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 *
 * @author   Li.zongjie
 * @date     2021/12/18
 * @version  1.0
 */
public class Z6BoardShips {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board[0][0] == 'X'){
            count++;
        }
        for (int i = 1 ; i < board[0].length ; i++){
            if (board[0][i] == 'X' && board[0][i - 1] != 'X'){
                count++;
            }
        }
        for (int i = 1 ; i < board.length ; i++){
            if (board[i][0] == 'X' && board[i - 1][0] != 'X'){
                count++;
            }
            for (int j = 1 ; j < board[i].length ; j++){
                if (board[i][j] == 'X' && board[i - 1][j] != 'X' && board[i][j - 1] != 'X'){
                    count++;
                }
            }
        }
        return count;
    }
}
