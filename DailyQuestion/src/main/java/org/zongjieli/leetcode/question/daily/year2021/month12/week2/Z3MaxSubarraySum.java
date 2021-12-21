package org.zongjieli.leetcode.question.daily.year2021.month12.week2;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 找出三个长度为 k,互不重叠,且 3 * k 项的和最大的子数组,并返回这三个子数组
 * 以下标的数组形式返回结果,数组中的每一项分别指示每个子数组的起始位置(下标从 0 开始)
 * 如果有多个结果,返回字典序最小的一个
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] < 2^16
 * 1 <= k <= floor(nums.length / 3)
 *
 * @author   Li.zongjie
 * @date     2021/12/8
 * @version  1.0
 */
public class Z3MaxSubarraySum {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] value = new int[nums.length - k + 1];
        for (int i = 0 ; i < k ; i++){
            value[0] += nums[i];
        }
        for (int i = k ; i < nums.length ; i++){
            value[i - k + 1] = value[i - k] + nums[i] - nums[i - k];
        }

        int[] rightMax = new int[value.length];
        rightMax[value.length - 1] = value.length - 1;
        for (int i = value.length - 2 ; i >= 2 * k ; i--){
            rightMax[i] = value[i] >= value[rightMax[i + 1]] ? i : rightMax[i + 1];
        }

        int[] leftMax = new int[value.length];
        for (int i = 1 ; i < value.length - 2 * k ; i++){
            leftMax[i] = value[i] > value[leftMax[i - 1]] ? i : leftMax[i - 1];
        }

        int maxIndex1 = 0;
        int maxIndex2 = k;
        int maxIndex3 = 2 * k;
        int max = 0;

        int index1,index3,temp;
        for (int index2 = k ; index2 < value.length - k ; index2++){
            index1 = leftMax[index2 - k];
            index3 = rightMax[index2 + k];
            if ((temp = value[index1] + value[index2] + value[index3]) > max){
                max = temp;
                maxIndex1 = index1;
                maxIndex2 = index2;
                maxIndex3 = index3;
            }
        }

        return new int[]{maxIndex1, maxIndex2, maxIndex3};
    }

    public static void main(String[] args) {
        Z3MaxSubarraySum test = new Z3MaxSubarraySum();
        // 1,4,7
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3)));
        // 0,3,5
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)));
        // 0,2,4
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1}, 2)));
        // 0,1,2
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,1,1,1,1,1}, 1)));
        // 38,58,64
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{13,10,7,7,15,7,15,11,10,9,7,3,17,19,13,7,18,17,4,4,17,20,5,7,17,9,6,7,13,8,5,10,13,20,16,13,14,11,20,14,16,17,16,16,4,2,11,5,17,14,2,3,18,9,16,3,1,9,20,13,17,15,10,8,15,17,19,9,12,14,5,20,11,2,9,10,6,5,8,9,4,19,13,16,1,6,14,5,8,15,16,6,1,9,4,18,16,1,8,5}, 3)));
        // 6,41,75
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{10,5,9,4,14,10,16,9,17,19,2,11,15,10,17,20,3,14,19,17,14,20,10,17,9,14,18,3,7,5,7,20,11,1,13,6,3,11,18,3,5,6,14,10,10,4,12,7,5,7,5,15,14,20,13,15,6,20,13,6,9,15,2,6,16,13,2,9,14,3,6,2,10,9,7,10,5,3,14,14,6,16,1,19,12,5,16,9,2,16,11,19,9,2,17,19,6,5,6,6}, 21)));
    }
}
