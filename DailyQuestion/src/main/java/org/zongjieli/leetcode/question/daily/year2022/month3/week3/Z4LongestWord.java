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
        String result = "";
        LinkedList<String> save = new LinkedList<>();
        Set<String> all = new HashSet<>(Arrays.asList(words));
        for (char c = 'a' ; c <= 'z' ; c++) {
            String current = String.valueOf(c);
            if (all.contains(current)) {
                save.addLast(current);
            }
        }
        while (!save.isEmpty()) {
            result = save.getFirst();
            int size = save.size();
            for (int i = 0 ; i < size ; i++) {
                String temp = save.pollFirst();
                for (char c = 'a' ; c <= 'z' ; c++) {
                    String current = temp + c;
                    if (all.contains(current)) {
                        save.addLast(current);
                    }
                }
            }
        }
        return result;
    }
}
