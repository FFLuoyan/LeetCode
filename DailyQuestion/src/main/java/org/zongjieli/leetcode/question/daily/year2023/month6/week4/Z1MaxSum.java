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
        int[][] min = new int[][]{{0, 0}, {66667, 66667}, {66668, 66668}};
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int[] compare = min[num % 3];
            int c0 = compare[0], c1 = compare[1];
            if (num <= c0) {
                compare[1] = c0;
                compare[0] = num;
            } else if (num < c1) {
                compare[1] = num;
            }
        }
        return sum % 3 == 0 ? sum : sum % 3 == 1 ? sum - Math.min(min[1][0], min[2][0] + min[2][1]) : sum - Math.min(min[2][0], min[1][0] + min[1][1]);
    }

}
