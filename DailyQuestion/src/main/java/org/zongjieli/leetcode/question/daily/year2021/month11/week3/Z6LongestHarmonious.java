package org.zongjieli.leetcode.question.daily.year2021.month11.week3;

import java.util.*;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是 1
 * 现在,给定一个整数数组 nums
 * 请在所有可能的子序列中找到最长的和谐子序列的长度
 * 数组的子序列是一个由数组派生出来的序列
 * 它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/11/20
 * @version  1.0
 */
public class Z6LongestHarmonious {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> save = new HashMap<>();
        for (int num : nums) {
            save.merge(num, 1, Integer::sum);
        }
        int[] result = new int[]{0};
        save.forEach((key, value) -> {
            Integer add = save.get(key + 1);
            if (add != null) {
                result[0] = Math.max(result[0], value + add);
            }
        });
        return result[0];
    }

    public static void main(String[] args) {
        Z6LongestHarmonious test = new Z6LongestHarmonious();
        System.out.println(test.findLHS(new int[]{1,1,1,1}));
    }
}
