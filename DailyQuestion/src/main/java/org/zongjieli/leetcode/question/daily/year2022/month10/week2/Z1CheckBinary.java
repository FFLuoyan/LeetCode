package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

/**
 * 给定一个二进制字符串 s,该字符串不含前导零
 * 如果 s 包含零个或一个由连续的 '1' 组成的字段,返回 true​​​,否则返回 false
 * 如果 s 中由连续若干个 '1' 组成的字段数量不超过 1,返回 true​​​,否则返回 false
 *
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 *
 * @author   Li.zongjie
 * @date     2022/10/21
 * @version  1.0
 */
public class Z1CheckBinary {

    public boolean checkOnesSegment(String s) {
        int ci = 0;
        while (ci < s.length() && s.charAt(ci) == '1') {
            ci++;
        }
        if (ci == s.length()) {
            return true;
        }
        while (ci < s.length() && s.charAt(ci) == '0') {
            ci++;
        }
        return ci == s.length();
    }
}
