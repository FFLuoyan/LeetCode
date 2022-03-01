package org.zongjieli.leetcode.question.daily.year2022.month3.week1;
/**
 * 将一个给定字符串 s 根据给定的行数 numRows,以从上往下、从左到右进行 Z 字形排列
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时,排列如下:
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 * 之后,输出需要从左往右逐行读取,产生出一个新的字符串,比如："PAHNAPLSIIGYIR"
 *
 * 请实现这个将字符串进行指定行数变换的函数:
 *  string convert(string s, int numRows);
 *
 * 1 <= s.length <= 1000
 * s 由英文字母(小写和大写)、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @author   Li.zongjie
 * @date     2022/3/1
 * @version  1.0
 */
public class Z2TransformZ {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] source = s.toCharArray();
        StringBuilder[] results = new StringBuilder[numRows];
        for (int i = 0 ; i < numRows ; i++) {
            results[i] = new StringBuilder();
        }
        int index = 0;
        while (index < source.length) {
            for (int i = 0 ; i < numRows - 1 && index < source.length ; i++, index++) {
                results[i].append(source[index]);
            }
            for (int i = numRows - 1 ; i > 0 && index < source.length ; i--, index++) {
                results[i].append(source[index]);
            }
        }
        for (int i = 1 ; i < numRows ; i++) {
            results[0].append(results[i]);
        }
        return results[0].toString();
    }

    public static void main(String[] args) {
        Z2TransformZ test = new Z2TransformZ();
        // PAHNAPLSIIGYIR
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
