package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

/**
 * 给定一个由不同字符组成的字符串 allowed 和一个字符串数组 words
 * 如果一个字符串的每一个字符都在 allowed 中,就称这个字符串是一致字符串
 * 请返回 words 数组中一致字符串的数目
 *
 * 1 <= words.length <= 10^4
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符互不相同
 * words[i] 和 allowed 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z2CountSameString {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] exists = new boolean[128];
        for (byte b : allowed.getBytes()) {
            exists[b] = true;
        }
        int result = 0;
        a: for (String word : words) {
            for (byte b : word.getBytes()) {
                if (!exists[b]) {
                    continue a;
                }
            }
            result++;
        }
        return result;
    }

}
