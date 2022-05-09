package org.zongjieli.leetcode.question.daily.year2022.month5.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个长度为 n 的整数数组 nums
 * 其中 nums 的所有整数都在范围 [1, n] 内
 * 且每个整数出现一次或两次
 * 请找出所有出现两次的整数,并以数组形式返回
 * 必须设计并实现一个时间复杂度为 O(n)
 * 且仅使用常量额外空间的算法解决此问题
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现一次或两次
 *
 * @author   Li.zongjie
 * @date     2022/5/9
 * @version  1.0
 */
public class Z7DuplicateNumber {

    public List<Integer> findDuplicates(int[] nums) {
        boolean[] exists = new boolean[nums.length + 1];
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (!(exists[num] = !exists[num])) {
                result.add(num);
            }
        }
        return result;
    }
}
