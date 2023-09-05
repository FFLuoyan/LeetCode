package org.zongjieli.leetcode.competion.singleweekly.order361;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个下标从 0 开始的整数数组 nums,以及整数 modulo 和整数 k
 * 请找出并统计数组中趣味子数组的数目
 * 如果子数组 nums[l..r] 满足下述条件,则称其为趣味子数组
 * 在范围 [l, r] 内,设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量,并且 cnt % modulo == k
 * 以整数形式表示并返回趣味子数组的数目
 * 注意: 子数组是数组中的一个连续非空的元素序列
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= modulo <= 10^9
 * 0 <= k < modulo
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/3
 */
public class O361N3InterestingSubarray {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        if (k > nums.size()) {
            return 0;
        }
        long[] count = new long[Math.min(modulo, nums.size() + 1)];
        int zeroIndex = 0;
        long result = 0;
        for (Integer num : nums) {
            count[zeroIndex % modulo]++;
            if (num % modulo == k) {
                zeroIndex++;
            }
            if (zeroIndex >= k) {
                result += count[(zeroIndex - k) % modulo];
            }
        }
        return result;
    }


    public static void main(String[] args) {O361N3InterestingSubarray test = new O361N3InterestingSubarray();
        // 3
        System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        // 2
        System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
        // 4
        System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 5, 4, 2), 5, 0));
        // 0
        System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 3), 5, 3));
    }

}
