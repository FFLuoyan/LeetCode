package org.zongjieli.leetcode.origin.year2023;


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
 * @date 2023/11/27
 */
public class SubarrayMinSum {

    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - 1, right = i + 1;
            long value = arr[i];
            while (left >= 0 && arr[left] >= value) {
                left--;
            }
            while (right < arr.length && arr[right] > value) {
                right++;
            }
            result = (result + value * (i - left) * (right - i)) % 1000000007;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        SubarrayMinSum test = new SubarrayMinSum();
        // 444
        System.out.println(test.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        // 3
        System.out.println(test.sumSubarrayMins(new int[]{1, 1}));
    }

}
