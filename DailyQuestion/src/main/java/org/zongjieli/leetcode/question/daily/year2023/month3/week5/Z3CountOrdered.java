package org.zongjieli.leetcode.question.daily.year2023.month3.week5;

/**
 * 给定一个整数 n,请返回长度为 n、仅由元音 (a, e, i, o, u) 组成且按字典序排列的字符串数量
 * 字符串 s 按字典序排列需要满足:
 *  对于所有有效的 i,s[i] 在字母表中的位置总是与 s[i + 1] 相同或在 s[i + 1] 之前
 *
 * 1 <= n <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/29
 */
public class Z3CountOrdered {

    public int countVowelStrings(int n) {
        int[] dp = new int[]{1, 1, 1, 1, 1};
        while (n > 1) {
            dp[0] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            dp[1] = dp[1] + dp[2] + dp[3] + dp[4];
            dp[2] = dp[2] + dp[3] + dp[4];
            dp[3] += dp[4];
            n--;
        }
        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }

}
