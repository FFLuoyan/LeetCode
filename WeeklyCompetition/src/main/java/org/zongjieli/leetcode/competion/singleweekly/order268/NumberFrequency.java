package org.zongjieli.leetcode.competion.singleweekly.order268;

import java.util.*;

/**
 * 请设计一个数据结构,它能求出给定子数组内一个给定值的频率
 * 子数组中一个值的频率指的是这个子数组中这个值的出现次数
 *
 * 请实现 RangeFreqQuery 类:
 *
 *  RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例
 *  int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的频率
 *
 * 一个子数组指的是数组中一段连续的元素,arr[left...right] 指的是 nums 中包含下标 left 和 right 在内的中间一段连续元素
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i], value <= 10^4
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 10^5 次
 *
 * @author   Li.zongjie
 * @date     2021/11/21
 * @version  1.0
 */
public class NumberFrequency {

    private Map<Integer, TreeMap<Integer, Integer>> save = new HashMap<>();

    public NumberFrequency(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            TreeMap<Integer, Integer> indexMap = save.computeIfAbsent(arr[i], k -> new TreeMap<>());
            Integer index = indexMap.floorKey(i);
            if (index == null){
                indexMap.put(i, 1);
            } else {
                indexMap.put(i, indexMap.get(index) + 1);
            }
        }
    }

    public int query(int left, int right, int value) {
        TreeMap<Integer, Integer> query = save.get(value);
        if (query == null){
            return 0;
        }
        Integer min = query.floorKey(left);
        if (min == null){
            Integer max = query.floorKey(right);
            if (max == null){
                return 0;
            }
            return query.get(max);
        }
        int minCount = query.get(min);
        minCount = min == left ? minCount - 1 : minCount;
        Integer max = query.floorKey(right);
        return query.get(max) - minCount;
    }


    public static void main(String[] args) {
        NumberFrequency test = new NumberFrequency(new int[]{12,33,4,56,22,2,34,33,22,12,34,56});
        System.out.println(test.query(0, 11, 33));
    }
}
