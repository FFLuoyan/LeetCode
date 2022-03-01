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
        byte[] source = s.getBytes();
        int length = source.length;
        byte[] result = new byte[length];
        int resultIndex = 0;
        int interval = 2 * numRows - 2;
        // 第一行
        for (int sourceIndex = 0 ; sourceIndex < length ; sourceIndex += interval) {
            result[resultIndex++] = source[sourceIndex];
        }
        // 中间行
        for (int row = 1 ; row < numRows - 1 ; row++) {
            int sourceIndex1 = row;
            int sourceIndex2 = numRows + numRows - row - 2;
            for (; sourceIndex2 < length ; sourceIndex1 += interval, sourceIndex2+= interval) {
                result[resultIndex++] = source[sourceIndex1];
                result[resultIndex++] = source[sourceIndex2];
            }
            if (sourceIndex1 < length) {
                result[resultIndex++] = source[sourceIndex1];
            }
        }
        // 最后一行
        for (int sourceIndex = numRows - 1 ; sourceIndex < length ; sourceIndex += interval) {
            result[resultIndex++] = source[sourceIndex];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Z2TransformZ test = new Z2TransformZ();
        // PAHNAPLSIIGYIR
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
