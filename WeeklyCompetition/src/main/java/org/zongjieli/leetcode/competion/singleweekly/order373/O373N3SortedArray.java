package org.zongjieli.leetcode.competion.singleweekly.order373;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个下标从 0 开始的正整数数组 nums 和一个正整数 limit
 * 在一次操作中,可以选择任意两个下标 i 和 j
 * 如果满足 |nums[i] - nums[j]| <= limit,则交换 nums[i] 和 nums[j]
 * 返回执行任意次操作后能得到的字典序最小的数组
 * 如果在数组 a 和数组 b 第一个不同的位置上
 * 数组 a 中的对应字符比数组 b 中的对应字符的字典序更小
 * 则认为数组 a 就比数组 b 字典序更小
 * 例如,数组 [2,10,3] 比数组 [10,2,3] 字典序更小
 * 下标 0 处是两个数组第一个不同的位置,且 2 < 10
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= limit <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/26
 */
public class O373N3SortedArray {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        TreeMap<Integer, Integer> groups = new TreeMap<>();
        for (int num : nums) {
            if (groups.containsKey(num)) {
                continue;
            }
            Map.Entry<Integer,  Integer> higherEntry = groups.higherEntry(num);
            Map.Entry<Integer, Integer> lowerEntry = groups.lowerEntry(num);
            if (higherEntry == null) {
                if (lowerEntry == null) {
                    groups.put(num, num + limit);
                } else if (lowerEntry.getValue() >= num) {
                    if (lowerEntry.getValue() < num + limit) {
                        groups.put(lowerEntry.getKey(), num + limit);
                    }
                } else {
                    groups.put(num, num + limit);
                }
            } else if (lowerEntry == null) {
                if (higherEntry.getKey() <= num + limit) {
                    groups.put(num, higherEntry.getValue());
                    groups.remove(higherEntry.getKey());
                } else {
                    groups.put(num, num + limit);
                }
            } else if (lowerEntry.getValue() >= num) {
                if (higherEntry.getKey() <= num + limit) {
                    groups.put(lowerEntry.getKey(), higherEntry.getValue());
                    groups.remove(higherEntry.getKey());
                } else if (lowerEntry.getValue() < num + limit) {
                    groups.put(lowerEntry.getKey(), num + limit);
                }
            } else if (higherEntry.getKey() <= num + limit) {
                groups.put(num, higherEntry.getValue());
                groups.remove(higherEntry.getKey());
            } else {
                groups.put(num, num + limit);
            }
        }
        Map<Integer, List<int[]>> groupValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            groupValues.computeIfAbsent(groups.floorKey(nums[i]), k -> new ArrayList<>()).add(new int[]{nums[i], i});
        }
        groupValues.forEach((k, v) -> {
            List<int[]> sortedValues = v.stream().sorted(Comparator.comparingInt(a -> a[0])).collect(Collectors.toList());
            List<int[]> sortedIndexes = v.stream().sorted(Comparator.comparingInt(a -> a[1])).collect(Collectors.toList());
            for (int i = 0; i < sortedValues.size(); i++) {
                nums[sortedIndexes.get(i)[1]] = sortedValues.get(i)[0];
            }
        });
        return nums;
    }

    public static void main(String[] args) {
        O373N3SortedArray test = new O373N3SortedArray();
        // [1, 3, 5, 8, 9]
        System.out.println(Arrays.toString(test.lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2)));
        // [4, 61, 5, 8, 62, 68, 27, 10, 42, 70]
        System.out.println(Arrays.toString(test.lexicographicallySmallestArray(new int[]{4, 68, 8, 10, 70, 62, 27, 5, 42, 61}, 11)));
        // [19, 22, 32, 42, 49, 57, 62, 63, 74, 87]
        System.out.println(Arrays.toString(test.lexicographicallySmallestArray(new int[]{19, 22, 32, 42, 49, 57, 74, 87, 62, 63}, 13)));
    }
}
