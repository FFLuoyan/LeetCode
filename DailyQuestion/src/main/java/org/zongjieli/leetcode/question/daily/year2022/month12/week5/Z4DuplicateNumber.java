package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定三个整数数组 nums1、nums2 和 nums3
 * 请构造并返回一个元素各不相同的数组
 * 且由至少在两个数组中出现的所有值组成
 * 数组中的元素可以按任意顺序排列
 *
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/29
 */
public class Z4DuplicateNumber {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> first = new HashSet<>();
        for (int i : nums1) {
            first.add(i);
        }
        Set<Integer> second = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            second.add(i);
            if (first.contains(i)) {
                result.add(i);
            }
        }
        for (int i : nums3) {
            if (second.contains(i) || first.contains(i)) {
                result.add(i);
            }
        }
        return new ArrayList<>(result);
    }

}
