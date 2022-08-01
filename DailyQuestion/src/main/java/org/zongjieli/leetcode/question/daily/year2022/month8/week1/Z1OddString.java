package org.zongjieli.leetcode.question.daily.year2022.month8.week1;
/**
 * 给定一个整数 n,请返回一个含 n 个字符的字符串
 * 其中每种字符在该字符串中都恰好出现奇数次
 * 返回的字符串必须只含小写英文字母
 * 如果存在多个满足题目要求的字符串
 * 则返回其中任意一个即可
 *
 * 1 <= n <= 500
 *
 * @author   Li.zongjie
 * @date     2022/8/1
 * @version  1.0
 */
public class Z1OddString {

    public String generateTheString(int n) {
        byte[] result = new byte[n];
        int ac = (n & 1) == 1 ? n : n - 1;
        if (ac < n) {
            result[ac] = 'b';
        }
        while (--ac >= 0) {
            result[ac] = 'a';
        }
        return new String(result);
    }
}
