package org.zongjieli.leetcode.competion.doubleweekly.order98;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 如果存在一些整数满足 0 <= index1 < index2 < ... < indexK < nums.length
 * 得到 nums[index1] | nums[index2] | ... | nums[indexK] = x
 * 那么说 x 是 可表达的
 * 换言之,如果一个整数能由 nums 的某个子序列的或运算得到,那么它就是可表达的
 * 请返回 nums 不可表达的最小非零整数
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/18
 */
public class O98N3ImpossibleNumber {

    public int minImpossibleOR(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            values.add(num);
        }
        int current = 1;
        while (values.contains(current)) {
            current <<= 1;
        }
        return current;
    }

}
