package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

/**
 * 给定一个由小写英文字母组成的字符串 s,可以对其执行一些操作
 * 在一步操作中,可以用其他小写英文字母替换 s 中的一个字符
 * 请执行尽可能少的操作,使 s 变成一个回文串
 * 如果执行最少操作次数的方案不止一种,则只需选取字典序最小的方案
 * 对于两个长度相同的字符串 a 和 b,在 a 和 b 出现不同的第一个位置
 * 如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早
 * 则认为 a 的字典序比 b 的字典序要小
 * 返回最终的回文字符串
 *
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/13
 */
public class Z3MinPalindrome {

    public String makeSmallestPalindrome(String s) {
        byte[] values = s.getBytes();
        int start = -1, end = values.length;
        byte a, b;
        while (++start < --end) {
            if ((a = values[start]) < (b = values[end])) {
                values[end] = a;
            } else if (a > b) {
                values[start] = b;
            }
        }
        return new String(values);
    }

}
