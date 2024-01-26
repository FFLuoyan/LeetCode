package org.zongjieli.leetcode.question.daily.year2023.month12.week4;

/**
 * 定义 arr 是山形数组当且仅当它满足:
 *  arr.length >= 3
 *  存在某个下标 i (从 0 开始) 满足 0 < i < arr.length - 1 且:
 *      arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *      arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给定整数数组 nums,请返回将 nums 变成山形状数组的最少删除次数
 *
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 题目保证 nums 删除一些元素后一定能得到山形数组
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/25
 */
public class Z5MountainArray {

    int remainMax;

    public int minimumMountainRemovals(int[] nums) {
        int[] leftCount = new int[nums.length];
        int[] leftCache = new int[nums.length + 1];
        int[] rightCache = new int[nums.length + 1];
        remainMax = 0;
        int num, result, ri = nums.length;
        for (int i = 0; i < nums.length; i++) {
            leftCache[findMaxSmallerIndex(leftCache, 0, remainMax, num = nums[i]) + 1] = num;
            leftCount[i] = remainMax;
        }
        remainMax = 0;
        while (remainMax < 2) {
            rightCache[findMaxSmallerIndex(rightCache, 0, remainMax, num = nums[--ri]) + 1] = num;
        }
        result = nums.length - remainMax - leftCount[ri] + 1;
        while (leftCount[ri] >= 2) {
            rightCache[findMaxSmallerIndex(rightCache, 0, remainMax, num = nums[--ri]) + 1] = num;
            result = Math.min(result, nums.length - remainMax - leftCount[ri] + 1);
        }
        return result;
    }

    public int findMaxSmallerIndex(int[] values, int start, int end, int target) {
        if (values[end] < target) {
            return remainMax++;
        }
        while (start < end) {
            int middle = (start + end + 1) / 2;
            if (values[middle] >= target) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Z5MountainArray test = new Z5MountainArray();
        // 0
        System.out.println(test.minimumMountainRemovals(new int[]{1, 3, 1}));
    }
}
