package org.zongjieli.leetcode.question.daily.year2022.month12.week3;

/**
 * 给定一个长度为 n 的二维整数数组 groups,同时给定一个整数数组 nums
 * 判断是否可以从 nums 中选出 n 个不相交的子数组,使得第 i 个子数组与 groups[i](下标从 0 开始)完全相同
 * 且如果 i > 0,那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面
 * 也就是说,这些子数组在 nums 中出现的顺序需要与 groups 顺序相同
 * 如果可以找出这样的 n 个子数组,请返回 true,否则返回 false
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组,就称这些子数组是不相交的
 * 子数组指的是原数组中连续元素组成的一个序列
 *
 * groups.length == n
 * 1 <= n <= 10^3
 * 1 <= groups[i].length, sum(groups[i].length) <= 10^3
 * 1 <= nums.length <= 10^3
 * -10^7 <= groups[i][j], nums[k] <= 10^7
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/29
 */
public class Z6FindSubArray {

    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for (int[] group : groups) {
            int gi = 0, cni = index;
            while (gi < group.length && cni < nums.length) {
                if (group[gi] != nums[cni]) {
                    index++;
                    cni = index;
                    gi = 0;
                } else {
                    gi++;
                    cni++;
                }
            }
            if (gi != group.length && cni == nums.length) {
                return false;
            }
            index = cni;
        }
        return true;
    }

}
