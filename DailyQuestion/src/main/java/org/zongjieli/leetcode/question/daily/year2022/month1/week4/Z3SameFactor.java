package org.zongjieli.leetcode.question.daily.year2022.month1.week4;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 判断数组中是否存在两个不同的索引 i 和 j
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k
 * 如果存在,返回 true,否则返回 false
 * <p>
 *  1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/1/19
 */
public class Z3SameFactor {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> value = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i > k){
                value.remove(nums[i - k - 1]);
            }
            if (value.contains(nums[i])){
                return true;
            }
            value.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Z3SameFactor test = new Z3SameFactor();
        System.out.println(test.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}
