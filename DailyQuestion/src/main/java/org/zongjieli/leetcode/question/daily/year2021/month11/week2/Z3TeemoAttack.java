package org.zongjieli.leetcode.question.daily.year2021.month11.week2;
/**
 * 在英雄联盟的世界中,有一个叫提莫的英雄
 * 他的攻击可以让敌方英雄艾希进入中毒状态
 * 当提莫攻击艾希,艾希的中毒状态正好持续 duration 秒
 * 正式地讲,提莫在 t 发起发起攻击
 * 意味着艾希在时间区间 [t, t + duration - 1]处于中毒状态
 * 如果提莫在中毒影响结束前再次攻击,中毒状态计时器将会重置
 * 在新的攻击之后,中毒影响将会在 duration 秒后结束
 * 给定一个非递减的整数数组 timeSeries
 * 其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击
 * 以及一个表示中毒持续时间的整数 duration
 * 返回艾希处于中毒状态的总秒数
 *
 * 1 <= timeSeries.length <= 10^4
 * 0 <= timeSeries[i], duration <= 10^7
 * timeSeries 按 非递减 顺序排列
 *
 * @author   Li.zongjie
 * @date     2021/11/10
 * @version  1.0
 */
public class Z3TeemoAttack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = duration;
        for (int i = 1 ; i < timeSeries.length ; i++){
            result += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return result;
    }
}
