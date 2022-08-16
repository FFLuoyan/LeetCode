package org.zongjieli.leetcode.question.daily.year2022.month8.week2;
/**
 * 给定一个由若干 0 和 1 组成的字符串 s
 * 请计算并返回将该字符串分割成两个非空子字符串(即左子字符串和右子字符串)所能获得的最大得分
 * 分割字符串的得分为左子字符串中 0 的数量加上右子字符串中 1 的数量
 *
 * 2 <= s.length <= 500
 * 字符串 s 仅由字符 '0' 和 '1' 组成
 *
 * @author   Li.zongjie
 * @date     2022/8/16
 * @version  1.0
 */
public class Z7MaxScore {
    public int maxScore(String s) {
        int base = '1' - s.charAt(0), compare = 0, mc = 0, mi = s.length() - 1;
        for (int i = 1 ; i < mi ; i++) {
            int c = s.charAt(i) - '0';
            base += c;
            compare += (1 - 2 * c);
            mc = Math.max(compare, mc);
        }
        return base + mc + s.charAt(mi) - '0';
    }
}
