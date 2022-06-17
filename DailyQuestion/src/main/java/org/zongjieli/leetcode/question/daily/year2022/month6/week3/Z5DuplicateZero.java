package org.zongjieli.leetcode.question.daily.year2022.month6.week3;
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

}
