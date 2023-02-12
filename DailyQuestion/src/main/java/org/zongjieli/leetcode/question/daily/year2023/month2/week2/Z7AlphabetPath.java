package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

/**
 * 我们从一块字母板上的位置 (0, 0) 出发,该坐标对应的字符为 board[0][0]
 * 字母板为 board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"],如下所示
 * [[a, b, c, d, e]
 * ,[f, g, h, i, j]
 * ,[k, l, m, n, o]
 * ,[p, q, r, s, t]
 * ,[u, v, w, x, y]
 * ,[z]]
 * 可以按下面的指令规则行动:
 *  如果方格存在,'U' 意味着将位置上移一行;
 *  如果方格存在,'D' 意味着将位置下移一行;
 *  如果方格存在,'L' 意味着将位置左移一列;
 *  如果方格存在,'R' 意味着将位置右移一列;
 *  '!' 会把在当前位置 (r, c) 的字符 board[r][c] 添加到答案中
 * (注意,字母板上只存在有字母的位置)
 * 返回指令序列,用最小的行动次数让答案和目标 target 相同
 * 可以返回任何达成目标的路径
 *
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/12
 */
public class Z7AlphabetPath {

    int[][] position = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {5, 0}};

    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        int[] start = position[0];
        for (char c : target.toCharArray()) {
            int[] next = position[c - 'a'];
            move(result, start, next);
            start = next;
        }
        return result.toString();
    }

    public void move(StringBuilder result, int[] start, int[] end) {
        int up = start[0] - end[0], left = start[1] - end[1];
        while (up > 0) {
            result.append('U');
            up--;
        }
        while (left > 0) {
            result.append('L');
            left--;
        }
        while (left < 0) {
            result.append('R');
            left++;
        }
        while (up < 0) {
            result.append('D');
            up++;
        }
        result.append('!');
    }

}
