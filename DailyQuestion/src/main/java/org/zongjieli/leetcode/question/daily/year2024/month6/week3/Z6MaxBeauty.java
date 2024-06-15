package org.zongjieli.leetcode.question.daily.year2024.month6.week3;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个非负整数 k
 * 在一步操作中,可以执行下述指令:
 *  在范围 [0, nums.length - 1] 中选择一个此前没有选过的下标 i
 *  将 nums[i] 替换为范围 [nums[i] - k, nums[i] + k] 内的任一整数
 *  数组的美丽值定义为数组中由相等元素组成的最长子序列的长度
 * 对数组 nums 执行上述操作任意次后,返回数组可能取得的最大美丽值
 * 注意:
 *  只能对每个下标执行一次此操作
 * 数组的子序列定义是:
 *  经由原数组删除一些元素(也可能不删除)得到的一个新数组,且在此过程中剩余元素的顺序不发生改变
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i], k <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/6/16
 */
public class Z6MaxBeauty {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, result = 0, maxRight;
        while (right < nums.length) {
            maxRight = nums[left] + 2 * k;
            while (right < nums.length && nums[right] <= maxRight) {
                right++;
            }
            result = Math.max(result, right - left++);
        }
        return result;
    }

}
