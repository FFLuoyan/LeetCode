package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

/**
 * 给定一个字符串 s,返回 s 中同构子字符串的数目
 * 由于答案可能很大,只需返回对 10^9 + 7 取余后的结果
 * 同构字符串的定义为: 如果一个字符串中的所有字符都相同,那么该字符串就是同构字符串
 * 子字符串是字符串中的一个连续字符序列
 *
 * 1 <= s.length <= 10^5
 * s 由小写字符串组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/26
 */
public class Z1HomogenousCount {

    public int countHomogenous(String s) {
        byte[] values = s.getBytes();
        long result = 0, lastCount = 1;
        for (int i = 1 ; i < values.length ; i++) {
            if (values[i] != values[i - 1]) {
                result += ((lastCount + 1) * lastCount / 2);
                lastCount = 1;
            } else {
                lastCount++;
            }
        }
        result += ((lastCount + 1) * lastCount / 2);
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        Z1HomogenousCount test = new Z1HomogenousCount();
        // 13
        System.out.println(test.countHomogenous("abbcccaa"));
    }
}
