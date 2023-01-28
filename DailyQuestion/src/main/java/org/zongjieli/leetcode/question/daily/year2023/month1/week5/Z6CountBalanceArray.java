package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 给定一个整数数组 nums,需要选择恰好一个下标(下标从 0 开始)并删除对应的元素
 * 请注意剩下元素的下标可能会因为删除操作而发生改变
 * 比方说,如果 nums = [6,1,7,4,1],那么:
 *  选择删除下标 1,剩下的数组为 nums = [6, 7, 4, 1]
 *  选择删除下标 2,剩下的数组为 nums = [6, 1, 4, 1]
 *  选择删除下标 4,剩下的数组为 nums = [6, 1, 7, 4]
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等,该数组就是一个平衡数组
 * 请返回删除操作后,剩下的数组 nums 是平衡数组的方案数
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/28
 */
public class Z6CountBalanceArray {

    public int waysToMakeFair(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return 0;
        }
        int result = 0, oddSum = 0, evenSum = 0, before = 0;
        for (int i = 0; i < nums.length; i += 2) {
            evenSum += nums[i];
        }
        for (int i = 1; i < nums.length; i += 2) {
            oddSum += nums[i];
        }
        for (int num : nums) {
            if ((evenSum = evenSum + before - (before = num)) == oddSum) {
                result++;
            }
            int temp = evenSum;
            evenSum = oddSum;
            oddSum = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        Z6CountBalanceArray test = new Z6CountBalanceArray();
        // 1
        System.out.println(test.waysToMakeFair(new int[]{2, 1, 6, 4}));
    }

}
