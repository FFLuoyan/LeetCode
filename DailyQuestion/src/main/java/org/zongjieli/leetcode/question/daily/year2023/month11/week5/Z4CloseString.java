package org.zongjieli.leetcode.question.daily.year2023.month11.week5;

import java.util.Arrays;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串,则认为两个字符串接近:
 *  操作 1: 交换任意两个现有字符
 *      例如, abcde -> aecdb
 *  操作 2: 将一个现有字符的每次出现转换为另一个现有字符,并对另一个字符执行相同的操作
 *      例如, aacabb -> bbcbaa (所有 a 转化为 b, 而所有的 b 转换为 a)
 * 可以根据需要对任意一个字符串多次使用这两种操作
 * 给定两个字符串,word1 和 word2
 * 如果 word1 和 word2 接近,就返回 true,否则返回 false
 *
 * 1 <= word1.length, word2.length <= 10^5
 * word1 和 word2 仅包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/30
 */
public class Z4CloseString {

    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        for (byte b1 : word1.getBytes()) {
            count1[b1 - 'a']++;
        }
        for (byte b2 : word2.getBytes()) {
            count2[b2 - 'a']++;
        }
        for (int i = 0; i < count1.length; i++) {
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] - count2[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
