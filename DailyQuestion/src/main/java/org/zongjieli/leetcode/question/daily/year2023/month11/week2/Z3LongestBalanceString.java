package org.zongjieli.leetcode.question.daily.year2023.month11.week2;

/**
 * 给定一个仅由 0 和 1 组成的二进制字符串 s
 * 如果子字符串中所有的 0 都在 1 之前且其中 0 的数量等于 1 的数量
 * 则认为 s 的这个子字符串是平衡子字符串
 * 请注意,空子字符串也视作平衡子字符串
 * 返回 s 中最长的平衡子字符串长度
 * 子字符串是字符串中的一个连续字符序列
 *
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/8
 */
public class Z3LongestBalanceString {

    public int findTheLongestBalancedSubstring(String s) {
        String subString = "";
        while (s.contains(subString)) {
            subString = "0" + subString + "1";
        }
        return subString.length() - 2;
    }

}
