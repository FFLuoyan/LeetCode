package org.zongjieli.leetcode.question.daily.year2024.month1.week5;

import java.util.*;

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
        Map<Integer, int[]> numberParams = new HashMap<>();
        int length = nums.size(), num;
        // first, last, max(not contain last to first)
        int[] values;
        for (int i = 0; i < length; i++) {
            num = nums.get(i);
            values = numberParams.get(num);
            if (values == null) {
                numberParams.put(num, new int[]{i, i, 0});
            } else {
                values[2] = Math.max(values[2], i - values[1]);
                values[1] = i;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int[] value : numberParams.values()) {
            result = Math.min(result, Math.max(value[2], value[0] + length - value[1]) / 2);
        }
        return result;
    }

    public static void main(String[] args) {
        Z2SameNeed test = new Z2SameNeed();
        // 2
        System.out.println(test.minimumSeconds(Arrays.asList(1, 2, 3, 4, 5)));
    }

}
