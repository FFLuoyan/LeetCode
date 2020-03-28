package org.zongjieli.leetcode.primaryalgorithm.math;

/**
 * @ClassName: RomanToInt
 * @Description: 将罗马字符转化为 Int
 * 罗马字符串包含 7 中字符
 * I: 1
 * V: 5
 * X: 10
 * L: 50
 * C: 100
 * D: 500
 * M: 1000
 * 通常情况下数据用字符的个数表示,大数在前,小数在后
 * 但对于每个整 5,整 10 ,用小数在大数之前,表示该数减去小数的结果
 * 例如用 100 或 50 表示 90 或 40 的表示方式为 XC 和 XL
 * @Author: Zongjie.Li
 * @Date: 2020/3/28
 * @Version: 1.0
 **/
public class RomanToInt {

    public int romanToInt(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] charValue = new char[]{'a', 'A', 'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] intValue = new int[]{0, 0, 1000, 500, 100, 50, 10, 5, 1};
        // 该种算法的步骤关在于匹配正确的 Value
        // 罗马数字总体来说是前面的大于后面的,所以匹配的时候往后循环就可以了
        int count = 0;
        int valueIndex = 2;
        for (int index = 0; index < s.length(); ) {
            char stringChar = s.charAt(index);
            if (stringChar == charValue[valueIndex]) {
                count += intValue[valueIndex];
                index++;
            } else if (stringChar == charValue[valueIndex - 1]) {
                // 如果为 4
                count += ((intValue[valueIndex] << 1) + intValue[valueIndex]);
                index++;
            } else if (stringChar == charValue[valueIndex - 2]) {
                // 如果为 10
                count += (intValue[valueIndex] << 3);
                index++;
            } else {
                // 无法匹配,则对匹配数组进行遍历
                valueIndex++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMLXIV"));
    }
}
