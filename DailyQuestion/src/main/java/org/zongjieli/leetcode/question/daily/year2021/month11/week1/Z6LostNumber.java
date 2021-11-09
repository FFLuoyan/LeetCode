package org.zongjieli.leetcode.question.daily.year2021.month11.week1;
/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums
 * 找出 [0, n] 这个范围内没有出现在数组中的那个数
 *
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都独一无二
 *
 * @author   Li.zongjie
 * @date     2021/11/9
 * @version  1.0
 */
public class Z6LostNumber {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        int i = 0;
        for (; i < nums.length ; i++){
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}
