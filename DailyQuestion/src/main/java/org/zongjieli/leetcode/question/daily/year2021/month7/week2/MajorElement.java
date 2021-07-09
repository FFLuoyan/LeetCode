package org.zongjieli.leetcode.question.daily.year2021.month7.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素
 * 给你一个整数数组,找出其中的主要元素
 * 若没有则返回 -1
 * 请设计时间复杂度为 O(N),空间复杂度为 O(1) 的解决方案
 *
 * @author   Zongjie.Li
 * @date     2021/7/9
 * @version  1.0
 */
public class MajorElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        int half = nums.length / 2;
        int[] num = new int[]{-1};
        countMap.entrySet().stream().anyMatch(entry -> {
            if (entry.getValue() > half){
                num[0] = entry.getKey();
                return true;
            }
            return false;
        });
        return num[0];
    }

    /**
     * 摩尔多数投票算法
     *
     * @param  nums Param Description
     * @return  int
     * @author  Zongjie.Li
     * @date    2021/7/9
     * @since   1.0
     */
    public int majorityElementByBoyerMooreMajorityVotingAlgorithm(int[] nums) {
        int count = 0;
        int compare = -1;
        for (int num : nums) {
            if (count == 0){
                compare = num;
            }
            if (num == compare){
                count++;
            } else {
                count--;
            }
        }
        if (count > 0){
            count = 0;
            for (int num : nums) {
                if (num == compare){
                    count++;
                }
            }
            if (count > (nums.length / 2)){
                return compare;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorElement test = new MajorElement();
        System.out.println(test.majorityElement(new int[]{1,1,1,1,3,4,5,6}));
        System.out.println(test.majorityElementByBoyerMooreMajorityVotingAlgorithm(new int[]{1,1,1,1,3,4,5,6}));
    }
}
