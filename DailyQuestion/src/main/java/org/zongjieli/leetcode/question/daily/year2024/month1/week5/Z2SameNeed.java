package org.zongjieli.leetcode.question.daily.year2024.month1.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个下标从 0 开始长度为 n 的数组 nums
 * 每一秒,可以对数组执行以下操作:
 *  对于范围在 [0, n - 1] 内的每一个下标 i, 将 nums[i] 替换成
 *      nums[i],nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一
 * 注意,所有元素会被同时替换
 * 请返回将数组 nums 中所有元素变成相等元素所需要的最少秒数
 *
 * 1 <= n == nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/30
 */
public class Z2SameNeed {

    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> numberIndexes = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            numberIndexes.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        int result = Integer.MAX_VALUE;
        for (List<Integer> indexes : numberIndexes.values()) {
            int max = indexes.get(0) + nums.size() - indexes.get(indexes.size() - 1);
            for (int i = 1; i < indexes.size(); i++) {
                max = Math.max(max, indexes.get(i) - indexes.get(i - 1));
            }
            result = Math.min(result, max / 2);
        }
        return result;
    }

}
