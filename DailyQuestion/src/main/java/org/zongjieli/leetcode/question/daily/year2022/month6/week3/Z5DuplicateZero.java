package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import java.util.Arrays;

/**
 * 给定一个长度固定的整数数组 arr
 * 请将该数组中出现的每个零都复写一遍,并将其余的元素向右平移
 * 注意: 请不要在超过该数组长度的位置写入元素
 * 要求: 请对输入的数组就地进行上述修改,不要从函数返回任何东西
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * @author   Li.zongjie
 * @date     2022/6/17
 * @version  1.0
 */
public class Z5DuplicateZero {

    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        for (int ci = 0, ai = 0 ; ci < arr.length ; ci++, ai++) {
            arr[ci] = copy[ai];
            if (copy[ai] == 0 && ++ci < arr.length) {
                arr[ci] = 0;
            }
        }
    }

    public void duplicateZerosInPlace(int[] arr) {
        // 不引入额外数据原地更改方法
        int start = 0, end = 0;
        for (; end < arr.length ; start++, end++) {
            if (arr[start] == 0) {
                end++;
            }
        }
        start--;
        end--;
        if (end == arr.length) {
            arr[--end] = 0;
            end--;
            start--;
        }
        for (; start >= 0 ; start--, end--) {
            arr[end] = arr[start];
            if (arr[start] == 0) {
                arr[--end] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Z5DuplicateZero test = new Z5DuplicateZero();
        int[] tr = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        test.duplicateZerosInPlace(tr);
        // 8, 4, 5, 0, 0, 0, 0, 0
        System.out.println(Arrays.toString(tr));
    }

}
