package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums,返回其中按位与三元组的数目
 * 按位与三元组是由下标 (i, j, k) 组成的三元组,并满足下述全部条件:
 *  0 <= i < nums.length
 *  0 <= j < nums.length
 *  0 <= k < nums.length
 *  nums[i] & nums[j] & nums[k] == 0,其中 & 表示按位与运算符
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < 2^16
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/4
 */
public class Z6BitAndThree {

    public int countTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = 0 ; j < i ; j++) {
                count.merge(current & nums[j], 2, Integer::sum);
            }
            count.merge(current, 1, Integer::sum);
        }
        int result = 0;
        for (int current : nums) {
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if ((entry.getKey() & current) == 0) {
                    result += entry.getValue();
                }
            }
        }
        return result;
    }

}
