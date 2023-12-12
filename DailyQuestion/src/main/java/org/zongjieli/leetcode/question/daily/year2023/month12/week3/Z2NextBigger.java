package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

import java.util.*;

/**
 * 给定一个下标从 0 开始的非负整数数组 nums
 * 对于 nums 中每一个整数,必须找到对应元素的第二大整数
 * 如果 nums[j] 满足以下条件,那么称它为 nums[i] 的第二大整数:
 *  j > i
 *  nums[j] > nums[i]
 *  恰好存在一个 k 满足 i < k < j 且 nums[k] > nums[i]
 * 如果不存在 nums[j],那么第二大整数为 -1
 * 比方说,数组 [1, 2, 4, 3] 中,1 的第二大整数是 4
 * 2 的第二大整数是 3,3 和 4 的第二大整数是 -1
 * 请返回一个整数数组 answer,其中 answer[i] 是 nums[i] 的第二大整数
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/12
 */
public class Z2NextBigger {

    public int[] secondGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        TreeMap<Integer, List<Integer>> existOne = new TreeMap<>();
        TreeMap<Integer, List<Integer>> existZero = new TreeMap<>();
        for (int i = 0; i < result.length; i++) {
            Map.Entry<Integer, List<Integer>> firstEntry;
            while (!existOne.isEmpty() && (firstEntry = existOne.firstEntry()).getKey() < nums[i]) {
                for (Integer index : firstEntry.getValue()) {
                    result[index] = nums[i];
                }
                existOne.pollFirstEntry();
            }
            while (!existZero.isEmpty() && (firstEntry = existZero.firstEntry()).getKey() < nums[i]) {
                List<Integer> existIndexes = existOne.get(firstEntry.getKey());
                if (existIndexes == null) {
                    existOne.put(firstEntry.getKey(), firstEntry.getValue());
                } else {
                    existIndexes.addAll(firstEntry.getValue());
                }
                existZero.pollFirstEntry();
            }
            existZero.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        existOne.forEach((k, v) -> {
            for (Integer index : v) {
                result[index] = -1;
            }
        });
        existZero.forEach((k, v) -> {
            for (Integer index : v) {
                result[index] = -1;
            }
        });
        return result;
    }

    public static void main(String[] args) {
        Z2NextBigger test = new Z2NextBigger();
        //
        System.out.println(Arrays.toString(test.secondGreaterElement(new int[]{2, 4, 0, 9, 6})));
    }
}
