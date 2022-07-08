package org.zongjieli.leetcode.question.daily.year2022.month7.week2;
/**
 * 有 n 个筹码,第 i 个筹码的位置是 position[i]
 * 需要把所有筹码移到同一个位置
 * 在一步中,可以将第 i 个筹码的位置从 position[i] 改变为:
 *  position[i] + 2 或 position[i] - 2,此时 cost = 0
 *  position[i] + 1 或 position[i] - 1,此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的最小代价
 *
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/7/8
 * @version  1.0
 */
public class Z5MoveChip {

    public int minCostToMoveChips(int[] position) {
        int[] count = new int[2];
        for (int i : position) {
            count[i & 1]++;
        }
        return Math.min(count[0], count[1]);
    }
}
