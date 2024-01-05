package org.zongjieli.leetcode.question.daily.year2024.month1.week1;

import java.util.Arrays;

/**
 * 有 n 个人排成一个队列,从左到右编号为 0 到 n - 1
 * 给定一个整数数组 heights,每个整数互不相同,heights[i] 表示第 i 个人的高度
 * 一个人能看到他右边另一个人的条件是这两人之间的所有人都比他们两人矮
 * 更正式的,第 i 个人能看到第 j 个人的条件是
 *  i < j,且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1])
 * 请返回一个长度为 n 的数组 answer
 * 其中 answer[i] 是第 i 个人在他右侧队列中能看到的人数
 *
 * n == heights.length
 * 1 <= n <= 10^5
 * 1 <= heights[i] <= 10^5
 * heights 中所有数互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/5
 */
public class Z5SeeCount {

    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length, start = length - 1, index = start;
        int[] sorted = new int[length], result = new int[length];
        sorted[start] = heights[start];
        while (--index >= 0) {
            int left = start, right = length - 1, value = heights[index];
            if (sorted[right] < value) {
                result[index] = length - start;
                sorted[start = right] = value;
                continue;
            }
            while (left < right) {
                int middle = (left + right) / 2;
                if (sorted[middle] < value) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            result[index] = left - start + 1;
            sorted[start = left - 1] = value;
        }
        return result;
    }


    public static void main(String[] args) {
        Z5SeeCount test = new Z5SeeCount();
        // [3, 1, 2, 1, 1, 0]
        System.out.println(Arrays.toString(test.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
        // [1, 3, 1, 1, 0]
        System.out.println(Arrays.toString(test.canSeePersonsCount(new int[]{2, 10, 3, 4, 8})));
    }

}
