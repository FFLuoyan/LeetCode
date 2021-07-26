package org.zongjieli.leetcode.question.daily.year2021.month7.week4;
/**
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right
 * 每个 ranges[i] = [startI, endI] 表示一个从 startI 到 endI 的 闭区间
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中至少一个区间覆盖
 * 那么请你返回 true, 否则返回 false
 *
 * 已知区间 ranges[i] = [startI, endI]
 * 如果整数 x 满足 startI <= x <= endI,那么我们称整数 x 被覆盖了
 *
 * 1 <= ranges.length <= 50
 * 1 <= startI <= endI <= 50
 * 1 <= left <= right <= 50
 *
 * @author   Zongjie.Li
 * @date     2021/7/23
 * @version  1.0
 */
public class Z5RangeCover {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 差分数组,通过计算范围的起点和终点,一次遍历得到结果
        // 我们将数组的起点 +1,数组的终点 -1
        // 依次相加所有的范围,大于 0 的,则说明有区间覆盖
        int[] result = new int[52];
        for (int[] range : ranges) {
            result[range[0]]++;
            result[range[1] + 1]--;
        }
        for (int i = 1; i <= right ; i++) {
            result[i] += result[i - 1];
            if (i >= left && result[i] == 0){
                return false;
            }
        }
        return true;
    }
}
