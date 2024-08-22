package org.zongjieli.leetcode.question.daily.year2024.month8.week4;

/**
 * 给定两个整数 n 和 x,需要构造一个长度为 n 的正整数数组 nums
 * 对于所有 0 <= i < n - 1,满足 nums[i + 1] 大于 nums[i]
 * 并且数组 nums 中所有元素的按位 AND 运算结果为 x
 * 返回 nums[n - 1] 可能的最小值
 *
 * 1 <= n, x <= 10^8
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/8/23
 */
public class Z4FindMin {

    public long minEnd(int n, int x) {
        int[] values = new int[64];
        for (int i = values.length - 1; i >= 0 && x > 0; i--) {
            values[i] = (x & 1);
            x >>= 1;
        }
        n--;
        int index = 63;
        while (n > 0) {
            int value = (n & 1);
            n >>= 1;
            while (index >= 0 && values[index] == 1) {
                index--;
            }
            values[index--] = value;
        }
        long result = 0;
        for (int value : values) {
            result <<= 1;
            result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4FindMin test = new Z4FindMin();
        // 6
        System.out.println(test.minEnd(3, 4));
    }

}
