package org.zongjieli.leetcode.question.daily.year2022.month12.Week1;

/**
 * 给定一个混合字符串 s
 * 请返回 s 中第二大的数字
 * 如果不存在第二大的数字,请返回 -1
 *
 * 混合字符串由小写英文字母和数字组成
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和(或)数字
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/3
 */
public class Z6SecondNumber {

    public int secondHighest(String s) {
        int[] count = new int[10];
        for (int i = 0 ; i < s.length() ; i++) {
            int current = s.charAt(i) - '0';
            if (current <= 9) {
                count[current]++;
            }
        }
        int result = -1;
        for (int i = 9 ; i >= 0 ; i--) {
            if (count[i] > 0) {
                if (result != -1) {
                    return i;
                }
                result = count[i];
            }
        }
        return -1;
    }

}
