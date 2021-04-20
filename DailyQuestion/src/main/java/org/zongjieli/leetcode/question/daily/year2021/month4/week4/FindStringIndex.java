package org.zongjieli.leetcode.question.daily.year2021.month4.week4;
/**
 * 给你两个字符串 haystack 和 needle
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置(下标从 0 开始)
 * 如果不存在则返回  -1
 *
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author   Zongjie.Li
 * @date     2021/4/20
 * @version  1.0
 */
public class FindStringIndex {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
