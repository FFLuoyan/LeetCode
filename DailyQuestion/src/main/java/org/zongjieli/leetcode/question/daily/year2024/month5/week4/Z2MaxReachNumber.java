package org.zongjieli.leetcode.question.daily.year2024.month5.week4;

/**
 * 给定两个整数 num 和 t
 * 如果整数 x 可以在执行下述操作不超过 t 次的情况下变为与 num 相等,则称其为可达成数字:
 *  每次操作将 x 的值增加或减少 1,同时可以选择将 num 的值增加或减少 1
 *  返回所有可达成数字中的最大值,可以证明至少存在一个可达成数字
 *
 * 1 <= num, t <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/5/21
 */
public class Z2MaxReachNumber {

    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

}
