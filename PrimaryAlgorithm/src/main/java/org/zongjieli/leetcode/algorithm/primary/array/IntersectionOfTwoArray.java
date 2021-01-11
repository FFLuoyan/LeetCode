package org.zongjieli.leetcode.algorithm.primary.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个数组,编写一个函数来计算他们的交集
 *
 * @author   Zongjie.Li
 * @date     2021/1/11
 * @version  1.0
 */
public class IntersectionOfTwoArray {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> array = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j< nums2.length;){
            if (nums1[i] == nums2[j]){
                array.add(nums1[i++]);
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[array.size()];
        for (int i = 0 ; i < result.length ; i++){
            result[i] = array.get(i);
        }
        return result;
    }

}
