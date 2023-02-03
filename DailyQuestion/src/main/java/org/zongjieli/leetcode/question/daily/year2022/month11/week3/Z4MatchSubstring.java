package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

/**
 * 给定字符串 s 和字符串数组 words,返回 words[i] 中是 s 的子序列的单词个数
 * 字符串的子序列是从原始字符串中生成的新字符串
 * 可以从中删去一些字符(可以是 none),而不改变其余字符的相对顺序
 * 例如, "ace" 是 "abcde" 的子序列
 *
 * 1 <= s.length <= 5 * 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/3
 */
public class Z4MatchSubstring {

    public int numMatchingSubseq(String s, String[] words) {
        int wl = words.length;
        int[][] need = new int[26][wl + 1];
        for (int i = 0; i < words.length; i++) {
            int[] charWords = need[words[i].charAt(0) - 'a'];
            charWords[charWords[wl]] = i << 6;
            charWords[wl]++;
        }
        int result = 0;
        for (byte b : s.getBytes()) {
            int index = b - 'a';
            int[] currentNeed = need[index];
            int size = currentNeed[wl];
            currentNeed[wl] = 0;
            for (int i = 0 ; i < size ; i++) {
                int nextWordState = currentNeed[i] + 1, wordIndex = nextWordState >> 6, nextCharIndex = nextWordState & 63;
                String word = words[wordIndex];
                if (word.length() == nextCharIndex) {
                    result++;
                } else {
                    int[] nextNeed = need[word.charAt(nextCharIndex) - 'a'];
                    nextNeed[nextNeed[wl]++] = nextWordState;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4MatchSubstring test = new Z4MatchSubstring();
        // 3
        System.out.println(test.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

}
