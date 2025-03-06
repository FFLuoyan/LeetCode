package org.zongjieli.leetcode.question.daily.year2025.month3.week2;


/**
 * 给定一个由小写英文字母组成的回文字符串 palindrome
 * 请将其中一个字符用任意小写英文字母替换,使得结果字符串的字典序最小,且不是回文串
 * 请返回结果字符串,如果无法做到,则返回一个空串
 * 如果两个字符串长度相同,那么字符串 a 字典序比字符串 b 小可以这样定义:
 *  在 a 和 b 出现不同的第一个位置上,字符串 a 中的字符严格小于 b 中的对应字符
 *  例如,"abcc” 字典序比 "abcd" 小,因为不同的第一个位置是在第四个字符,显然 'c' 比 'd' 小
 *
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/5
 */
public class Z3BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        byte[] values = palindrome.getBytes();
        for (int i = 0; i < values.length / 2; i++) {
            if (values[i] != 'a') {
                values[i] = 'a';
                return new String(values);
            }
        }
        values[values.length - 1] = 'b';
        return new String(values);
    }

}
