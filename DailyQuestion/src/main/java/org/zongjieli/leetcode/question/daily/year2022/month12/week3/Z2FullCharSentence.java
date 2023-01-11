package org.zongjieli.leetcode.question.daily.year2022.month12.week3;

/**
 * 全字母句指包含英语字母表中每个字母至少一次的句子
 * 给定一个仅由小写英文字母组成的字符串 sentence,请判断 sentence 是否为全字母句
 * 如果是,返回 true,否则返回 false
 *
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z2FullCharSentence {

    public boolean checkIfPangram(String sentence) {
        boolean[] exist = new boolean[26];
        for (byte b : sentence.getBytes()) {
            exist[b - 'a'] = true;
        }
        for (boolean b : exist) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
