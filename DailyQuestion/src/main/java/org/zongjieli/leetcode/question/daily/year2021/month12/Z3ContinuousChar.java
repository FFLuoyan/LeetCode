package org.zongjieli.leetcode.question.daily.year2021.month12;
/**
 * 给定一个字符串 s
 * 字符串的能量定义为
 *  只包含一种字符的最长非空子字符串的长度
 * 请返回字符串的能量
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母
 *
 * @author   Li.zongjie
 * @date     2021/12/1
 * @version  1.0
 */
public class Z3ContinuousChar {
    public int maxPower(String s) {
        int result = 1;
        char currentChar = s.charAt(0);
        int currentCount = 1;
        for (int i = 1 ; i < s.length() ; i++){
            char loop = s.charAt(i);
            if (loop == currentChar){
                currentCount++;
                result = Math.max(result, currentCount);
            } else {
                currentCount = 1;
                currentChar = loop;
            }
        }
        return result;
    }
}
