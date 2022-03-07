package org.zongjieli.leetcode.question.daily.year2022.month3.week;
/**
 * 给定一个整数 num,将其转化为 7 进制,并以字符串形式输出
 *
 * -10^7 <= num <= 10^7
 *
 * @author   Li.zongjie
 * @date     2022/3/7
 * @version  1.0
 */
public class Z1SevenRadix {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
