package org.zongjieli.leetcode.question.daily.year2022.month3.week3;
/**
 * 给定一个整数数组 nums,请找出 nums 子集按位或可能得到的最大值
 * 并返回按位或能得到最大值的不同非空子集的数目
 *
 * 如果数组 a 可以由数组 b 删除一些元素(或不删除)得到
 * 则认为数组 a 是数组 b 的一个子集
 * 如果选中的元素下标位置不一样,则认为两个子集不同
 *
 * 对数组 a 执行按位或,结果等于 a[0] OR a[1] OR ... OR a[a.length - 1](下标从 0 开始)
 *
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/3/15
 * @version  1.0
 */
public class Z2BitMaxCount {

    private int max = 0;
    private int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            max |= num;
        }
        cal(nums, 0, 0);
        cal(nums, 0, nums[0]);
        return count >> 1;
    }

    public void cal(int[] nums, int index, int current) {
        if (current == max) {
            count += (1 << nums.length - index);
            return;
        }
        for (int i = index + 1 ; i < nums.length ; i++) {
            cal(nums, i, current | nums[i]);
        }
    }

    public static void main(String[] args) {
        Z2BitMaxCount test = new Z2BitMaxCount();
        // 2
//        System.out.println(test.countMaxOrSubsets(new int[]{3, 1}));
        // 7
//        System.out.println(test.countMaxOrSubsets(new int[]{2, 2, 2}));
        // 1
        System.out.println(test.countMaxOrSubsets(new int[]{1, 2}));
    }
}
