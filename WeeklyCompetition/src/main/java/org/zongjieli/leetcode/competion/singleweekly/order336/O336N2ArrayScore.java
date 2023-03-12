package org.zongjieli.leetcode.competion.singleweekly.order336;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 可以将 nums 中的元素按任意顺序重排(包括给定顺序)
 * 令 prefix 为一个数组,它包含了 nums 重新排列后的前缀和
 * 换句话说,prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和
 * nums 的分数是 prefix 数组中正整数的个数
 * 返回可以得到的最大分数
 *
 * 1 <= nums.length <= 10^5
 * -10^6 <= nums[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/12
 */
public class O336N2ArrayScore {

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        long sum = 0;
        int result = 0;
        while (index >= 0 && (sum += nums[index]) > 0) {
            result++;
            index--;
        }
        return result;
    }

}
