package org.zongjieli.leetcode.algorithm.primary.array;
/**
 * 请你判断一个 9x9 的数独是否有效
 * 只需要根据以下规则,验证已经填入的数字是否有效即可
 *
 *  数字 1-9 在每一行只能出现一次。
 *  数字 1-9 在每一列只能出现一次。
 *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 *  数独部分空格内已填入了数字,空白格用 '.' 表示
 *
 * 注意：
 *  一个有效的数独(部分已被填充)不一定是可解的
 *  只需要根据以上规则,验证已经填入的数字是否有效即可
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P10EffectSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] exist = new boolean[3][9][9];
        for (int row = 0; row < board.length; row++) {
            char[] currentRow = board[row];
            for (int column = 0; column < currentRow.length; column++) {
                char number = currentRow[column];
                if (number == '.'){
                    continue;
                }
                int index = number - '1';
                int grid = 3 * (row / 3) + (column / 3);
                if (exist[0][row][index] || exist[1][column][index] || exist[2][grid][index]){
                    return false;
                }
                exist[0][row][index] = true;
                exist[1][column][index] = true;
                exist[2][grid][index] = true;
            }
        }
        return true;
    }
}
