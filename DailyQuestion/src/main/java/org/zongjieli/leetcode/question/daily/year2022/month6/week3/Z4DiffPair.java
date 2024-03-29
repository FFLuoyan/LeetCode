package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个整数 k
 * 需要在数组里找到不同的 k-diff 数对
 * 并返回不同的 k-diff 数对的数目
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])
 * 并满足下述全部条件:
 *  0 <= i < j < nums.length
 *  |nums[i] - nums[j]| == k
 * 其中, |val| 表示 val 的绝对值
 *
 * 1 <= nums.length <= 10^4
 * -10^7 <= nums[i] <= 10^7
 * 0 <= k <= 10^7
 *
 * @author   Li.zongjie
 * @date     2022/6/16
 * @version  1.0
 */
public class Z4DiffPair {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, before = 0, target, size = nums.length, next = 1;
        while (before < size) {
            target = nums[before] + k;
            while (next < size && nums[next] <= target) {
                next++;
            }
            if (before != next - 1 && nums[next - 1] == target) {
                result++;
            }
            int v = nums[before++];
            while (before < size && nums[before] == v) {
                before++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4DiffPair test = new Z4DiffPair();
        // 1
        System.out.println(test.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        // 2
        System.out.println(test.findPairs(new int[]{1, 3, 1, 5, 4}, 2));
        // 1
        System.out.println(test.findPairs(new int[]{1, 1, 1, 2, 2}, 1));
    }
}
