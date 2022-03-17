package org.zongjieli.leetcode.question.daily.year2022.month3.week3;

import java.util.*;

/**
 * 给出一个字符串数组 words 组成的一本英语词典
 * 返回 words 中最长的一个单词,该单词是由 words 词典中其他单词逐步添加一个字母组成
 * 若其中有多个可行的答案,则返回答案中字典序最小的单词,若无答案则返回空字符串
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母
 *
 * @author   Li.zongjie
 * @date     2022/3/17
 * @version  1.0
 */
public class Z4LongestWord {

    public String longestWord(String[] words) {
        Set<String> all = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> {
            int aSize = a.length();
            int bSize = b.length();
            if (aSize != bSize) {
                return Integer.compare(bSize, aSize);
            }
            return a.compareTo(b);
        });
        for (String word : words) {
            String current = word;
            while (current.length() > 0) {
                if (!all.contains(current)) {
                    break;
                }
                current = current.substring(0, current.length() - 1);
            }
            if (current.length() == 0) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Z4LongestWord test = new Z4LongestWord();
        System.out.println(test.longestWord(new String[]{"a","ab","abc","abcd"}));
    }
}
