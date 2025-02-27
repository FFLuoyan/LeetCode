package org.zongjieli.leetcode.question.daily.year2025.month2.week4;

/**
 * 给定一个非递减的有序整数数组,已知这个数组中恰好有一个整数,它的出现次数超过数组元素总数的 25%
 * 请找到并返回这个整数
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/17
 */
public class Z1OrderOccur {

    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4, count = 0, currentValue = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value == currentValue) {
                if (++count > threshold) {
                    return value;
                }
            } else {
                currentValue = value;
                count = 1;
            }
        }
        return currentValue;
    }

}
