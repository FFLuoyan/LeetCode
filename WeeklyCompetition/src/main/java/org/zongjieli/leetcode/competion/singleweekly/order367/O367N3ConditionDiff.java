package org.zongjieli.leetcode.competion.singleweekly.order367;

import java.util.*;

/**
 * 给定一个下标从 0 开始、长度为 n 的整数数组 nums
 * 以及整数 indexDifference 和整数 valueDifference
 * 从范围 [0, n - 1] 内找出 2 个满足下述所有条件的下标 i 和 j:
 *  abs(i - j) >= indexDifference 且 abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer,如果存在满足题目要求的两个下标,则 answer = [i, j],否则 answer = [-1, -1]
 * 如果存在多组可供选择的下标对,只需要返回其中任意一组即可
 * 注意: i 和 j 可能相等
 *
 * 1 <= n == nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= indexDifference <= 10^5
 * 0 <= valueDifference <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/15
 */
public class O367N3ConditionDiff {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        TreeMap<Integer, List<Integer>> valueIndex = new TreeMap<>();
        for (int i = indexDifference; i < nums.length; i++) {
            valueIndex.computeIfAbsent(nums[i - indexDifference], k -> new ArrayList<>()).add(i - indexDifference);
            Map.Entry<Integer, List<Integer>> entry = valueIndex.ceilingEntry(nums[i] + valueDifference);
            if (entry == null) {
                entry = valueIndex.floorEntry(nums[i] - valueDifference);
            }
            if (entry != null) {
                for (Integer index : entry.getValue()) {
                    if (Math.abs(index - i) >= indexDifference) {
                        return new int[]{index, i};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        O367N3ConditionDiff test = new O367N3ConditionDiff();
        // [0, 0]
        System.out.println(Arrays.toString(test.findIndices(new int[]{2, 1}, 0, 0)));
        // [0, 2]
        System.out.println(Arrays.toString(test.findIndices(new int[]{9, 4, 0, 9}, 2, 1)));
    }

}
