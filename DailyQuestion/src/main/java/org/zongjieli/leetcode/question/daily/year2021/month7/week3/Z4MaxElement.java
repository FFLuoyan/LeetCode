package org.zongjieli.leetcode.question.daily.year2021.month7.week3;

import java.util.Arrays;

/**
 * 给你一个正整数数组 arr,请你对 arr 执行一些操作(也可以不进行任何操作)
 * 使得数组满足以下条件：
 *  arr 中第一个元素必须为 1 。
 *  任意相邻两个元素的差的绝对值小于等于 1
 *  也就是说,对于任意的 1 <= i < arr.length(数组下标从 0 开始)
 *  都满足 abs(arr[i] - arr[i - 1]) <= 1,abs(x) 为 x 的绝对值
 * 你可以执行以下 2 种操作任意次:
 *
 * 减小 arr 中任意元素的值,使其变为一个更小的正整数
 * 重新排列 arr 中的元素,你可以以任意顺序重新排列
 * 请你返回执行以上操作后,在满足前文所述的条件下,arr 中可能的最大值
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 *
 * @author   Zongjie.Li
 * @date     2021/7/15
 * @version  1.0
 */
public class Z4MaxElement {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] count = new int[arr.length + 1];
        for (int i : arr) {
            count[Math.min(i,arr.length)]++;
        }
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0){
                max += Math.min(i - max,count[i]);
            }
        }
        return max;
    }
    public int maximumElementAfterDecrementingAndRearrangingBySort(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] > arr[i - 1]){
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Z4MaxElement test = new Z4MaxElement();
        System.out.println(test.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,2,1,1,1,8}));
        System.out.println(test.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
    }
}
