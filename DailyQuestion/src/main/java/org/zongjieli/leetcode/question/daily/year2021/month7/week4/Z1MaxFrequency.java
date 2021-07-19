package org.zongjieli.leetcode.question.daily.year2021.month7.week4;

import java.util.Arrays;

/**
 * 元素的频数是该元素在一个数组中出现的次数
 * 给你一个整数数组 nums 和一个整数 k
 * 在一步操作中,你可以选择 nums 的一个下标,并将该下标对应元素的值增加 1
 *
 * 执行最多 k 次操作后返回数组中最高频元素的最大可能频数
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 *
 * @author   Zongjie.Li
 * @date     2021/7/19
 * @version  1.0
 */
public class Z1MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        int startIndex = 0;
        for (int i = 1 ; i < nums.length ; i++){
            k -= (i - startIndex) * (nums[i] - nums[i - 1]);
            while (k < 0){
                k += (nums[i] - nums[startIndex++]);
            }
            max = Math.max(max,i - startIndex + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Z1MaxFrequency test = new Z1MaxFrequency();
        System.out.println(test.maxFrequency(new int[]{1,1,2,5},2));
    }
}
