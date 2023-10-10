package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些机器人分布在一条无限长的数轴上,他们初始坐标用一个下标从 0 开始的整数数组 nums 表示
 * 当给机器人下达命令时,它们以每秒钟一单位的速度开始移动
 * 给定一个字符串 s,每个字符按顺序分别表示每个机器人移动的方向
 * 'L' 表示机器人往左或者数轴的负方向移动,'R' 表示机器人往右或者数轴的正方向移动
 * 当两个机器人相撞时,它们开始沿着原本相反的方向移动
 * 请返回指令重复执行 d 秒后,所有机器人之间两两距离之和
 * 由于答案可能很大,请将答案对 10^9 + 7 取余后返回
 * 注意:
 *  对于坐标在 i 和 j 的两个机器人,(i,j) 和 (j,i) 视为相同的坐标对,也就是说,机器人视为无差别的
 *  当机器人相撞时,它们立即改变它们的前进方向,这个过程不消耗任何时间
 *  当两个机器人在同一时刻占据相同的位置时,就会相撞
 * 例如:
 *  如果一个机器人位于位置 0 并往右移动,另一个机器人位于位置 2 并往左移动
 *  下一秒,它们都将占据位置 1,并改变方向
 *  再下一秒钟后,第一个机器人位于位置 0 并往左移动,而另一个机器人位于位置 2 并往右移动
 *  如果一个机器人位于位置 0 并往右移动,另一个机器人位于位置 1 并往左移动
 *  下一秒,第一个机器人位于位置 0 并往左行驶,而另一个机器人位于位置 1 并往右移动
 *
 * 2 <= nums.length <= 10^5
 * -2 * 10^9 <= nums[i] <= 2 * 10^9
 * 0 <= d <= 10^9
 * nums.length == s.length
 * s 只包含 'L' 和 'R'
 * nums[i] 互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/10
 */
public class Z2RobotMove {

    public int sumDistance(int[] nums, String s, int d) {
        long[] position = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            position[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -1 : 1) * d;
        }
        Arrays.sort(position);
        long result = 0, last = 0;
        for (int i = 1; i < position.length; i++) {
            last += (position[i] - position[i - 1]) * i;
            result += last;
            result %= 1000000007;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Z2RobotMove test = new Z2RobotMove();
        // 8
        System.out.println(test.sumDistance(new int[]{-2, 0, 2}, "RLL", 3));
    }

}
