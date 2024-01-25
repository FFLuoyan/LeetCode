package org.zongjieli.leetcode.question.daily.year2024.month1.week4;

import java.util.List;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个整数 k
 * 请用整数形式返回 nums 中的特定元素之和
 * 这些特定元素满足:
 *  其对应下标的二进制表示中恰存在 k 个置位
 * 整数的二进制表示中的 1 就是这个整数的置位
 * 例如,21 的二进制表示为 10101,其中有 3 个置位
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^5
 * 0 <= k <= 10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/25
 */
public class Z4KSum {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

}
