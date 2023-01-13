package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

import java.util.Arrays;

/**
 * 给定两个下标从 0 开始的字符串 s 和 target
 * 可以从 s 取出一些字符并将其重排,得到若干新的字符串
 * 从 s 中取出字符并重新排列,返回可以形成 target 的最大副本数
 *
 * 1 <= s.length <= 100
 * 1 <= target.length <= 10
 * s 和 target 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/13
 */
public class Z5RearrangeChar {

    public int rearrangeCharacters(String s, String target) {
        int[] save = new int[26], need = new int[26];
        for (char c : s.toCharArray()) {
            save[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            need[c - 'a']++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < save.length; i++) {
            if (need[i] > 0) {
                result = Math.min(result, save[i] / need[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z5RearrangeChar test = new Z5RearrangeChar();
        // 2
        System.out.println(test.rearrangeCharacters("ilovecodingonleetcode", "code"));
        // 2
        System.out.println(test.rearrangeCharacters("lrnvlcqukanpdnluowenfxquitzryponxsikhciohyostvmkapkfpglzikitwiraqgchxnpryhwpuwpozacjhmwhjvslprqlnxrk", "woijih"));
    }

}
