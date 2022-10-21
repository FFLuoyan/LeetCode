package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

/**
 * 只有满足下面几点之一,括号字符串才是有效的:
 *  它是一个空字符串
 *  或者它可以被写成 AB(A 与 B 连接),其中 A 和 B 都是有效字符串
 *  或者它可以被写作 (A),其中 A 是有效字符串
 * 给定一个括号字符串 s,移动 N 次,就可以在字符串的任何位置插入一个括号
 * 例如,如果 s = "()))",可以插入一个开始括号为 "(()))" 或结束括号为 "())))"
 * 返回为使结果字符串 s 有效而必须添加的最少括号数
 *
 * 1 <= s.length <= 1000
 * s 只包含 '(' 和 ')' 字符
 *
 * @author   Li.zongjie
 * @date     2022/10/21
 * @version  1.0
 */
public class Z2EffectBracket {

    public int minAddToMakeValid(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (--count < 0) {
                count++;
                result++;
            }
        }
        return result + count;
    }
}
