package org.zongjieli.leetcode.competion.singleweekly.order258;
/**
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch,找出 ch 第一次出现的下标 i
 * 反转 word 中从下标 0 开始、直到下标 i 结束(含下标 i)的那段字符
 * 如果 word 中不存在字符 ch,则无需进行任何操作
 *
 * 例如,如果 word = "abcdefd" 且 ch = "d"
 * 那么你应该反转从下标 0 开始、直到下标 3 结束(含下标 3)
 * 结果字符串将会是 "dcbaefd"
 * 返回结果字符串
 *
 * 1 <= word.length <= 250
 * word 由小写英文字母组成
 * ch 是一个小写英文字母
 *
 * @author   Li.zongjie
 * @date     2021/9/12
 * @version  1.0
 */
public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        char[] wordChars = new char[word.length()];
        int index = word.indexOf(ch);
        if (index == -1){
            return word;
        }
        for (int i = index + 1 ; i < wordChars.length ; i++){
            wordChars[i] = word.charAt(i);
        }
        for (int i = index ; i >= 0 ; i--){
            wordChars[i] = word.charAt(index - i);
        }
        return new String(wordChars);
    }

}
