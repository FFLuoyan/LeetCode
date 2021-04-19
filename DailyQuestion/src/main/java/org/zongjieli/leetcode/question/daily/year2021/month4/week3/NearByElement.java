package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t
 * 请你判断是否存在两个不同下标 i 和 j
 * 使得 abs(nums[i] - nums[j]) <= t
 * 同时又满足 abs(i - j) <= k
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  0 <= nums.length <= 2 * 10^4
 *  -2^31 <= nums[i] <= 2^31 - 1
 *  0 <= k <= 10^4
 *  0 <= t <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/4/17
 * @version  1.0
 */
public class NearByElement {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> compare = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long e = compare.ceiling(nums[i] - (long) t);
            if (e != null && e <= nums[i] + (long) t){
                return true;
            }
            compare.add((long) nums[i]);
            if (i >= k){
                compare.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NearByElement element = new NearByElement();
        System.out.println(element.containsNearbyAlmostDuplicate(new int[]{1,2},0,1));
        System.out.println(element.containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
        System.out.println(element.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
        System.out.println(element.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},3,2));
        System.out.println(element.containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2));
    }
}
