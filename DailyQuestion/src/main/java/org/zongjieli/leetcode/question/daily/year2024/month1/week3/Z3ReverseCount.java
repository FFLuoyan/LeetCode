package org.zongjieli.leetcode.question.daily.year2024.month1.week3;

/**
 * 给定一个下标从 0 开始的数组 words,数组中包含互不相同的字符串
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件,称它们可以匹配:
 *  字符串 words[i] 等于 words[j] 的反转字符串
 *  0 <= i < j < words.length
 * 请返回数组 words 中的最大匹配数目
 * 注意,每个字符串最多匹配一次
 *
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同
 * words[i] 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/17
 */
public class Z3ReverseCount {

    public int maximumNumberOfStringPairs(String[] words) {
        boolean[][] exists = new boolean[26][26];
        int result = 0;
        for (String word : words) {
            int a = word.charAt(0) - 'a', b = word.charAt(1) - 'a';
            if (exists[b][a]) {
                result++;
            } else {
                exists[a][b] = true;
            }
        }
        return result;
    }

}
