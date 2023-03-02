package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

import java.util.Arrays;

/**
 * 给定一个介于 0 和 1 之间的实数(如: 0.72),类型为 double
 * 打印它的二进制表达式,如果该数字无法精确地用 32 位以内的二进制表示,则打印 "ERROR"
 *
 * 32位包括输出中的 "0." 这两位
 * 题目保证输入用例的小数位数最多只有 6 位
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/2
 */
public class Z4DoubleBin {

    public String printBin(double num) {
        char[] result = new char[32];
        result[0] = '0';
        result[1] = '.';
        int ri = 2;
        while (ri < 32 && num != 0) {
            num *= 2;
            if (num >= 1) {
                result[ri++] = '1';
                num -= 1;
            } else {
                result[ri++] = '0';
            }
        }
        return ri == 32 ? "ERROR" : new String(result, 0, ri);
    }

    public static void main(String[] args) {
        Z4DoubleBin test = new Z4DoubleBin();
        // 0.101
        System.out.println(test.printBin(0.625));
        // ERROR
        System.out.println(test.printBin(0.1));
        // ERROR
        System.out.println(test.printBin(0.573628));
    }

}
