package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

/**
 * 给定一个下标从 0 开始长度为 n 的字符串 num,它只包含数字
 * 如果对于每个 0 <= i < n 的下标 i,都满足数位 i 在 num 中出现了 num[i]次,那么返回 true,否则返回 false
 *
 * n == num.length
 * 1 <= n <= 10
 * num 只包含数字。
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z3DigitCount {

    public boolean digitCount(String num) {
        int[] count = new int[10];
        byte[] bs = num.getBytes();
        for (byte b : bs) {
            count[b - '0']++;
        }
        for (int i = 0; i < bs.length; i++) {
            if (count[i] != bs[i] - '0') {
                return false;
            }
        }
        return true;
    }

}
