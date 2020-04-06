package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * @ClassName: OnceAppear
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/22
 * @Version: 1.0
 **/
public class OnceAppear {
    public static int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1 ; i < nums.length ; i ++) {
            single ^= nums[i];
        }
        return single;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,2};
        System.out.println(singleNumber(nums));
    }
}
