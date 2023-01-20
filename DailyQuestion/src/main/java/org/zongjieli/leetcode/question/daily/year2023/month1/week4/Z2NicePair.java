package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

import java.util.Arrays;

/**
 * 给定一个数组 nums,数组中只包含非负整数
 * 定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果
 * 比方说 rev(123) = 321,rev(120) = 21
 * 我们称满足下面条件的下标对 (i, j) 是好的:
 *  0 <= i < j < nums.length
 *  nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请返回好下标对的数目,由于结果可能会很大,请将结果对 10^9 + 7 取余后返回
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/17
 */
public class Z2NicePair {

    public int countNicePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], rev = 0;
            while (num > 0) {
                rev = 10 * rev + (num % 10);
                num /= 10;
            }
            nums[i] -= rev;
        }
        Arrays.sort(nums);
        long result = 0;
        int start = 0;
        while (start < nums.length) {
            int before = nums[start], end = start + 1;
            while (end < nums.length && nums[end] == before) {
                end++;
            }
            result += (long) (end - start) * (end - start - 1) / 2;
            start = end;
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        Z2NicePair test = new Z2NicePair();
        // 4
        System.out.println(test.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

}
