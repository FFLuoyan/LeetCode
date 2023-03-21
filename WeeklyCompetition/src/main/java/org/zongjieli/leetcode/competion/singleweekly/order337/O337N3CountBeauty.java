package org.zongjieli.leetcode.competion.singleweekly.order337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个由正整数组成的数组 nums 和一个正整数 k
 * 如果 nums 的子集中,任意两个整数的绝对差均不等于 k,则认为该子数组是一个美丽子集
 * 返回数组 nums 中非空且美丽的子集数目
 * nums 的子集定义为:
 *  可以经由 nums 删除某些元素(也可能不删除)得到的一个数组
 *  只有在删除元素时选择的索引不同的情况下,两个子集才会被视作是不同的子集
 *
 * 1 <= nums.length <= 20
 * 1 <= nums[i], k <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/19
 */
public class O337N3CountBeauty {
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> sames = new ArrayList<>();
        int[] exists = new int[1001];
        Arrays.fill(exists, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            exists[num] = i;
            if (num - k >= 0 && exists[num - k] != -1) {
                sames.add((1 << i) + (1 << exists[num - k]));
            }
            if (num + k <= 1000 && exists[num + k] != -1) {
                sames.add((1 << i) + (1 << exists[num + k]));
            }
        }
        int result = 0, max = (1 << nums.length) - 1;
        a: for (int i = 1 ; i <= max ; i++) {
            for (Integer same : sames) {
                if ((i & same) == same) {
                    continue a;
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        O337N3CountBeauty test = new O337N3CountBeauty();
        System.out.println(test.beautifulSubsets(new int[]{1,2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 1));
    }
}
