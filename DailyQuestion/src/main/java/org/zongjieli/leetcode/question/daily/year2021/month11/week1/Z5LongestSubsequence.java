package org.zongjieli.leetcode.question.daily.year2021.month11.week1;

/**
 * 给定一个整数数组 arr 和一个整数 difference
 * 请找出并返回 arr 中最长等差子序列的长度
 * 该子序列中相邻元素之间的差等于 difference
 *
 * 子序列是指在不改变其余元素顺序的情况下
 * 通过删除一些元素或不删除任何元素而从 arr 派生出来的序列
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 *
 * @author   Li.zongjie
 * @date     2021/11/5
 * @version  1.0
 */
public class Z5LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int[] save = new int[40001];
        int result = 0;
        for (int i : arr) {
            result = Math.max(result, save[i += 20000] = save[i - difference] + 1);
        }
        return result;
    }
}
