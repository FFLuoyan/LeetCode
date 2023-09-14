package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 在一个 8x8 的棋盘上,放置着若干黑皇后和一个白国王
 * 给定一个由整数坐标组成的数组 queens,表示黑皇后的位置
 * 以及一对坐标 king,表示白国王的位置,返回所有可以攻击国王的皇后的坐标(任意顺序)
 *
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/14
 */
public class Z4KingQueen {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] position = new boolean[8][8];
        for (int[] queen : queens) {
            position[queen[0]][queen[1]] = true;
        }
        LinkedList<int[]> checks = new LinkedList<>();
        checks.add(new int[]{king[0], -1, king[1], -1});
        checks.add(new int[]{king[0], -1, king[1], 0});
        checks.add(new int[]{king[0], -1, king[1], 1});
        checks.add(new int[]{king[0], 0, king[1], -1});
        checks.add(new int[]{king[0], 0, king[1], 1});
        checks.add(new int[]{king[0], 1, king[1], -1});
        checks.add(new int[]{king[0], 1, king[1], 0});
        checks.add(new int[]{king[0], 1, king[1], 1});
        List<List<Integer>> result = new ArrayList<>();
        while (!checks.isEmpty()) {
            int[] check = checks.poll();
            check[0] += check[1];
            check[2] += check[3];
            if (check[0] >= 0 && check[0] < 8 && check[2] >= 0 && check[2] < 8) {
                if (position[check[0]][check[2]]) {
                    result.add(Arrays.asList(check[0], check[2]));
                } else {
                    checks.add(check);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4KingQueen test = new Z4KingQueen();
        // [[0, 1], [1, 0], [3, 3]]
        System.out.println(test.queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
    }
}
