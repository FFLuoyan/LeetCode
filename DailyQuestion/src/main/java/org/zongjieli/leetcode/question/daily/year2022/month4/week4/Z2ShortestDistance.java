package org.zongjieli.leetcode.question.daily.year2022.month4.week4;
/**
 * 给定一个字符串 s 和一个字符 c,且 c 是 s 中出现过的字符
 * 返回一个整数数组 answer,其中 answer.length == s.length
 * answer[i] 是 s 中从下标 i 到离它最近的字符 c 的距离
 * 两个下标 i 和 j 之间的距离为 abs(i - j),其中 abs 是绝对值函数
 *
 *  1 <= s.length <= 10^4
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 *
 * @author   Li.zongjie
 * @date     2022/4/19
 * @version  1.0
 */
public class Z2ShortestDistance {

    public int[] shortestToChar(String s, char c) {
        int last = 0;
        int[] result = new int[s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == c) {
                last = i;
                break;
            }
        }
        for (int i = 0 ; i < last ; i++) {
            result[i] = last - i;
        }
        for (int i = last + 1 ; i < s.length() ; i++) {
            result[i] = i - last;
            if (s.charAt(i) == c) {
                for (int j = (last + i + 1) / 2 ; j <= i ; j++) {
                    result[j] = i - j;
                }
                last = i;
            }
        }
        for (int i = last + 1 ; i < s.length() ; i++) {
            result[i] = i - last;
        }
        return result;
    }
}
