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
        int all = 0;
        LinkedList<Integer> ms = new LinkedList<>();
        for (int matchstick : matchsticks) {
            all += matchstick;
            ms.add(matchstick);
        }
        if ((all & 3) > 0) {
            return false;
        }
        int single = all / 4;
        LinkedList<Map<Integer, Integer>> needs = new LinkedList<>();
        Map<Integer, Integer> firstNeed = new HashMap<>();
        firstNeed.put(single, 4);
        needs.addLast(firstNeed);
        ms.sort(Integer::compareTo);
        while (!ms.isEmpty()) {
            int max = ms.pollLast();
            int needSize = needs.size();
            while (--needSize >= 0) {
                Map<Integer, Integer> need = needs.pollFirst();
                for (Map.Entry<Integer, Integer> ne : need.entrySet()) {
                    int k = ne.getKey(), v = ne.getValue();
                    if (k == max) {
                        Map<Integer, Integer> nn = new HashMap<>(need);
                        if (v == 1) {
                            nn.remove(k);
                            if (nn.size() == 0) {
                                return true;
                            }
                        } else {
                            nn.put(k, v - 1);
                        }
                        needs.addLast(nn);
                    } else if (k > max) {
                        Map<Integer, Integer> nn = new HashMap<>(need);
                        if (v == 1) {
                            nn.remove(k);
                            nn.merge(k - max, 1, Integer::sum);
                        } else {
                            nn.put(k, v - 1);
                            nn.merge(k - max, 1, Integer::sum);
                        }
                        needs.add(nn);
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Z3MatchToSquare test = new Z3MatchToSquare();
        // true
        System.out.println(test.makesquare(new int[]{1, 1, 2, 2, 2}));
        // true
        System.out.println(test.makesquare(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2}));
    }
}
