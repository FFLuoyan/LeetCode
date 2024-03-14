package org.zongjieli.leetcode.question.daily.year2024.month3.week3;

/**
 * 给定一个二进制字符串 s,其中至少包含一个 '1'
 * 必须按某种方式重新排列字符串中的位,使得到的二进制数字是可以由该组合生成的最大二进制奇数
 * 以字符串形式,表示并返回可以由给定组合生成的最大二进制奇数
 * 注意,返回的结果字符串可以含前导零
 *
 * 1 <= s.length <= 100
 * s 仅由 '0' 和 '1' 组成
 * s 中至少包含一个 '1'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/14
 */
public class Z3FindMaxOdd {

    public String maximumOddBinaryNumber(String s) {
        byte[] values = s.getBytes();
        int index = 0;
        for (byte value : values) {
            if (value == '1') {
                values[index++] = '1';
            }
        }
        index--;
        while (index < values.length) {
            values[index++] = '0';
        }
        values[values.length - 1] = '1';
        return new String(values);
    }

}
