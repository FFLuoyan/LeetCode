package org.zongjieli.leetcode.question.daily.year2022.month8.week2;

import java.util.Arrays;

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
        int l = values.length;
        if (l == 1) {
            return s;
        }
        Arrays.sort(values);
        int middle = l / 2;
        if (values[middle - 1] > 57 || values[middle + (l & 1)] <= 57) {
            return "";
        }
        int left = 1, right = l - 2;
        if ((l & 1) == 1) {
            if (values[middle] > 57) {
                left--;
            } else {
                right++;
            }
        }
        for (; left < right ; left += 2, right -= 2) {
            byte temp = values[left];
            values[left] = values[right];
            values[right] = temp;
        }
        return new String(values);
    }

    public static void main(String[] args) {
        Z4ReformatString test = new Z4ReformatString();
        System.out.println(test.reformat("a0b1c2"));
    }
}
