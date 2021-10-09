package org.zongjieli.leetcode.question.daily.year2021.month10.week2;
/**
 * 统计字符串中的单词个数,这里的单词指的是连续的不是空格的字符
 * 可以假定字符串里不包括任何不可打印的字符
 *
 * @author   Li.zongjie
 * @date     2021/10/9
 * @version  1.0
 */
public class Z4WordsCount {
    public int countSegments(String s) {
        int result = 0;
        boolean newWord = true;
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == ' '){
                newWord = true;
            } else if (newWord){
                result++;
                newWord = false;
            }
        }
        return result;
    }
}
