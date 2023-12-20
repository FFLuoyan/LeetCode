package org.zongjieli.leetcode.question.daily.year2023.month12.week4;

import java.util.List;

/**
 * 给定一个字符串数组 words 和一个字符串 s,请判断 s 是不是 words 的首字母缩略词
 * 如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s,则认为 s 是 words 的首字母缩略词
 * 例如,"ab" 可以由 ["apple", "banana"] 形成,但是无法从 ["bear", "aardvark"] 形成
 * 如果 s 是 words 的首字母缩略词,返回 true,否则返回 false
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 10
 * 1 <= s.length <= 100
 * words[i] 和 s 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/20
 */
public class Z3StringStart {

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        char[] starts = s.toCharArray();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != starts[i]) {
                return false;
            }
        }
        return true;
    }

}
