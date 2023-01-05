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
        boolean[] exist = new boolean[128];
        for (byte b : s.getBytes()) {
            exist[b] = true;
        }
        boolean isMax = false;
        for (int i = '9' ; i >= '0' ; i--) {
            if (exist[i]) {
                if (isMax) {
                    return i - '0';
                }
                isMax = true;
            }
        }
        return -1;
    }

}
