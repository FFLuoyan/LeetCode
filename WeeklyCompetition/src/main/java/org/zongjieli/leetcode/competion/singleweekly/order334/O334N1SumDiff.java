package org.zongjieli.leetcode.competion.singleweekly.order334;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums,请找出一个下标从 0 开始的整数数组 answer,其中:
 *  answer.length == nums.length
 *  answer[i] = |leftSum[i] - rightSum[i]|
 *  其中:
 *      leftSum[i] 是数组 nums 中下标 i 左侧元素之和,如果不存在对应的元素,leftSum[i] = 0
 *      rightSum[i] 是数组 nums 中下标 i 右侧元素之和,如果不存在对应的元素,rightSum[i] = 0
 * 返回数组 answer
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/26
 */
public class O334N1SumDiff {

    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        int[] rightSum = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        O334N1SumDiff test = new O334N1SumDiff();
        // 15, 1, 11, 22
        System.out.println(Arrays.toString(test.leftRigthDifference(new int[]{10, 4, 8, 3})));
    }
}
