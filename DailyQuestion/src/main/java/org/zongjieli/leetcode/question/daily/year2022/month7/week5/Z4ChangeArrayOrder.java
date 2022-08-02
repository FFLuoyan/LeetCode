package org.zongjieli.leetcode.question.daily.year2022.month7.week5;

import java.util.*;

/**
 * 给定一个整数数组 arr,请将数组中的每个元素替换为它们排序后的序号
 * 序号代表了一个元素有多大,序号编号的规则如下:
 *  序号从 1 开始编号
 *  一个元素越大,那么序号越大
 *  如果两个元素相等,那么它们的序号相同
 *  每个数字的序号都应该尽可能地小
 *
 * 0 <= arr.length <= 10^5
 * -10^9 <= arr[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/7/29
 * @version  1.0
 */
public class Z4ChangeArrayOrder {

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[][] values = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            values[i][0] = arr[i];
            values[i][1] = i;
        }
        Arrays.sort(values, Comparator.comparingInt(a -> a[0]));
        int last = values[0][0], order = 1;
        arr[values[0][1]] = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i][0] > last) {
                last = values[i][0];
                order++;
            }
            arr[values[i][1]] = order;
        }
        return arr;
    }
}
