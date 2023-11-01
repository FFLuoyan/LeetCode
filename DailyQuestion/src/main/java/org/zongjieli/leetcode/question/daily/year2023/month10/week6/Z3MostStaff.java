package org.zongjieli.leetcode.question.daily.year2023.month10.week6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一个公司准备组织一场会议,邀请名单上有 n 位员工
 * 公司准备了一张圆形的桌子,可以坐下任意数目的员工
 * 员工编号为 0 到 n - 1,每位员工都有一位喜欢的员工
 * 每位员工当且仅当他被安排在喜欢员工的旁边,他才会参加会议
 * 每位员工喜欢的员工不会是他自己
 * 给定一个下标从 0 开始的整数数组 favorite
 * 其中 favorite[i] 表示第 i 位员工喜欢的员工
 * 请返回参加会议的最多员工数目
 *
 * n == favorite.length
 * 2 <= n <= 10^5
 * 0 <= favorite[i] <= n - 1
 * favorite[i] != i
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/1
 */
public class Z3MostStaff {

    public int maximumInvitations(int[] favorite) {
        int[] current = new int[favorite.length], maxRing = new int[1];
        List<Integer> pair = new ArrayList<>();
        Set<Integer>[] sons = new Set[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            findRing(i, maxRing, 1, current, pair, favorite);
            if (sons[favorite[i]] == null) {
                sons[favorite[i]] = new HashSet<>();
            }
            sons[favorite[i]].add(i);
        }
        int singleSum = 0;
        for (Integer i : pair) {
            sons[i].remove(favorite[i]);
            sons[favorite[i]].remove(i);
            singleSum += findDeep(i, sons) + findDeep(favorite[i], sons);
        }
        return Math.max(maxRing[0], singleSum);
    }

    public int findDeep(int i, Set<Integer>[] sons) {
        if (sons[i] == null) {
            return 1;
        }
        int max = 0;
        for (Integer son : sons[i]) {
            max = Math.max(max, findDeep(son, sons));
        }
        return max + 1;
    }

    public void findRing(int current, int[] maxRing, int count, int[] temp, List<Integer> pair, int[] favorite) {
        int start = current;
        while (temp[current] == 0) {
            temp[current] = count++;
            current = favorite[current];
        }
        if (temp[current] > 0) {
            int ringCount = count - temp[current];
            if (ringCount == 2) {
                pair.add(current);
            }
            maxRing[0] = Math.max(maxRing[0], ringCount);
        }
        while (temp[start] > 0) {
            temp[start] = -1;
            start = favorite[start];
        }
    }

    public static void main(String[] args) {
        Z3MostStaff test = new Z3MostStaff();
        // 3
        System.out.println(test.maximumInvitations(new int[]{2, 2, 1, 2}));
        // 11
        System.out.println(test.maximumInvitations(new int[]{1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10}));
    }
}
