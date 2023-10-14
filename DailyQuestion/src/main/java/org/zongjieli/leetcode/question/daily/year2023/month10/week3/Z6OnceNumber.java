package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

/**
 * 给定一个非空整数数组 nums,除了某个元素只出现一次以外,其余每个元素均出现两次,找出那个只出现了一次的元素
 * 必须设计并实现线性时间复杂度的算法来解决此问题,且该算法只使用常量额外空间
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/14
 */
public class Z6OnceNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
