package org.zongjieli.leetcode.question.daily.year2022.month2.week1;
/**
 * 给定一个整数数组 nums,数组中唯一元素是那些只出现恰好一次的元素
 * 请返回 nums 中唯一元素的和
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/3/16
 * @version  1.0
 */
public class Z7UniqueSum {
    public int sumOfUnique(int[] nums) {
        int result = 0;
        int[] count = new int[101];
        for (int num : nums) {
            if (count[num] == 0) {
                result += num;
            } else if (count[num] == 1) {
                result -= num;
            }
            count[num]++;
        }
        return result;
    }
}
