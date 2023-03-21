package org.zongjieli.leetcode.competion.doubleweekly.order100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 需要将 nums 重新排列成一个新的数组 perm
 * 定义 nums 的伟大值为满足 0 <= i < nums.length 且 perm[i] > nums[i] 的下标数目
 * 请返回重新排列 nums 后的最大伟大值
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/18
 */
public class O100N2MaxGreatest {

    public int maximizeGreatness(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            max = Math.max(max, count.get(num));
        }
        return nums.length - max;
    }

}
