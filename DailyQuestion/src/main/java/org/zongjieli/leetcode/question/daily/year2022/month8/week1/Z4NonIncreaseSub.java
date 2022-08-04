package org.zongjieli.leetcode.question.daily.year2022.month8.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums,请从中抽取一个子序列
 * 满足该子序列的元素之和严格大于未包含在该子序列中的各元素之和
 * 如果存在多个解决方案,只需返回长度最小的子序列
 * 如果仍然有多个解决方案,则返回元素之和最大的子序列
 * 与子数组不同的地方在于,数组的子序列不强调元素在原数组中的连续性
 * 也就是说,它可以通过从数组中分离一些(也可能不分离)元素得到
 * 注意,题目数据保证满足所有约束条件的解决方案是唯一的
 * 同时,返回的答案应当按非递增顺序排列
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/8/4
 * @version  1.0
 */
public class Z4NonIncreaseSub {

    public List<Integer> minSubsequence(int[] nums) {
        int[] count = new int[101];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count[num]++;
        }
        int half = sum / 2;
        sum = 0;
        List<Integer> result = new ArrayList<>();
        int i = 100;
        while (i >= 0) {
            if (--count[i] >= 0) {
                result.add(i);
                if ((sum += i) > half) {
                    break;
                }
            } else {
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4NonIncreaseSub test = new Z4NonIncreaseSub();
        System.out.println(test.minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }
}
