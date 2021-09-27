package org.zongjieli.leetcode.origin.year2021.month9;
/**
 *
 * 给定两个字符串 text1 和 text2,返回这两个字符串的最长公共子序列的长度
 * 如果不存在公共子序列,返回 0
 *
 * 一个字符串的子序列是指这样一个新的字符串:
 *  由原字符串在不改变字符的相对顺序的情况下删除某些字符(也可以不删除任何字符)后组成的新字符串
 *
 * 例如,"ace" 是 "abcde" 的子序列,但 "aec" 不是 "abcde" 的子序列
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class LongestCommonSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] value = new int[length1 + 1][length2 + 1];
        for (int i = 0 ; i < length1 ; i++){
            char c1 = text1.charAt(i);
            for (int j = 0 ; j < length2 ; j++){
                char c2 = text2.charAt(j);
                value[i + 1][j + 1] = c1 == c2 ? value[i][j] + 1 : Math.max(value[i + 1][j],value[i][j + 1]);
            }
        }
        return value[length1][length2];
    }


}
