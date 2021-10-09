package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 给定一个非空数组,返回此数组中第三大的数
 * 如果不存在,则返回数组中最大的数
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/10/9
 * @version  1.0
 */
public class Z3ThirdMax {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> save = new TreeSet<>();
        for (int num : nums) {
            save.add(num);
        }
        Integer max = save.last();
        if (max == null){
            return 0;
        }
        Integer second = save.lower(max);
        if (second == null){
            return max;
        }
        Integer third = save.lower(second);
        if (third == null){
            return max;
        }
        return third;
    }
}
