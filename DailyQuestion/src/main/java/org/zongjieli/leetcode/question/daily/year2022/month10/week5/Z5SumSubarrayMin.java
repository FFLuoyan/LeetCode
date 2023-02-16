package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

/**
 * 给定一个整数数组 arr,找到 min(b) 的总和
 * 其中 b 的范围为 arr 的每个(连续)子数组
 * 由于答案可能很大,因此返回答案模 10^9 + 7
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 3 * 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/10/31
 */
public class Z5SumSubarrayMin {

    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            int before, after, value = arr[i];
            for (before = i - 1 ; before >= 0 && arr[before] >= value ; before--) {}
            for (after = i + 1 ; after < arr.length && arr[after] > value ; after++) {}
            result = result + (long) (i - before) * (after - i) * value;
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        Z5SumSubarrayMin test = new Z5SumSubarrayMin();
        // 3
        System.out.println(test.sumSubarrayMins(new int[]{1, 1}));
    }

}
