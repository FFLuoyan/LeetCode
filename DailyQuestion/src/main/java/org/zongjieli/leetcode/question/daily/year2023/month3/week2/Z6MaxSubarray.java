package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

import java.util.Arrays;

/**
 * 给定一个放有字母和数字的数组
 * 找到最长的子数组,且包含的字母和数字的个数相同,返回该子数组
 * 若存在多个最长子数组,返回左端点下标值最小的子数组
 * 若不存在这样的数组,返回一个空数组
 *
 * array.length <= 100000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/11
 */
public class Z6MaxSubarray {

    public String[] findLongestSubarray(String[] array) {
        int length = array.length, currentCount = length, resultLength = -2, resultStartIndex = 0;
        int[] countFirstIndex = new int[2 * length + 1];
        countFirstIndex[currentCount] = 1;
        for (int i = 0; i < array.length; i++) {
            int index = countFirstIndex[currentCount += ((array[i].charAt(0) >> 6) * 2 - 1)];
            if (index == 0) {
                countFirstIndex[currentCount] = i + 2;
            } else {
                int currentLength = i - index;
                if (currentLength > resultLength) {
                    resultLength = currentLength;
                    resultStartIndex = index - 1;
                }
            }
        }
        String[] result = new String[resultLength += 2];
        System.arraycopy(array, resultStartIndex, result, 0, resultLength);
        return result;
    }

    public static void main(String[] args) {
        Z6MaxSubarray test = new Z6MaxSubarray();
        // A, 1, B, C, D, 2, 3, 4, E, 5, F, G, 6, 7
        System.out.println(Arrays.toString(test.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
        // A, 1
        System.out.println(Arrays.toString(test.findLongestSubarray(new String[]{"A", "1"})));
    }

}
