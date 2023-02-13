package org.zongjieli.leetcode.competion.singleweekly.order332;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t
 * 可以从字符串 t 中删除任意数目的字符
 * 如果没有从字符串 t 中删除字符,那么得分为 0,否则:
 *  令 left 为删除字符中的最小下标
 *  令 right 为删除字符中的最大下标
 * 字符串的得分为 right - left + 1
 * 请返回使 t 成为 s 子序列的最小得分
 * 一个字符串的子序列是从原字符串中删除一些字符后(也可以一个也不删除)
 * 剩余字符不改变顺序得到的字符串
 * 比方说 "ace" 是 "abcde" 的子序列,但是 "aec" 不是
 *
 * 1 <= s.length, t.length <= 10^5
 * s 和 t 都只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/12
 */
public class O332N4MinScore {

    public int minimumScore(String s, String t) {
        byte[] sValues = s.getBytes(), tValues = t.getBytes();
        int[] temp = new int[26];
        int[][] next = new int[sValues.length + 1][26];
        int[][] before = new int[sValues.length + 2][26];
        for (int i = 0; i < sValues.length; i++) {
            int current = sValues[i] - 'a';
            for (int j = temp[current] ; j < i + 1 ; j++) {
                next[j][current] = i + 1;
            }
            temp[current] = i + 1;
        }
        Arrays.fill(temp, sValues.length + 1);
        for (int i = sValues.length - 1; i >= 0; i--) {
            int current = sValues[i] - 'a';
            for (int j = temp[current] ; j > i + 1 ; j--) {
                before[j][current] = i + 1;
            }
            temp[current] = i + 1;
        }
        int result = tValues.length, ni = 0;
        for (int tds = 0 ; tds < tValues.length ; tds++) {
            if (tds != 0 && (ni = next[ni][tValues[tds - 1] - 'a']) == 0) {
                return result;
            }
            int bi = sValues.length + 1, j = tValues.length - 1;
            for (; j >= tds ; j--) {
                if ((bi = before[bi][tValues[j] - 'a']) <= ni) {
                    result = Math.min(result, j - tds + 1);
                    break;
                }
            }
            if (j == tds - 1) {
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        O332N4MinScore test = new O332N4MinScore();
        // 1
        System.out.println(test.minimumScore("abacaba", "bzaa"));
    }
}
