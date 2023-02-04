package org.zongjieli.leetcode.question.daily.year2023.month2.week1;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组 coins
 * 它代表拥有的 n 个硬币
 * 第 i 个硬币的值为 coins[i]
 * 如果从这些硬币中选出一部分硬币
 * 它们的和为 x,那么称可以构造出 x
 * 请返回从 0 开始(包括 0),最多能构造出多少个连续整数
 *
 * coins.length == n
 * 1 <= n <= 4 * 10^4
 * 1 <= coins[i] <= 4 * 10^4
 * 可能有多个相同值的硬币
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/4
 */
public class Z6MaxContinue {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 1;
        for (int coin : coins) {
            if (coin > max) {
                return max;
            }
            max += coin;
        }
        return max;
    }

}
