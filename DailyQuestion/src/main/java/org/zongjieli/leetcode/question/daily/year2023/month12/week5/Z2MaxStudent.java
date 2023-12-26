package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

/**
 * 给定一个 m * n 的矩阵 seats 表示教室中的座位分布
 * 如果座位是坏的(不可用),就用 '#' 表示,否则用 '.' 表示
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷
 * 但是看不到直接坐在他前面或者后面的学生的答卷
 * 请计算并返回该考场可以容纳的同时参加考试且无法作弊的最大学生人数
 * 学生必须坐在状况良好的座位上
 *
 * seats 只包含字符 '.' 和'#'
 * m == seats.length
 * n == seats[i].length
 * 1 <= m <= 8
 * 1 <= n <= 8
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/26
 */
public class Z2MaxStudent {

    private int m, n;

    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        int[] obstacle = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacle[i] = (obstacle[i] << 1) + (seats[i][j] == '#' ? 1 : 0);
            }
        }
        int[] before = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int[] current = new int[1 << n];
            for (int j = 0; j < current.length; j++) {
                if ((j & (j << 1)) > 0 || (j & obstacle[i])> 0) {
                    // 本行自冲突或存在障碍
                    current[j] = -1;
                } else {
                    int beforeMax = 0;
                    for (int k = 0; k < before.length; k++) {
                        if (before[k] >= 0 && (j & (k >> 1)) == 0 && (j & (k << 1)) == 0) {
                            beforeMax = Math.max(beforeMax, before[k]);
                        }
                    }
                    current[j] = beforeMax + Integer.bitCount(j);
                }
            }
            before = current;
        }
        int result = 0;
        for (int i : before) {
            result = Math.max(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
        Z2MaxStudent test = new Z2MaxStudent();
        // 4
        System.out.println(test.maxStudents(new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}}));
        // 31
        System.out.println(test.maxStudents(new char[][]{{'.', '.', '.', '.', '#', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '#', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '#', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '#', '.', '.', '#', '.'}}));
    }
}
