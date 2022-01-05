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
        char[] result = new char[s.length() + 2];
        for (int i = 0 ; i < s.length() ; i++){
            result[i + 1] = s.charAt(i);
        }
        for (int i = 1 ; i < result.length - 1 ; i++){
            result[i] = result[i] == '?' ? result[i - 1] == 'a' ? result[i + 1] == 'b' ? 'c' : 'b' : result[i + 1] == 'a' ? result[i - 1] == 'b' ? 'c' : 'b' : 'a' : result[i];
        }
        return new String(result, 1 , s.length());
    }

}
