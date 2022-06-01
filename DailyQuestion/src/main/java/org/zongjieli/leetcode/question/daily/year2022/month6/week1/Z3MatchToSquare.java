package org.zongjieli.leetcode.question.daily.year2022.month6.week1;

import java.util.*;

/**
 * 一个整数数组 matchsticks,其中 matchsticks[i] 是第 i 个火柴棒的长度
 * 要用所有的火柴棍拼成一个正方形,不能折断任何一根火柴棒
 * 但可以把它们连在一起,而且每根火柴棒必须使用一次
 *
 * 如果能使火柴拼成正方形,则返回 true,否则返回 false
 *
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 *
 * @author   Li.zongjie
 * @date     2022/6/1
 * @version  1.0
 */
public class Z3MatchToSquare {

    public boolean makesquare(int[] matchsticks) {
        int all = 0, result = 0;
        for (int matchstick : matchsticks) {
            all += matchstick;
            result = (result << 1) + 1;
        }
        if (all % 4 != 0) {
            return false;
        }
        int single = all / 4;
        List<Integer> sumCount = new ArrayList<>();
        sumCount(0, matchsticks, single, sumCount, 0, 0);
        if (sumCount.size() < 4) {
            return false;
        }
        return getResult(sumCount, 0, 0, result, 0);
    }

    public void sumCount(int i, int[] values, int single, List<Integer> result, int ci, int cv) {
        if (i == values.length) {
            return;
        }
        sumCount(i + 1, values, single, result, ci, cv);
        ci |= (1 << i);
        if ((cv += values[i]) < single) {
            sumCount(i + 1, values, single, result, ci, cv);
        } else if (cv == single) {
            result.add(ci);
        }
    }

    public boolean getResult(List<Integer> values, int i, int cv, int tv, int cc) {
        if (i >= values.size()) {
            return false;
        }
        int current = values.get(i);
        if (cc == 3) {
            if ((current & cv) == 0 && (current | cv) == tv) {
                return true;
            }
            return getResult(values, i + 1, cv, tv, cc);
        }
        return getResult(values, i + 1, cv, tv, cc) || ((current & cv) == 0 && getResult(values, i + 1, current | cv, tv, cc + 1));
    }

    public static void main(String[] args) {
        Z3MatchToSquare test = new Z3MatchToSquare();
        // ture
        System.out.println(test.makesquare(new int[]{1, 1, 2, 2, 2}));
    }
}
