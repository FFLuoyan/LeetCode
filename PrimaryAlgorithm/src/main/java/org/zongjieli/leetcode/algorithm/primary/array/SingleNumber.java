package org.zongjieli.leetcode.algorithm.primary.array;
/**
 * 给定一个整数数组,除了某个元素只出现一次以外
 * 其余元素均出现了两次,找出那个只出现了一次的元素
 *
 * @author   Zongjie.Li
 * @date     2021/1/7
 * @version  1.0
 */
public class SingleNumber {
    public int singleNumber(int[] nums){
        int temp = 0;
        for (int num : nums){
            temp ^= num;
        }
        return temp;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] singleNums = new int[]{1,2,5,5,2,1,9};
        System.out.println(singleNumber.singleNumber(singleNums));
    }
}
