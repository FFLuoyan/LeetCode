package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums,它表示英雄的能力值
 * 如果我们选出一部分英雄,这组英雄的力量定义为:
 *  i0 ，i1 ，... ik 表示这组英雄在数组中的下标
 *  那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])^2 * min(nums[i0],nums[i1] ... nums[ik])
 * 请返回所有可能的非空英雄组的力量之和
 * 由于答案可能非常大,请将结果对 10^9 + 7 取余
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/1
 */
public class Z2HeroPower {

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long result = 0;
        long[] maxes = new long[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            long max = nums[i];
            maxes[i] = (max * max) % 1000000007;
        }
        long before = 0, current, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            sum = (sum * 2 - before + current) % 1000000007;
            result = (result + sum * maxes[i]) % 1000000007;
            before = current;
        }
        return (int) (result % 1000000007);
    }

}
