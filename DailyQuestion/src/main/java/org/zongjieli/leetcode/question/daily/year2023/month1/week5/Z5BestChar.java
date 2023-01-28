package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 给定一个由英文字母组成的字符串 s,请找出并返回 s 中的最好英文字母
 * 返回的字母必须为大写形式,如果不存在满足条件的字母,则返回一个空字符串
 * 最好英文字母的大写和小写形式必须都在 s 中出现
 * 英文字母 b 比另一个英文字母 a 更好的前提是: 英文字母表中,b 在 a 之后出现
 *
 * 1 <= s.length <= 1000
 * s 由小写和大写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/28
 */
public class Z5BestChar {

    public String greatestLetter(String s) {
        for(char c = 'Z'; c >= 'A'; c--){
            if(s.indexOf(c) > -1 && s.indexOf(c + 32) > -1){
                return String.valueOf(c);
            }
        }
        return "";
    }

}
