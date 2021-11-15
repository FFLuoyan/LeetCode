package org.zongjieli.leetcode.question.daily.year2021.month11.week3;
/**
 * 初始时有 n 个灯泡处于关闭状态
 * 第一轮会打开所有灯泡
 * 接下来的第二轮将会每两个灯泡关闭一个
 * 第三轮每三个灯泡就切换一个灯泡的开关(即打开变关闭,关闭变打开)
 * 第 i 轮每 i 个灯泡就切换一个灯泡的开关
 * 直到第 n 轮,只需要切换最后一个灯泡的开关
 *
 * 找出并返回 n 轮后有多少个亮着的灯泡
 *
 * 0 <= n <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/11/15
 * @version  1.0
 */
public class Z1SwitchLight {
    public int bulbSwitch(int n) {
        // 查找每个数有多少个因子,因子为奇数则亮
        return (int) Math.sqrt(n);
    }
}
