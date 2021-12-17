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
        for (int i = 0 ; i < 3 ; i++){
            String currentString = board[i];
            for (int j = 0 ; j < 3 ; j++){
                char currentChar = currentString.charAt(j);
                int c = currentChar == 'X' ? 1 : currentChar == 'O' ? 2 : 0;
                values[3 * i + j] = c;
                count[c]++;
            }
        }

        /*
            可以从多个角度分析状态是否合法
                从玩家获胜角度
                    如果玩家一赢,则玩家二不可能赢,且玩家一比玩家二落子数量多 1
                    如果玩家二赢,则玩家一不可能赢,且玩家二罗子数量与玩家一一致
                    如果还未胜利,则此时玩家一的落子数与玩家二一致或者多一
                从落子数量角度
                    如果玩家一落子数比玩家二多一,则玩家二不可能赢
                    如果玩家一落子数与玩家二一致,则玩家一不可能赢
                    其他情况不可能出现
         */
        return count[1] == count[2] + 1 ? !win(values, 2) : count[1] == count[2] && !win(values, 1);
    }

    private boolean win(int[] values, int player){
        int compare;
        return
                // 第一行或第一列一致
                ((compare = values[0]) == player && ((compare == values[1] && compare == values[2]) || (compare == values[3] && compare == values[6])))
                // 第二行或第二列一致或对角线一致
                || ((compare = values[4]) == player && ((compare == values[1] && compare == values[7]) || (compare == values[3] && compare == values[5]) || (compare == values[0] && compare == values[8]) || (compare == values[2] && compare == values[6])))
                // 第三行或第三列一致
                || ((compare = values[8]) == player && ((compare == values[2] && compare == values[5]) || (compare == values[6] && compare == values[7])));
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
