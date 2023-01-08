package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 给定一个字符串数组 words 和一个字符串 pref
 * 返回 words 中以 pref 作为前缀的字符串的数目
 * 字符串 s 的前缀就是  s 的任一前导连续字符串
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length, pref.length <= 100
 * words[i] 和 pref 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/8
 */
public class Z7CountPre {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

}
