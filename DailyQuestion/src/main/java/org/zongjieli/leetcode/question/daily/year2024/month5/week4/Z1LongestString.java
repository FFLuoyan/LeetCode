package org.zongjieli.leetcode.question.daily.year2024.month5.week4;

/**
 * 给定一个字符串 s,请返回 s 中最长的超赞子字符串的长度
 * 超赞子字符串需满足满足下述两个条件:
 *  该字符串是 s 的一个非空子字符串
 *  进行任意次数的字符交换后,该字符串可以变成一个回文字符串
 *
 * 1 <= s.length <= 10^5
 * s 仅由数字组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/5/21
 */
public class Z1LongestString {

    public int longestAwesome(String s) {
        byte[] values = s.getBytes();
        int[] currentSize = new int[1024];
        int[] validValues = new int[]{0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int result = 1;
        for (byte value : values) {
            int currentValue = (1 << (value - '0'));
            int[] nextSize = new int[1024];
            for (int i = 0; i < currentSize.length; i++) {
                if (currentSize[i] == 0) {
                    continue;
                }
                nextSize[i ^ currentValue] = currentSize[i] + 1;
            }
            if (nextSize[currentValue] == 0) {
                nextSize[currentValue] = 1;
            }
            for (int validValue : validValues) {
                result = Math.max(result, nextSize[validValue]);
            }
            currentSize = nextSize;
        }
        return result;
    }

    public static void main(String[] args) {
        Z1LongestString test = new Z1LongestString();
        // 5
        System.out.println(test.longestAwesome("3242415"));
    }

}
