package org.zongjieli.leetcode.question.daily.year2024.month6.week2;

/**
 * 桌子上有 n 个球,每个球的颜色不是黑色就是白色
 * 给定一个长度为 n、下标从 0 开始的二进制字符串 s,其中 1 和 0 分别代表黑色和白色的球
 * 在每一步中,可以选择两个相邻的球并交换它们
 * 返回将所有黑色球都移到右侧,所有白色球都移到左侧所需的最小步数
 *
 * 1 <= n == s.length <= 10^5
 * s[i] 不是 '0' 就是 '1'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/6/6
 */
public class Z4CountSwitch {

    public long minimumSteps(String s) {
        byte[] values = s.getBytes();
        long result = 0, blackCount = 0;
        for (byte value : values) {
            if (value == '1') {
                blackCount++;
            } else {
                result += blackCount;
            }
        }
        return result;
    }

}
