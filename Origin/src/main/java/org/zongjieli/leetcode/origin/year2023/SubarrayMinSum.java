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
        int[] leftCount = new int[arr.length];
        int[] nearestLess = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            leftCount[i] = findBeforeCount(i, nearestLess, arr);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            long rightCount = findAfterCount(i, nearestLess, arr);
            result += (rightCount * leftCount[i]) * arr[i];
        }
        return (int) (result % 1000000007);
    }

    public int findBeforeCount(int currentIndex, int[] nearestLess, int[] arr) {
        int value = arr[currentIndex], index = currentIndex - 1;
        while (index > -1 && arr[index] >= value) {
            index = nearestLess[index];
        }
        return currentIndex - (nearestLess[currentIndex] = index);
    }

    public int findAfterCount(int currentIndex, int[] nearestLess, int[] arr) {
        int value = arr[currentIndex], index = currentIndex + 1;
        while (index < arr.length && arr[index] > value) {
            index = nearestLess[index];
        }
        return (nearestLess[currentIndex] = index) - currentIndex;
    }

    public static void main(String[] args) {
        SubarrayMinSum test = new SubarrayMinSum();
        // 444
        System.out.println(test.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        // 3
        System.out.println(test.sumSubarrayMins(new int[]{1, 1}));
        // 17
        System.out.println(test.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

}
