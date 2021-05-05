package org.zongjieli.leetcode.question.daily.year2021.month5.week2;
/**
 * 给定一个整数数组 nums,可以对它进行一些操作
 *
 * 每次操作中,选择任意一个 nums[i]
 * 删除它并获得 nums[i] 的点数,
 * 之后,必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素
 *
 * 开始时拥有 0 个点数,返回能通过这些操作获得的最大点数
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author   Zongjie.Li
 * @date     2021/5/5
 * @version  1.0
 */
public class PointCount {
    public int deleteAndEarn(int[] nums) {
        int[] save = new int[1001];
        for (int num : nums) {
            save[num] += num;
        }
        int nextCan = 0;
        int nextWait = 0;
        for (int num : save) {
            int temp = nextWait;
            nextWait = nextCan + num;
            nextCan = Math.max(nextCan,temp);
        }
        return Math.max(nextCan,nextWait);
    }

    public static void main(String[] args) {
        PointCount test = new PointCount();
        // 0 0 1 1 5 6 7 10
        System.out.println(test.deleteAndEarn(new int[]{6,1,0,1,7,0,10,5}));
    }
}
