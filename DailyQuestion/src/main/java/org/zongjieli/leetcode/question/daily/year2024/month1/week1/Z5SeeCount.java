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
        int length = heights.length, index = length - 1, start = index;
        int[] sorted = new int[length], result = new int[length];
        sorted[start] = heights[start];
        while (--index >= 0) {
            int minBigger = findMinBigger(start, length - 1, sorted, heights[index]);
            if (minBigger == length) {
                result[index] = length - start;
            } else {
                result[index] = minBigger - start + 1;
            }
            sorted[start = minBigger - 1] = heights[index];
        }
        return result;
    }

    public int findMinBigger(int start, int end, int[] sorted, int value) {
        if (sorted[end] < value) {
            return end + 1;
        }
        while (start < end) {
            int middle = (start + end) / 2;
            if (sorted[middle] < value) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Z5SeeCount test = new Z5SeeCount();
        // [3, 1, 2, 1, 1, 0]
        System.out.println(Arrays.toString(test.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
    }

}
