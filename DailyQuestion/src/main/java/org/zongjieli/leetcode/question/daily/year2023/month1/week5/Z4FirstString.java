package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 小写字符的数值是它在字母表中的位置(从 1 开始)
 * 因此 a 的数值为 1,b 的数值为 2,c 的数值为 3,以此类推
 * 字符串由若干小写字符组成,字符串的数值为各字符的数值之和
 * 例如,字符串 "abe" 的数值等于 1 + 2 + 5 = 8
 * 给定两个整数 n 和 k,返回长度等于 n 且数值等于 k 的字典序最小的字符串
 * 注意,如果字符串 x 在字典排序中位于 y 之前,就认为 x 字典序比 y 小,有以下两种情况:
 *  x 是 y 的一个前缀
 *  如果 i 是 x[i] != y[i] 的第一个位置,且 x[i] 在字母表中的位置比 y[i] 靠前
 *
 * 1 <= n <= 10^5
 * n <= k <= 26 * n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/28
 */
public class Z4FirstString {

    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        k -= n;
        while (k >= 25) {
            result[--n] = 'z';
            k -= 25;
        }
        if (--n >= 0) {
            result[n] = (char) ('a' + k);
        }
        while (--n >= 0) {
            result[n] = 'a';
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Z4FirstString test = new Z4FirstString();
        // zzzzz
        System.out.println(test.getSmallestString(5, 130));
        // vzzz
        System.out.println(test.getSmallestString(4, 100));
    }

}
