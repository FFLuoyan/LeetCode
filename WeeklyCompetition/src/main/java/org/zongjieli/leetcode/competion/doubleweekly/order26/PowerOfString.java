package org.zongjieli.leetcode.competion.doubleweekly.order26;

/**
 * @ClassName: PowerOfString
 * @Description: 给定一个字符串 s,返回字符串的能量
 * 字符串的能量定义为:只包含一种字符的最长非空子字符串的长度
 * @Author: Zongjie.Li
 * @Date: 2020/5/16
 * @Version: 1.0
 **/
public class PowerOfString {
    public int maxPower(String s) {
        char compare = 'A';
        int maxLength = 0;
        int length = 1;
        for (int i = 0; i < s.length(); i++) {
            char charGet = s.charAt(i);
            if (charGet == compare) {
                length++;
            } else {
                maxLength = maxLength > length ? maxLength : length;
                compare = charGet;
                length = 1;
            }
        }
        return maxLength > length ? maxLength : length;
    }
}
