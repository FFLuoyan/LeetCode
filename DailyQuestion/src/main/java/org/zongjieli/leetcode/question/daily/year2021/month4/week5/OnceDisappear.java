package org.zongjieli.leetcode.question.daily.year2021.month4.week5;

import java.util.TreeMap;

/**
 * 一个整数数组 nums,除某个元素仅出现一次外,其余每个元素都恰出现三次
 * 请找出并返回那个只出现了一次的元素
 *
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/4/30
 * @version  1.0
 */
public class OnceDisappear {
    public int singleNumber(int[] nums) {
        TreeMap<Integer,Boolean> count = new TreeMap<>();
        for (int num : nums) {
            Boolean canDelete = count.get(num);
            if (canDelete == null){
                count.put(num,Boolean.FALSE);
            } else if (canDelete){
                count.remove(num);
            } else {
                count.put(num,Boolean.TRUE);
            }
        }
        return count.firstKey();
    }
}
