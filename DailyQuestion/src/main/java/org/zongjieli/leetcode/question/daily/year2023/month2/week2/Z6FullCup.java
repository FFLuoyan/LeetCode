package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

/**
 * 现有一台饮水机,可以制备冷水、温水和热水
 * 每秒钟可以装满 2 杯不同类型的水或者 1 杯任意类型的水
 * 给定一个下标从 0 开始、长度为 3 的整数数组 amount
 * 其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量
 * 返回装满所有杯子所需的最少秒数
 *
 * amount.length == 3
 * 0 <= amount[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/11
 */
public class Z6FullCup {

    public int fillCups(int[] amount) {
        int max = amount[0], sum = max;
        sum = sum + amount[1] + amount[2];
        max = Math.max(max, Math.max(amount[1], amount[2]));
        return max <= sum / 2 ? (sum + 1) / 2 : max;
    }

}
