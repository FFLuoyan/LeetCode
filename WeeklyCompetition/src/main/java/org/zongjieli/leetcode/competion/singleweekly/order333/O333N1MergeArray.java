package org.zongjieli.leetcode.competion.singleweekly.order333;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个二维整数数组 nums1 和 nums2
 *  nums1[i] = [idI, valI] 表示编号为 idI 的数字对应的值等于 valI
 *  nums2[i] = [idI, valI] 表示编号为 idI 的数字对应的值等于 valI
 * 每个数组都包含互不相同的 id,并按 id 以递增顺序排列
 * 请将两个数组合并为一个按 id 以递增顺序排列的数组,并符合下述条件:
 *  只有在两个数组中至少出现过一次的 id 才能包含在结果数组内
 *  每个 id 在结果数组中只能出现一次,并且其对应的值等于两个数组中该 id 所对应的值求和
 *      如果某个数组中不存在该 id,则认为其对应的值等于 0
 * 返回结果数组,返回的数组需要按 id 以递增顺序排列
 *
 * 1 <= nums1.length, nums2.length <= 200
 * nums1[i].length == nums2[j].length == 2
 * 1 <= idI, valI <= 1000
 * 数组中的 id 互不相同
 * 数据均按 id 以严格递增顺序排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/19
 */
public class O333N1MergeArray {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int[] ints : nums1) {
            values.put(ints[0], ints[1]);
        }
        for (int[] ints : nums2) {
            if (values.containsKey(ints[0])) {
                values.put(ints[0], values.get(ints[0]) + ints[1]);
            } else {
                values.put(ints[0], ints[1]);
            }
        }
        int[][] result = new int[values.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        return result;
    }

}
