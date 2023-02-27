package org.zongjieli.leetcode.competion.singleweekly.order334;

import java.util.TreeMap;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 一开始,所有下标都没有被标记,可以执行以下操作任意次:
 * 选择两个互不相同且未标记的下标 i 和 j,满足 2 * nums[i] <= nums[j],标记下标 i 和 j
 * 请执行上述操作任意次,返回 nums 中最多可以标记的下标数目
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/26
 */
public class O334N3TabIndex {
    public int maxNumOfMarkedIndices(int[] nums) {
        TreeMap<Integer, Integer> values = new TreeMap<>();
        for (int num : nums) {
            values.merge(num, 1, Integer::sum);
        }
        int result = 0;
        TreeMap<Integer, Integer> smaller = new TreeMap<>();
        while (!values.isEmpty()) {
            Integer max = values.lastKey();
            Integer min = values.floorKey(max >> 1);
            if (min == null) {
                break;
            }
            smaller.merge(min, 1, Integer::sum);
            result++;
            int maxCount = values.get(max);
            if (maxCount == 1) {
                values.remove(max);
            } else {
                values.put(max, maxCount - 1);
            }
            int minCount = values.get(min);
            if (minCount == 1) {
                values.remove(min);
            } else {
                values.put(min, minCount - 1);
            }
        }
        while (!smaller.isEmpty() && !values.isEmpty()) {
            Integer max = smaller.lastKey();
            Integer min = values.floorKey(max >> 1);
            if (min == null) {
                break;
            }
            int smallMaxCount = smaller.get(max);
            if (smallMaxCount == 1) {
                smaller.remove(max);
            } else {
                smaller.put(max, smallMaxCount - 1);
            }
            int valueMinCount = values.get(min);
            if (valueMinCount == 1) {
                values.remove(min);
            } else {
                values.put(min, valueMinCount - 1);
            }
            smaller.merge(min, 1, Integer::sum);
            if (!values.isEmpty()) {
                result++;
                int lastKey = values.lastKey();
                int lastCount = values.get(lastKey);
                if (lastCount == 1) {
                    values.pollLastEntry();
                } else {
                    values.put(lastKey, lastCount - 1);
                }
            }
        }
        return 2 * result;
    }

    public static void main(String[] args) {
        O334N3TabIndex test = new O334N3TabIndex();
        // 2
        System.out.println(test.maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        // 4
        System.out.println(test.maxNumOfMarkedIndices(new int[]{9, 5, 2, 4}));
        // 26
        System.out.println(test.maxNumOfMarkedIndices(new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40}));
    }
}
