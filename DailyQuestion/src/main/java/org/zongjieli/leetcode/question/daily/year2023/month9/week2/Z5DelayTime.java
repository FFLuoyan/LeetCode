package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

/**
 * 给定一个正整数 arrivalTime 表示列车正点到站的时间(单位: 小时)
 * 另给定一个正整数 delayedTime 表示列车延误的小时数
 * 返回列车实际到站的时间
 * 注意,时间采用 24 小时制
 *
 * 1 <= arrivalTime < 24
 * 1 <= delayedTime <= 24
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/8
 */
public class Z5DelayTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
