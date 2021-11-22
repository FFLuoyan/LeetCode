package org.zongjieli.leetcode.question.daily.year2021.month11.week4;

import java.util.Random;

/**
 * 给定一个整数数组 nums,设计算法来打乱一个没有重复元素的数组
 * 实现 Solution class:
 *  Solution(int[] nums) 使用整数数组 nums 初始化对象
 *  int[] reset() 重设数组到它的初始状态并返回
 *  int[] shuffle() 返回数组随机打乱后的结果
 *
 * 1 <= nums.length <= 200
 * -10^6 <= nums[i] <= 10^6
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 10^4 次 reset 和 shuffle
 *
 * @author   Li.zongjie
 * @date     2021/11/22
 * @version  1.0
 */
public class Z1ShuffleArray {

    private int[] v;
    private int[] shuffle;
    private Random random = new Random();

    public Z1ShuffleArray(int[] nums) {
        v = nums;
        shuffle = new int[nums.length];
        System.arraycopy(nums, 0, shuffle, 0, nums.length);
    }

    public int[] reset() {
        return v;
    }

    public int[] shuffle() {
        for (int i = 0 ; i < shuffle.length ; i++){
            int change = random.nextInt(shuffle.length - i) + i;
            int temp = shuffle[change];
            shuffle[change] = shuffle[i];
            shuffle[i] = temp;
        }
        return shuffle;
    }
}
