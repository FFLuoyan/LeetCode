package org.zongjieli.leetcode.question.daily.year2024.month6.week3;

/**
 * 给定两个字符串 a 和 b,请返回这两个字符串中最长的特殊序列的长度,如果不存在则返回 -1
 * 最长特殊序列定义如下:
 *  该序列为某字符串独有的最长子序列(即不能是其他字符串的子序列)
 * 字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串
 * 例如:
 *  "abc" 是 "aebdc" 的子序列,因为删除 "aebdc" 中的 e, b 可以得到 "abc"
 *  "aebdc" 的子序列还包括 "aebdc"、"aeb" 和 "" (空字符串)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/6/16
 */
public class Z7LongestSubsequence {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
