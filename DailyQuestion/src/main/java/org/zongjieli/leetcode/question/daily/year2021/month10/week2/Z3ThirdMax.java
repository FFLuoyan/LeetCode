package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

import java.util.Arrays;
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
        Arrays.sort(nums);
        int index = nums.length - 1;
        int max = nums[index];
        while (--index > 0 && nums[index] == max){ }
        if (index <= 0){
            return max;
        }
        int temp = nums[index];
        while (--index >= 0 && nums[index] == temp){ }
        return index < 0 ? max : nums[index];
    }

    public static void main(String[] args) {
        Z3ThirdMax test = new Z3ThirdMax();
//        System.out.println(test.thirdMax(new int[]{2,2,3,1}));
//        System.out.println(test.thirdMax(new int[]{2,2,1}));
        System.out.println(test.thirdMax(new int[]{2,1,1}));
    }
}
