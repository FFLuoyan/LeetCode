package org.zongjieli.leetcode.question.daily.year2022.month6.week5;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums,将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
 * 可以假设所有输入数组都可以得到满足题目要求的结果
 *
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证,对于给定的输入 nums,总能产生满足题目要求的结果
 *
 * 用 O(n) 时间复杂度或原地 O(1) 额外空间来实现
 *
 * @author   Li.zongjie
 * @date     2022/6/28
 * @version  1.0
 */
public class Z2SwingOrder {

    public void wiggleSort(int[] nums) {
        int[] count = new int[5001];
        for (int num : nums) {
            count[num]++;
        }
        int ci = 5000;
        /*
            对于符合条件的数组,设数组的长度为 l
            对数组进行排序,得到 nums
            则要求数组中相同的元素数量不超过 x
            其中当 l 为偶数时, x = l / 2
            当 l 为奇数时, x = (l + 1) / 2
            如果元素数量超过 x,则必定会有相同元素相邻
            无法得出结果
            对于数组长度为偶数的数组
            则有 num[i] < num[i + x]
            可以形成排列 nums[x], nums[0], nums[x + 1],...,nums[l - 1], nums[x - 1]
            对于数组长度为奇数的数组
            已知 nums[0] 为数组中最小值
            如果 nums[0] == nums[x - 1]
            则 nums[0] == nums[1] ==...== nums[x - 1] < nums[x]
            则结果应为 nums[0], nums[x], nums[1],..., nums[l - 1], nums[x - 1]
            如果 nums[0] != nums[x - 1], 而存在 nums[i] == nums[i + x - 1]
            要使所有 nums[i], nums[i + 1],..., nums[i + x - 1] 不相邻
            则所有 nums[i + k] 应在结果数组中的偶数位上
            而对于 nums[0] < nums[i + k], nums[0] 在所有奇数位上都无法满足条件
            所以当 i != 0 时,nums[i] < nums[i + x - 1]
            所以按照 nums[0], nums[x], nums[1], ..., nums[l - 1], nums[x - 1] 排列
            结果必然满足要求
         */
        for (int i = 1 ; i < nums.length ; i += 2) {
            while (count[ci] == 0) {
                ci--;
            }
            nums[i] = ci;
            count[ci]--;
        }
        for (int i = 0 ; i < nums.length ; i += 2) {
            while (count[ci] == 0) {
                ci--;
            }
            nums[i] = ci;
            count[ci]--;
        }
    }

    public static void main(String[] args) {
        Z2SwingOrder test = new Z2SwingOrder();
        int[] e1 = new int[]{1, 1, 1, 4, 5, 6};
        test.wiggleSort(e1);
        System.out.println(Arrays.toString(e1));
    }

}
