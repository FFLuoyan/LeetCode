package org.zongjieli.leetcode.question.daily.year2022.month6.week2;
/**
 * 如果一个二进制字符串是以一些 0 (可能没有 0) 后面跟着一些 1 (也可能没有 1) 的形式组成的
 * 那么该字符串是单调递增的
 * 给定一个二进制字符串 s,可以将任何 0 翻转为 1 或者将 1 翻转为 0
 *
 * 返回使 s 单调递增的最小翻转次数
 *
 * 1 <= s.length <= 10^5
 * s[i] 为 '0' 或 '1'
 *
 * @author   Li.zongjie
 * @date     2022/6/13
 * @version  1.0
 */
public class Z6Flip2Inc {

    public int minFlipsMonoIncr(String s) {
        byte[] ss = s.getBytes();
        int o2z = 0;
        for (byte b : ss) {
            if (b == '1') {
                o2z++;
            }
        }
        int min = o2z;
        int current = o2z;
        for (int i = ss.length - 1; i >= 0 ; i--) {
            if (ss[i] == '1') {
                current--;
            } else {
                current++;
            }
            min = Math.min(min, current);
        }
        return min;
    }
}
