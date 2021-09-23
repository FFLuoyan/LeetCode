package org.zongjieli.leetcode.question.daily.year2021.month9.week4;
/**
 * 给定一个字符串 s,由若干单词组成,单词前后用一些空格字符隔开
 * 返回字符串中最后一个单词的长度
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串
 *
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * @author   Li.zongjie
 * @date     2021/9/23
 * @version  1.0
 */
public class Z2LastWordLength {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' '){
            index--;
        }
        int start = index;
        while (--index >= 0 && s.charAt(index) != ' '){}
        return start - index;
    }

    public static void main(String[] args) {
        Z2LastWordLength test = new Z2LastWordLength();
        System.out.println(test.lengthOfLastWord("asd"));
        System.out.println(test.lengthOfLastWord(" asd "));
        System.out.println(test.lengthOfLastWord(" asd y"));
    }
}
