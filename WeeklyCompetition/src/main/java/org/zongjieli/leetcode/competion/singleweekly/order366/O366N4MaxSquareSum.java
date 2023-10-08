package org.zongjieli.leetcode.competion.singleweekly.order366;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个正整数 k
 * 可以对数组执行以下操作任意次:
 *  选择两个互不相同的下标 i 和 j
 *  同时将 nums[i] 更新为 (nums[i] AND nums[j])
 *  且将 nums[j] 更新为 (nums[i] OR nums[j])
 *  OR 表示按位或运算,AND 表示按位与运算
 * 需要从最终的数组里选择 k 个元素,并计算它们的平方之和
 * 请返回可以得到的最大平方和
 * 由于答案可能会很大,将答案对 10^9 + 7 取余后返回
 *
 * 1 <= k <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/8
 */
public class O366N4MaxSquareSum {

    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[31];
        for (Integer num : nums) {
            for (int i = 0; i <= 30; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        long result = 0, current = 1;
        while (--k >= 0 && current != 0) {
            current = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    current += (1 << i);
                    count[i]--;
                }
            }
            result = (result + current * current) % 1000000007;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        O366N4MaxSquareSum test = new O366N4MaxSquareSum();
        // 261
        System.out.println(test.maxSum(Arrays.asList(2, 6, 5, 8), 2));
    }
}
