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
        int[] values = new int[9];
        int[] count = new int[3];
        boolean[] win = new boolean[3];
        for (int i = 0 ; i < 3 ; i++){
            String currentString = board[i];
            for (int j = 0 ; j < 3 ; j++){
                char currentChar = currentString.charAt(j);
                int c = currentChar == 'X' ? 1 : currentChar == 'O' ? 2 : 0;
                values[3 * i + j] = c;
                count[c]++;
            }
        }

        int c = values[4];
        if ((c == values[0] && c == values[8]) || (c == values[1] && c == values[7]) || (c == values[2] && c == values[6]) || (c == values[3] && c == values[5])){
            win[c] = true;
        }
        c = values[0];
        if ((c == values[1] && c == values[2]) || (c == values[3] && c == values[6])){
            win[c] = true;
        }
        c = values[8];
        if ((c == values[6] && c == values[7]) || (c == values[2] && c == values[5])){
            win[c] = true;
        }
        return win[1] ? !win[2] && count[1] == count[2] + 1 : win[2] ? count[1] == count[2] : count[1] - count[2] == 0 || count[1] - count[2] == 1;
    }

    public static void main(String[] args) {
        Z4TicTacToe test = new Z4TicTacToe();
        // false
        System.out.println(test.validTicTacToe(new String[]{"XXX","XOO","OO "}));
        // true
        System.out.println(test.validTicTacToe(new String[]{"X  ","   ","  O"}));
        // false
        System.out.println(test.validTicTacToe(new String[]{"XXO","XOX","OXO"}));
    }
}
