package org.zongjieli.leetcode.question.daily.year2023.month11.week2;

/**
 * 给定一个字符串数组 words
 * 找出并返回 length(words[i]) * length(words[j]) 的最大值
 * 并且这两个单词不含有公共字母,如果不存在这样的两个单词,返回 0
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/6
 */
public class Z1MaxWordProduct {

    public int maxProduct(String[] words) {
        int[] exists = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            byte[] values = words[i].getBytes();
            for (byte value : values) {
                exists[i] |= 1 << (value - 'a');
            }
        }
        int result = 0;
        for (int i = 0; i < exists.length; i++) {
            for (int j = i + 1; j < exists.length; j++) {
                if ((exists[i] & exists[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

}
