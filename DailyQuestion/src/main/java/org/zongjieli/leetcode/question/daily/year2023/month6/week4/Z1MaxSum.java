package org.zongjieli.leetcode.question.daily.year2023.month6.week4;

/**
 * 给定一个整数数组 nums,请找出并返回能被三整除的元素最大和
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/19
 */
public class Z1MaxSum {

    public int maxSumDivThree(int[] nums) {
        int[] minOne = new int[]{66667, 66667};
        int[] minTwo = new int[]{66668, 66668};
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                if (num <= minOne[0]) {
                    minOne[1] = minOne[0];
                    minOne[0] = num;
                } else if (num <= minOne[1]) {
                    minOne[1] = num;
                }
            } else if (num % 3 == 2) {
                if (num <= minTwo[0]) {
                    minTwo[1] = minTwo[0];
                    minTwo[0] = num;
                } else if (num <= minTwo[1]) {
                    minTwo[1] = num;
                }
            }
        }
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            return sum - Math.min(minOne[0], minTwo[0] + minTwo[1]);
        } else {
            return sum - Math.min(minOne[0] + minOne[1], minTwo[0]);
        }
    }

}
