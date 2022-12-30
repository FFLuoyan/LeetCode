package org.zongjieli.leetcode.question.daily.year2022.month11.week5;

/**
 * 给定一个仅由字符 '0' 和 '1' 组成的字符串 s
 * 一步操作中,可以将任一 '0' 变成 '1',或者将 '1' 变成 '0'
 * 交替字符串定义为:如果字符串中不存在相邻两个字符相等的情况
 * 那么该字符串就是交替字符串,例如,字符串 "010" 是交替字符串,而字符串 "0100" 不是
 * 返回使 s 变成交替字符串所需的最少操作数
 *
 * 1 <= s.length <= 10^4
 * s[i] 是 '0' 或 '1'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/1
 */
public class Z2MinOperate {

    public int minOperations(String s) {
        int current = 0, result = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            result += ((s.charAt(i) - '0') ^ (current ^= 1));
        }
        return Math.min(result, s.length() - result);
    }

    public static void main(String[] args) {
        Z2MinOperate test = new Z2MinOperate();
        // 0
        System.out.println(test.minOperations("10"));
    }

}
