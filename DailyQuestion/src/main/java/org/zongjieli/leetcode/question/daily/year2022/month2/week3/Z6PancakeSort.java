package org.zongjieli.leetcode.question.daily.year2022.month2.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 arr,请使用煎饼翻转完成对数组的排序
 * 一次煎饼翻转的执行过程如下:
 *  选择一个整数 k,1 <= k <= arr.length
 *  反转子数组 arr[0...k-1](下标从 0 开始)
 * 例如,arr = [3,2,1,4],选择 k = 3 进行一次煎饼翻转
 * 反转子数组 [3,2,1],得到 arr = [1,2,3,4]
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列
 * 任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= arr.length
 * arr 中的所有整数互不相同(即,arr 是从 1 到 arr.length 整数的一个排列)
 *
 * @author   Li.zongjie
 * @date     2022/3/4
 * @version  1.0
 */
public class Z6PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> values = new LinkedList<>();
        for (int i : arr) {
            values.addLast(i);
        }
        for (int i = arr.length ; i > 1 ; i--) {
            int count = 0;
            while (!values.isEmpty()) {
                count++;
                int value = values.pollFirst();
                if (value == i) {
                    if (count > 1) {
                        result.add(count);
                    }
                    result.add(i);
                    if (i > count + 1) {
                        result.add(i - count);
                    }
                    break;
                }
                values.addLast(value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z6PancakeSort test = new Z6PancakeSort();
        // [4, 2, 4, 3]
        System.out.println(test.pancakeSort(new int[]{3, 2, 4, 1}));
        // [3, 2]
        System.out.println(test.pancakeSort(new int[]{3, 1, 2}));
    }
}
