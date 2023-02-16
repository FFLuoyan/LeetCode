package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 在一步操作中,可以执行以下步骤:
 *  从 nums 选出两个相等的整数
 *  从 nums 中移除这两个整数,形成一个数对
 * 请在 nums 上多次执行此操作直到无法继续执行
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案
 * 其中 answer[0] 是形成的数对数目,answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/16
 */
public class Z4CountPair {

    public int[] numberOfPairs(int[] nums) {
        int count = 0;
        boolean[] save = new boolean[101];
        for (int num : nums) {
            if (!(save[num] = !save[num])) {
                count++;
            }
        }
        return new int[]{count, nums.length - 2 * count};
    }

}
