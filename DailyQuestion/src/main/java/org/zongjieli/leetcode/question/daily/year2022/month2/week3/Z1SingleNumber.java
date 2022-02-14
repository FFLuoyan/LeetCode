package org.zongjieli.leetcode.question.daily.year2022.month2.week3;
/**
 * 给定一个仅由整数组成的有序数组,其中每个元素都会出现两次
 * 唯有一个数只会出现一次,请找出并返回只出现一次的那个数
 *
 * 设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度
 *
 *  1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/2/14
 * @version  1.0
 */
public class Z1SingleNumber {

    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
