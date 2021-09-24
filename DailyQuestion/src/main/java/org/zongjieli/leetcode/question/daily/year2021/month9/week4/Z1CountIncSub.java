package org.zongjieli.leetcode.question.daily.year2021.month9.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组,找到最长递增子序列的个数
 *
 * 给定的数组长度不超过 2000 并且结果一定是 32 位有符号整数
 *
 * @author   Li.zongjie
 * @date     2021/9/24
 * @version  1.0
 */
public class Z1CountIncSub {
    public int findNumberOfLIS(int[] nums) {
        // number:[length,count]
        Map<Integer,int[]> count = new HashMap<>();
        for (int num : nums) {
            int[] max = new int[2];
            count.forEach((k,v) -> {
                if (k < num){
                    if (v[0] > max[0]){
                        max[0] = v[0];
                        max[1] = v[1];
                    } else if (v[0] == max[0]){
                        max[1] += v[1];
                    }
                }
            });
            max[0]++;
            int[] get = count.get(num);
            if (max[0] == 1){
                if (get == null){
                    max[1] = 1;
                } else {
                    max[1] = get[1] + 1;
                }
            } else if (get != null && max[0] == get[0]){
                max[1] += get[1];
            }
            count.put(num,max);
        }

        int[] result = new int[2];
        count.forEach((k,v) -> {
            if (v[0] > result[0]){
                result[0] = v[0];
                result[1] = v[1];
            } else if (v[0] == result[0]){
                result[1] += v[1];
            }
        });
        return result[1];
    }


    public static void main(String[] args) {
        Z1CountIncSub test = new Z1CountIncSub();
        System.out.println(test.findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(test.findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(test.findNumberOfLIS(new int[0]));
        System.out.println(test.findNumberOfLIS(new int[]{3,2,1,6,5,4,9,8,7}));
    }
}
