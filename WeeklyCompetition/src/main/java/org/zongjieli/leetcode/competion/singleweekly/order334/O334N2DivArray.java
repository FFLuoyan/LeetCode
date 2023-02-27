package org.zongjieli.leetcode.competion.singleweekly.order334;

/**
 * 给定一个下标从 0 开始的字符串 word,长度为 n,由从 0 到 9 的数字组成,另给定一个正整数 m
 * word 的可整除数组 div 是一个长度为 n 的整数数组,并满足:
 *  如果 word[0,...,i] 所表示的数值能被 m 整除,div[i] = 1,否则 div[i] = 0
 * 返回 word 的可整除数组
 *
 * 1 <= n <= 10^5
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/26
 */
public class O334N2DivArray {

    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        long value = 0;
        for (int i = 0 ; i < word.length() ; i++) {
            value = value * 10 + (word.charAt(i) - '0');
            value = value % m;
            if (value == 0) {
                result[i] = 1;
            }
        }
        return result;
    }

}
