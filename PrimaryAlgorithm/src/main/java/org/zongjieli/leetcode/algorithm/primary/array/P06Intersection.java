package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.*;

/**
 * 给定两个数组,编写一个函数来计算他们的交集
 *
 * @author   Zongjie.Li
 * @date     2021/1/11
 * @version  1.0
 */
public class P06Intersection {

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

    public static void main(String[] args) {
        P06Intersection test = new P06Intersection();
        int[] nums1 = new int[]{1,5,8,2,0,3,6,5,2,2,2,2,4,7};
        int[] nums2 = new int[]{0,0,0,8,5,4,7,7,7,8,5,5,5,5,2,3,6};
        System.out.println(Arrays.toString(test.intersect(nums1,nums2)));
    }
}
