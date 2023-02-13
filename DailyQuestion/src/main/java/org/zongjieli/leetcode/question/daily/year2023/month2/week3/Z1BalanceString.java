package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

/**
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符,且长度为 n 的字符串
 * 假如在该字符串中,这四个字符都恰好出现 n/4 次,那么它就是一个平衡字符串
 * 给定一个这样的字符串 s,请通过替换一个子串的方式,使原字符串 s 变成一个平衡字符串
 * 可以用和待替换子串长度相同的任何其他字符串来完成替换
 * 请返回待替换子串的最小可能长度
 * 如果原字符串自身就是一个平衡字符串,则返回 0
 *
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/13
 */
public class Z1BalanceString {

    public int balancedString(String s) {
        int[] count = new int[128];
        byte[] values = s.getBytes();
        for (byte value : values) {
            count[value]++;
        }
        int result = values.length, start = 0, need = s.length() / 4, end = 0;
        a: while (start < values.length) {
            while ((count['Q'] > need || count['W'] > need || count['E'] > need || count['R'] > need)) {
                if (end == values.length) {
                    break a;
                }
                count[values[end++]]--;
            }
            while (start < values.length && ++count[values[start++]] <= need) {}
            result = Math.min(result, end - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Z1BalanceString test = new Z1BalanceString();
        // 0
        System.out.println(test.balancedString("QWER"));
        // 1
        System.out.println(test.balancedString("QQWE"));
        // 4
        System.out.println(test.balancedString("WWQQRRRRQRQQ"));
    }
}
