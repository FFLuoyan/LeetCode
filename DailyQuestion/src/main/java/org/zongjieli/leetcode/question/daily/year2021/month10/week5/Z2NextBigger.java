package org.zongjieli.leetcode.question.daily.year2021.month10.week5;

import java.util.*;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2
 * 其中 nums1 是 nums2 的子集
 *
 * 请找出 nums1 中每个元素在 nums2 中的下一个比其大的值
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素
 * 如果不存在,对应位置输出 -1
 *
 *  1 <= nums1.length <= nums2.length <= 1000
 *  0 <= nums1[i], nums2[i] <= 10^4
 *  nums1 和 nums2中所有整数互不相同
 *  nums1 中的所有整数同样出现在 nums2 中
 *
 * @author   Li.zongjie
 * @date     2021/10/26
 * @version  1.0
 */
public class Z2NextBigger {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] numsIndex = new int[10001];
        Set<Integer> numberIndexSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            Iterator<Integer> iterator = numberIndexSet.iterator();
            while (iterator.hasNext()){
                int key = iterator.next();
                if (current > key){
                    numsIndex[key] = current;
                    iterator.remove();
                }
            }
            numberIndexSet.add(current);
        }
        numberIndexSet.forEach(k -> numsIndex[k] = -1);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numsIndex[nums1[i]];
        }
        return nums1;
    }

    public static void main(String[] args) {
        Z2NextBigger test = new Z2NextBigger();
        System.out.println(Arrays.toString(test.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
