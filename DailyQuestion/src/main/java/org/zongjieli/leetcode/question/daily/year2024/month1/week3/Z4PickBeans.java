package org.zongjieli.leetcode.question.daily.year2024.month1.week3;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个正整数数组 beans,其中每个整数表示一个袋子里装的魔法豆的数目
 * 请从每个袋子中拿出一些豆子(也可以不拿出)
 * 使得剩下的非空袋子中(即至少还有一颗魔法豆的袋子)魔法豆的数目相等
 * 一旦把魔法豆从袋子中取出,不能再将它放到任何袋子中
 * 请返回需要拿出魔法豆的最少数目
 *
 * 1 <= beans.length <= 10^5
 * 1 <= beans[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/24
 */
public class Z4PickBeans {

    public long minimumRemoval(int[] beans) {
        // 取得最少,剩的最多
        long sum = 0, result = Long.MAX_VALUE, remainCount = beans.length;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int bean : beans) {
            sum += bean;
            count.merge(bean, 1, Integer::sum);
        }
        while (!count.isEmpty()) {
            Map.Entry<Integer, Integer> entry = count.pollFirstEntry();
            result = Math.min(result, sum - entry.getKey() * remainCount);
            remainCount -= entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Z4PickBeans test = new Z4PickBeans();
        // 4
        System.out.println(test.minimumRemoval(new int[]{4, 1, 6, 5}));
    }
}
