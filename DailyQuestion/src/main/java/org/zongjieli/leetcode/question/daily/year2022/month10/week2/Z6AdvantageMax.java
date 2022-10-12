package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，
 * nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述
 * 返回 nums1 的任意排列,使其相对于 nums2 的优势最大化
 *
 * 1 <= nums1.length <= 10^5
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z6AdvantageMax {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> save = new TreeMap<>();
        for (int num : nums1) {
            save.merge(num, 1, Integer::sum);
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer key = save.higherKey(nums2[i]);
            if (key == null) {
                key = save.firstKey();
            }
            nums1[i] = key;
            Integer value = save.get(key);
            if (value == 1) {
                save.remove(key);
            } else {
                save.put(key, value - 1);
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        Z6AdvantageMax test = new Z6AdvantageMax();
        System.out.println(Arrays.toString(test.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }
}
