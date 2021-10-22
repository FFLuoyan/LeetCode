package org.zongjieli.leetcode.question.daily.year2021.month10.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组,找出其中所有出现超过 n/3 次的元素
 *
 * 1 <= nums.length <= 5 * 104
 * -10^9 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/10/22
 * @version  1.0
 */
public class MajorNumber {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>(2 * nums.length);
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        int max = nums.length / 3;
        List<Integer> result = new ArrayList<>(4);
        countMap.forEach((k,v) -> {
            if (v > max){
                result.add(k);
            }
        });
        return result;
    }
}
