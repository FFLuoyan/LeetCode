package org.zongjieli.leetcode.question.daily.year2021.month11.week2;
/**
 * 在以下情况时,单词的大写用法是正确的:
 *  全部字母都是大写,比如 "USA"
 *  单词中所有字母都不是大写,比如 "leetcode"
 *  如果单词不只含有一个字母,只有首字母大写,比如 "Google"
 *
 * 给定一个字符串 word,如果大写用法正确,返回 true,否则返回 false
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/11/18
 * @version  1.0
 */
public class Z6CheckUpper {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1){
            return true;
        }
        boolean upper = word.charAt(1) < 'a';
        for (int i = 2 ; i < word.length() ; i++){
            boolean currentUpper = word.charAt(i) < 'a';
            if (currentUpper ^ upper){
                return false;
            }
        }
        return !upper || word.charAt(0) < 'a';
    }
}
