package org.zongjieli.leetcode.question.daily.year2025.month3.week3;

/**
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的子字符串数目:
 *  子字符串长度为 k
 *  子字符串能整除 num
 * 给定整数 num 和 k,请返回 num 的 k 美丽值
 * 注意:
 *  允许有前缀 0
 *  0 不能整除任何值
 *  一个子字符串是一个字符串里的连续一段字符序列
 *
 * 1 <= num <= 10^9
 * 1 <= k <= num.length(将 num 视为字符串)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/10
 */
public class Z1BeautySubstring {

    public int divisorSubstrings(int num, int k) {
        int[] values = new int[10];
        int index = 9, cal = num, result = 0;
        while (num > 0) {
            values[index--] = num % 10;
            num /= 10;
        }
        while (index + k < 10) {
            int current = 0;
            for (int i = index + 1 ; i <= index + k ; i++) {
                current = 10 * current + values[i];
            }
            if (current != 0 && cal % current == 0) {
                result++;
            }
            index++;
        }
        return result;
    }

}
