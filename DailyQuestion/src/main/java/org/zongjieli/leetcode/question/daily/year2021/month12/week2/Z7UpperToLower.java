package org.zongjieli.leetcode.question.daily.year2021.month12.week2;
/**
 * 给定一个字符串 s,将该字符串中的大写字母转换成相同的小写字母,返回新的字符串
 *
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 *
 * @author   Li.zongjie
 * @date     2021/12/12
 * @version  1.0
 */
public class Z7UpperToLower {

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public String toLowerCaseByBit(String s) {
        // A: 01000001,a: 01100001
        byte[] v = s.getBytes();
        for (int i = 0; i < v.length; i++) {
            if (v[i] <= 'Z' && v[i] >= 'A'){
                v[i] |= 32;
            }
        }
        return new String(v);
    }
}
