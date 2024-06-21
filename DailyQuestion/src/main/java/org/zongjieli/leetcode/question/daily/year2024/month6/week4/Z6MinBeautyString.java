package org.zongjieli.leetcode.question.daily.year2024.month6.week4;

/**
 * 如果一个字符串满足以下条件,则称其为美丽字符串:
 *  它由英语小写字母表的前 k 个字母组成
 *  它不包含任何长度为 2 或更长的回文子字符串
 *  给定一个长度为 n 的美丽字符串 s 和一个正整数 k
 * 请找出并返回一个长度为 n 的美丽字符串,该字符串还满足:
 *  在字典序大于 s 的所有美丽字符串中字典序最小
 * 如果不存在这样的字符串,则返回一个空字符串
 * 对于长度相同的两个字符串 a 和 b
 * 如果字符串 a 在与字符串 b 不同的第一个位置上的字符字典序更大
 * 则字符串 a 的字典序大于字符串 b
 * 例如, "abcd" 的字典序比 "abcc" 更大
 * 因为在不同的第一个位置(第四个字符)上 d 的字典序大于 c
 *
 * 1 <= n == s.length <= 10^5
 * 4 <= k <= 26
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/6/22
 */
public class Z6MinBeautyString {

    public String smallestBeautifulString(String s, int k) {
        byte[] values = s.getBytes();
        byte maxValue = (byte) ('a' + k - 1), currentMax;
        for (int i = values.length - 1; i >= 0; i--) {
            currentMax = findMinValid(values[i], i >= 1 ? values[i - 1] : -1, i >= 2 ? values[i - 2] : -1, maxValue);
            if (currentMax != -1) {
                values[i] = currentMax;
                boolean success = writeValueStartBy(i, values, maxValue);
                if (success) {
                    return new String(values);
                }
            }
        }
        return "";
    }

    public byte findMinValid(byte b0, byte b1, byte b2, byte max) {
        while (++b0 <= max) {
            if (b0 != b1 && b0 != b2) {
                return b0;
            }
        }
        return -1;
    }

    public boolean writeValueStartBy(int startIndex, byte[] values, byte max) {
        while (++startIndex < values.length) {
            values[startIndex] = findMinValid((byte) 96, startIndex >= 1 ? values[startIndex - 1] : -1, startIndex >= 2 ? values[startIndex - 2] : -1, max);
            if (values[startIndex] == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z6MinBeautyString test = new Z6MinBeautyString();
        // abda
        System.out.println(test.smallestBeautifulString("abcz", 26));
    }

}
