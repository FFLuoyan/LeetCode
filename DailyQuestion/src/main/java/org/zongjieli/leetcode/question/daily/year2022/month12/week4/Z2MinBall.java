package org.zongjieli.leetcode.question.daily.year2022.month12.week4;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums,其中 nums[i] 表示第 i 个袋子里球的数目,同时给定一个整数 maxOperations
 * 可以进行如下操作至多 maxOperations 次:
 *  选择任意一个袋子,并将袋子里的球分到 2 个新的袋子中,每个袋子里都有正整数个球
 *  比方说,一个袋子里有 5 个球,可以把它们分到两个新袋子里,分别有 1 个和 4 个球,或者分别有 2 个和 3 个球
 * 开销是单个袋子里球数目的最大值,想要最小化开销
 * 请返回进行上述操作后的最小开销
 *
 * 1 <= nums.length <= 10^5
 * 1 <= maxOperations, nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/27
 */
public class Z2MinBall {

    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = (int) ((sum + nums.length + maxOperations - 1) / (nums.length + maxOperations)), right = nums[nums.length - 1];
        if (canSplit(nums, maxOperations, left)) {
            return left;
        }
        while (left < right) {
            int middle = (left + right) / 2;
            if (canSplit(nums, maxOperations, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean canSplit(int[] nums, int operation, int split) {
        for (int i = nums.length - 1; i >= 0 && nums[i] > split ; i--) {
            operation -= ((nums[i] + split - 1) / split - 1);
            if (operation < 0) {
                return false;
            }
        }
        return operation >= 0;
    }

    public static void main(String[] args) {
        Z2MinBall test = new Z2MinBall();
        // 3
        System.out.println(test.minimumSize(new int[]{9}, 2));
        // 2
        System.out.println(test.minimumSize(new int[]{2, 4, 8, 2}, 4));
        // 129
        System.out.println(test.minimumSize(new int[]{431, 922, 158, 60, 192, 14, 788, 146, 788, 775, 772, 792, 68, 143, 376, 375, 877, 516, 595, 82, 56, 704, 160, 403, 713, 504, 67, 332, 26}, 80));
        // 1
        System.out.println(test.minimumSize(new int[]{1}, 1));
    }

}
