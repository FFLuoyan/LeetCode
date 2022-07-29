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
        TreeSet<Integer> values = new TreeSet<>();
        for (int i : arr) {
            values.add(i);
        }
        int count = 0;
        Map<Integer, Integer> orders = new HashMap<>();
        while (!values.isEmpty()) {
            orders.put(values.pollFirst(), ++count);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = orders.get(arr[i]);
        }
        return arr;
    }
}
