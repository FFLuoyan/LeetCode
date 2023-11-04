package org.zongjieli.leetcode.question.daily.year2023.month10.week6;

/**
 * 给定一个整数数组 nums,返回 nums[i] XOR nums[j] 的最大运算结果
 * 其中 0 ≤ i ≤ j < n
 *
 * 1 <= nums.length <= 2 * 10^5
 * 0 <= nums[i] <= 2^31 - 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/4
 */
public class Z6MaxXor {

    public int findMaximumXOR(int[] nums) {
        Object[] root = new Object[2];
        add(root, nums[0]);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, getResult(root, nums[i]));
            add(root, nums[i]);
        }
        return result;
    }

    public void add(Object[] root, int value) {
        int start = (1 << 30), index;
        while (start > 0) {
            index = (value & start) > 0 ? 1 : 0;
            if (root[index] == null) {
                root[index] = new Object[2];
            }
            root = (Object[]) root[index];
            start >>= 1;
        }
    }

    public int getResult(Object[] root, int value) {
        int start = (1 << 30), index, result = 0;
        while (start > 0) {
            index = (value & start) > 0 ? 0 : 1;
            if (root[index] != null) {
                result += start;
            } else {
                index ^= 1;
            }
            root = (Object[]) root[index];
            start >>= 1;
        }
        return result;
    }

}
