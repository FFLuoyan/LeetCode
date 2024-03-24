package org.zongjieli.leetcode.question.daily.year2024.month3.week4;

import java.util.*;

/**
 * 给定一个整数数组 coins 表示不同面额的硬币,以及一个整数 amount 表示总金额
 * 计算并返回可以凑成总金额所需的最少的硬币个数
 * 如果没有任何一种硬币组合能组成总金额,返回 -1
 * 可以认为每种硬币的数量是无限的
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/24
 */
public class Z7CoinSum {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int length = 0;
        while (length < coins.length && coins[length] <= amount) {
            length++;
        }
        if (length == 0) {
            return -1;
        }
        List<Integer> loopValues = new ArrayList<>();
        loopValues.add(0);
        boolean[] existValue = new boolean[amount + 1];
        int currentSum = 0;
        while (!loopValues.isEmpty()) {
            currentSum++;
            List<Integer> next = new ArrayList<>();
            for (Integer loopValue : loopValues) {
                for (int i = 0; i < length; i++) {
                    int cal = loopValue + coins[i];
                    if (cal <= amount && !existValue[cal]) {
                        next.add(cal);
                        existValue[cal] = true;
                    }
                }
            }
            if (existValue[amount]) {
                return currentSum;
            }
            loopValues = next;
        }
        return -1;
    }

}
