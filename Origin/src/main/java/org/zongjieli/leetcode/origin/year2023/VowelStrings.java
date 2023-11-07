package org.zongjieli.leetcode.origin.year2023;

/**
 * 给定一个下标从 0 开始的字符串数组 words 和两个整数: left 和 right
 * 如果字符串以元音字母开头并以元音字母结尾,那么该字符串就是一个元音字符串
 * 其中元音字母是 'a'、'e'、'i'、'o'、'u'
 * 返回 words[i] 是元音字符串的数目,其中 i 在闭区间 [left, right] 内
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 10
 * words[i] 仅由小写英文字母组成
 * 0 <= left <= right < words.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/7
 */
public class VowelStrings {

    private static final boolean[] VOWELS = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false};

    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        while (left <= right) {
            String word = words[left];
            if (VOWELS[word.charAt(0)] && VOWELS[word.charAt(word.length() - 1)]) {
                result++;
            }
            left++;
        }
        return result;
    }

}
