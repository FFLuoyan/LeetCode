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
        int result = 0;
        if (k == 0) {
            int index = 0;
            while (index < nums.length) {
                int nextIndex = getNextIndex(nums, index);
                if (nextIndex - index > 1) {
                    result++;
                }
                index = nextIndex;
            }
            return result;
        }

        int before = 0, nextIndex = getNextIndex(nums, 0);
        while (nextIndex < nums.length) {
            int v = nums[nextIndex] - nums[before];
            if (v > k) {
                before = getNextIndex(nums, before);
            } else {
                if (v == k) {
                    result++;
                }
                nextIndex = getNextIndex(nums, nextIndex);
            }
        }
        return result;
    }

    private int getNextIndex(int[] nums, int index) {
        int v = nums[index++];
        while (index < nums.length && nums[index] == v) {
            index++;
        }
        return index;
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
