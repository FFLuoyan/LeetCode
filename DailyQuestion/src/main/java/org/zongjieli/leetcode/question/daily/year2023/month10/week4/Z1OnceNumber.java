package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组 nums,其中恰好有两个元素只出现一次,其余所有元素均出现两次
 * 找出只出现一次的那两个元素,可以按任意顺序返回答案
 * 必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题
 *
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/16
 */
public class Z1OnceNumber {

    public int[] singleNumber(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) {
                values.remove(num);
            } else {
                values.add(num);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (Integer value : values) {
            result[index++] = value;
        }
        return result;
    }

}
