package org.zongjieli.leetcode.question.daily.year2021.month12.week2;
/**
 * 给定一个字符串数组 board 表示井字游戏的棋盘
 * 当且仅当在井字游戏过程中,棋盘有可能达到 board 所显示的状态时才返回 true
 *
 * 井字游戏的棋盘是一个 3 x 3 数组
 * 由字符 ' ','X','O' 组成,字符 ' ' 代表一个空位
 *
 * 以下是井字游戏的规则:
 *
 *  玩家轮流将字符放入空位(' ')中
 *  玩家 1 总是放字符 'X',而玩家 2 总是放字符 'O'
 *  'X' 和 'O' 只允许放置在空位中,不允许对已放有字符的位置进行填充
 *  当有 3 个相同(且非空)的字符填充任何行、列或对角线时,游戏结束
 *  当所有位置非空时,也算为游戏结束
 *  如果游戏结束,玩家不允许再放置字符
 *
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 *
 * @author   Li.zongjie
 * @date     2021/12/9
 * @version  1.0
 */
public class Z4TicTacToe {
    public boolean validTicTacToe(String[] board) {
        int[][] save = new int[3][3];
        int xCount = 0;
        int oCount = 0;
        int xRow = 0;
        int oRow = 0;

        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                save[i][j] = board[i].charAt(j);
                if (save[i][j] == 'X'){
                    xCount++;
                } else if (save[i][j] == 'O'){
                    oCount++;
                }
            }
            if (save[i][0] == save[i][1] && save[i][0] == save[i][2]){
                if (save[i][0] == 'X'){
                    xRow++;
                } else if (save[i][0] == 'O'){
                    oRow++;
                }
            }
        }

        if (xCount - oCount > 1 || oCount > xCount){
            return false;
        }

        for (int i = 0 ; i < 3 ; i++){
            if (save[0][i] == save[1][i] && save[1][i] == save[2][i]){
                if (save[0][i] == 'X'){
                    xRow++;
                } else if (save[0][i] == 'O'){
                    oRow++;
                }
            }
        }

        if (save[0][0] == save[1][1] && save[1][1] == save[2][2]){
            if (save[0][0] == 'X'){
                xRow++;
            } else if (save[0][0] == 'O'){
                oRow++;
            }
        }

        if (save[0][2] == save[1][1] && save[1][1] == save[2][0]){
            if (save[1][1] == 'X'){
                xRow++;
            } else if (save[1][1] == 'O'){
                oRow++;
            }
        }

        if (xRow > 0){
            return xCount - oCount == 1 && oRow == 0;
        }

        if (oRow > 0){
            return xCount == oCount;
        }
        return true;
    }

    public static void main(String[] args) {
        Z4TicTacToe test = new Z4TicTacToe();
        // false
//        System.out.println(test.validTicTacToe(new String[]{"XXX","XOO","OO "}));
        // true
//        System.out.println(test.validTicTacToe(new String[]{"X  ","   ","  O"}));
        // false
        System.out.println(test.validTicTacToe(new String[]{"XXO","XOX","OXO"}));
    }
}
