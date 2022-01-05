package org.zongjieli.leetcode.question.daily.year2022.month1.week2;
/**
 * 给定一个仅包含小写英文字母和 '?' 字符的字符串 s
 * 请将所有的 '?' 转换为若干小写字母,使最终的字符串不包含任何连续重复的字符
 * 注意: 不能修改非 '?' 字符
 * 题目测试用例保证除 '?' 字符之外,不存在连续重复的字符
 * 在完成所有转换(可能无需转换)后返回最终的字符串
 * 如果有多个解决方案,请返回其中任何一个
 * 可以证明,在给定的约束条件下,答案总是存在的
 *
 * 1 <= s.length <= 100
 * s 仅包含小写英文字母和 '?' 字符
 *
 * @author   Li.zongjie
 * @date     2022/1/5
 * @version  1.0
 */
public class Z3ReplaceQuestionMark {
    public String modifyString(String s) {
        int length = s.length();
        char[] result = new char[length];
        char before, current, after;
        for (int i = 0 ; i < length ; i++){
            before = i == 0 ? ' ' : result[i - 1];
            current = s.charAt(i);
            after = i == length - 1 ? ' ' : s.charAt(i + 1);
            result[i] = current == '?' ? before == 'a' ? after == 'b' ? 'c' : 'b' : after == 'a' ? before == 'b' ? 'c' : 'b' : 'a' : current;
        }
        return new String(result);
    }

}
