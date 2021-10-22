package org.zongjieli.leetcode.question.daily.year2021.month10.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的整数数组,找出其中所有出现超过 n/3 次的元素
 *
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/10/22
 * @version  1.0
 */
public class MajorNumber {
    public List<Integer> majorityElement(int[] nums) {
        int a = 100000;
        int aCount = 0;
        int b = 100000;
        int bCount = 0;
        for (int num : nums) {
            if (num == a){
                aCount++;
            } else if (num == b){
                bCount++;
            } else if (aCount == 0){
                a = num;
                aCount++;
            } else if (bCount == 0){
                b = num;
                bCount++;
            } else {
                aCount--;
                bCount--;
            }
        }
        List<Integer> result = new ArrayList<>(4);
        int count = 0;
        if (aCount > 0){
            for (int num : nums) {
                if (num == a){
                    count++;
                }
            }
            if (count > nums.length / 3){
                result.add(a);
            }
        }
        count = 0;
        if (bCount > 0){
            for (int num : nums) {
                if (num == b){
                    count++;
                }
            }
            if (count > nums.length / 3){
                result.add(b);
            }
        }
        return result;
    }
}
