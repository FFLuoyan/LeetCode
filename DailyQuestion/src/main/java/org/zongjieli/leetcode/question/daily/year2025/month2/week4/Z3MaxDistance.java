package org.zongjieli.leetcode.question.daily.year2025.month2.week4;

import java.util.List;

/**
 *
 * 给定 m 个数组,每个数组都已经按照升序排好序了
 * 现在需要从两个不同的数组中选择两个整数(每个数组选一个)并且计算它们的距离
 * 两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b|
 * 返回最大距离
 *
 * m == arrays.length
 * 2 <= m <= 10^5
 * 1 <= arrays[i].length <= 500
 * -10^4 <= arrays[i][j] <= 10^4
 * arrays[i] 以升序排序
 * 所有数组中最多有 10^5 个整数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/19
 */
public class Z3MaxDistance {

    public int maxDistance(List<List<Integer>> arrays) {
        // a 最小值, ai 最小值下标, b 次小值, bi 次小值下标,
        // c 最大值, ci 最大值下标, d 次大值, di 次大值下标
        int a = Integer.MAX_VALUE, ai = -1,
                b = Integer.MAX_VALUE,
                c = Integer.MIN_VALUE, ci = -1,
                d = Integer.MIN_VALUE,
                e, f;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> sortedList = arrays.get(i);
            e = sortedList.get(0);
            f = sortedList.get(sortedList.size() - 1);
            if (e < a) {
                b = a;
                a = e;
                ai = i;
            } else if (e <= b) {
                b = e;
            }
            if (f > c) {
                d = c;
                c = f;
                ci = i;
            } else if (f >= d) {
                d = f;
            }
        }
        return ai != ci ? c - a : Math.max(c - b, d - a);
    }

}
