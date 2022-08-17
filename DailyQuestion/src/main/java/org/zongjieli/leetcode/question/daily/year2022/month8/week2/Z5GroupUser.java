package org.zongjieli.leetcode.question.daily.year2022.month8.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 有 n 个人被分成数量未知的组,每个人都被标记为一个从 0 到 n - 1 的唯一 ID
 * 给定一个整数数组 groupSizes,其中 groupSizes[i] 是第 i 个人所在的组的大小
 * 例如,如果 groupSizes[1] = 3,则第 1 个人必须位于大小为 3 的组中
 * 返回一个组列表,使每个人 i 都在一个大小为 groupSizes[i] 的组中
 * 每个人应该恰好只出现在一个组中,并且每个人必须在一个组中
 * 如果有多个答案,返回其中任何一个,可以保证给定输入至少有一个有效的解
 *
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 *
 * @author   Li.zongjie
 * @date     2022/8/16
 * @version  1.0
 */
public class Z5GroupUser {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] exists = new boolean[501];
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!exists[size]) {
                exists[size] = true;
                List<Integer> cl = new ArrayList<>(size);
                int cs = 0;
                for (int j = i ; j < groupSizes.length ; j++) {
                    if (groupSizes[j] == size) {
                        cl.add(j);
                        cs++;
                    }
                    if (cs == size) {
                        result.add(cl);
                        cl = new ArrayList<>(size);
                        cs = 0;
                    }
                }
            }
        }
        return result;
    }
}
