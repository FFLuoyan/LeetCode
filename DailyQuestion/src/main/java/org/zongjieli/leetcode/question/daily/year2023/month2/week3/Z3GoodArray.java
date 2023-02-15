package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

/**
 * 给定一个正整数数组 nums,需要从中任选一些子集
 * 然后将子集中每一个数乘以一个任意整数,并求出他们的和
 * 假如该和结果为 1,那么原数组就是一个好数组,返回 True,否则返回 False
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/15
 */
public class Z3GoodArray {

    public boolean isGoodArray(int[] nums) {
        int common = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((common = common(common, nums[i])) == 1) {
                return true;
            }
        }
        return common == 1;
    }

    public int common(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return common(b, a % b);
    }

    public static void main(String[] args) {
        Z3GoodArray test = new Z3GoodArray();
        // true
        System.out.println(test.isGoodArray(new int[]{6, 10, 15}));
    }
}
