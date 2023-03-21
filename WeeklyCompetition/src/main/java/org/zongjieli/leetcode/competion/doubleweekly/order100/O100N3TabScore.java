package org.zongjieli.leetcode.competion.doubleweekly.order100;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 给定一个数组 nums,它包含若干正整数
 * 一开始分数 score = 0,请按照下面算法求出最后分数:
 *  从数组中选择最小且没有被标记的整数,如果有相等元素,选择下标最小的一个
 *  将选中的整数加到 score 中
 *  标记被选中元素,如果有相邻元素,则同时标记与它相邻的两个元素
 * 重复此过程直到数组中所有元素都被标记
 * 请返回执行上述算法后最后的分数
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/18
 */
public class O100N3TabScore {

    public long findScore(int[] nums) {
        TreeMap<Integer, TreeSet<Integer>> valueIndexes = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            TreeSet<Integer> indexes = valueIndexes.get(nums[i]);
            if (indexes == null) {
                indexes = new TreeSet<>();
            }
            indexes.add(i);
            valueIndexes.put(nums[i], indexes);
        }
        long result = 0;
        while (!valueIndexes.isEmpty()) {
            Map.Entry<Integer, TreeSet<Integer>> firstEntry = valueIndexes.firstEntry();
            int key = firstEntry.getKey();
            TreeSet<Integer> indexes = firstEntry.getValue();
            int firstIndex = indexes.pollFirst();
            if (indexes.isEmpty()) {
                valueIndexes.remove(key);
            }
            result += key;
            if (firstIndex != 0) {
                int leftValue = nums[firstIndex - 1];
                if (valueIndexes.containsKey(leftValue)) {
                    TreeSet<Integer> removeLeft =  valueIndexes.get(leftValue);
                    removeLeft.remove(firstIndex - 1);
                    if (removeLeft.isEmpty()) {
                        valueIndexes.remove(leftValue);
                    }
                }
            }
            if (firstIndex != nums.length - 1) {
                int rightValue = nums[firstIndex + 1];
                if (valueIndexes.containsKey(rightValue)) {
                    TreeSet<Integer> removeRight = valueIndexes.get(rightValue);
                    removeRight.remove(firstIndex + 1);
                    if (removeRight.isEmpty()) {
                        valueIndexes.remove(rightValue);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        O100N3TabScore test = new O100N3TabScore();
        // 7
        System.out.println(test.findScore(new int[]{2, 1, 3, 4, 5, 2}));
    }
}
