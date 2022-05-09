package org.zongjieli.leetcode.question.daily.year2022.month5.week3;
/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s
 * 其中:
 *  如果 perm[i] < perm[i + 1],那么 s[i] == 'I' 
 *  如果 perm[i] > perm[i + 1],那么 s[i] == 'D' 
 * 给定一个字符串 s,重构排列 perm 并返回它
 * 如果有多个有效排列 perm,则返回其中任何一个
 *
 * 1 <= s.length <= 10^5
 * s 只包含字符 "I" 或 "D"
 *
 * @author   Li.zongjie
 * @date     2022/5/9
 * @version  1.0
 */
public class Z1StringMatch {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int min = 0;
        int max = n;
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (s.charAt(i) == 'D') {
                result[i + 1] = min++;
            } else {
                result[i + 1] = max--;
            }
        }
        result[0] = min;
        return result;
    }
}
