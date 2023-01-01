package org.zongjieli.leetcode.question.daily.year2023.month1.week1;

/**
 * 给定一个由小写英文字母组成的字符串 s
 * 请找出并返回第一个出现两次的字母
 * 注意:
 *  如果 a 的第二次出现比 b 的第二次出现在字符串中的位置更靠前,则认为字母 a 在字母 b 之前出现两次
 *  s 包含至少一个出现两次的字母
 *
 * 2 <= s.length <= 100
 * s 由小写英文字母组成
 * s 包含至少一个重复字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/1
 */
public class Z7FirstTwice {

    public char repeatedCharacter(String s) {
        char[] values = s.toCharArray();
        int exist = 0;
        for (char value : values) {
            int position = (1 << (value - 'a'));
            if ((exist & position) > 0) {
                return value;
            }
            exist |= position;
        }
        return 'a';
    }

}
