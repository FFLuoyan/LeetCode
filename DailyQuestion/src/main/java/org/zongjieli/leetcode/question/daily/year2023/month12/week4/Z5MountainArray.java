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

    public int minimumMountainRemovals(int[] nums) {
        int[] leftCount = new int[nums.length];
        int[] leftCache = new int[nums.length + 1];
        int[] rightCache = new int[nums.length + 1];
        int remainMax = 0, rmi, num, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if ((num = nums[i]) > leftCache[remainMax]) {
                leftCache[++remainMax] = num;
            } else {
                rmi = remainMax;
                while (rmi >= 0 && leftCache[rmi] >= num) {
                    rmi--;
                }
                leftCache[rmi + 1] = Math.min(num, leftCache[rmi + 1]);
            }
            leftCount[i] = remainMax;
        }
        remainMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((num = nums[i]) > rightCache[remainMax]) {
                rightCache[++remainMax] = num;
            } else {
                rmi = remainMax;
                while (rmi >= 0 && rightCache[rmi] >= num) {
                    rmi--;
                }
                rightCache[rmi + 1] = Math.min(num, rightCache[rmi + 1]);
            }
            if (remainMax >= 2 && leftCount[i] >= 2) {
                result = Math.min(result, nums.length - remainMax - leftCount[i] + 1);
            }
        }
        return result;
    }

}
