package org.zongjieli.leetcode.question.daily.year2022.month8.week2;

/**
 * 给定一个混合了数字和字母的字符串 s
 * 其中的字母均为小写英文字母
 * 请将该字符串重新格式化
 * 使得任意两个相邻字符的类型都不同
 * 也就是说,字母后面应该跟着数字,而数字后面应该跟着字母
 * 请返回重新格式化后的字符串
 * 如果无法按要求重新格式化,则返回一个空字符串
 *
 * 1 <= s.length <= 500
 * s 仅由小写英文字母或数字组成
 *
 * @author   Li.zongjie
 * @date     2022/8/11
 * @version  1.0
 */
public class Z4ReformatString {

    public String reformat(String s) {
        byte[] values = s.getBytes();
        int length = values.length;
        int add = (length & 1);
        int ni = 0, ci = 1, vi = 0, lni = length + add, lci = lni + 1;
        byte[] result = new byte[length + 2 + add];
        for (; ni <= lni && ci <= lci && vi < length; vi++) {
            if (values[vi] <= 57) {
                result[ni] = values[vi];
                ni += 2;
            } else {
                result[ci] = values[vi];
                ci += 2;
            }
        }
        if (ni > lni || ci > lci) {
            return "";
        }
        if (add == 0 || ni > ci) {
            return new String(result, 0, length);
        }
        result[length - 1] = result[0];
        return new String(result, 1, length);
    }

    public static void main(String[] args) {
        Z4ReformatString test = new Z4ReformatString();
        // 0a1b2c
        System.out.println(test.reformat("a0b1c2"));
        // a1b2c0d
        System.out.println(test.reformat("a0b1c2d"));
        // 0a1b2c3
        System.out.println(test.reformat("a0b1c23"));
    }
}
