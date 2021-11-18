package org.zongjieli.leetcode.question.daily.year2021.month11.week3;
/**
 * 给定一个字符串数组 words
 * 找到 length(word[i]) * length(word[j]) 的最大值
 * 并且这两个单词不含有公共字母
 * 可以认为每个单词只包含小写字母
 * 如果不存在这样的两个单词,返回 0
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * @author   Li.zongjie
 * @date     2021/11/17
 * @version  1.0
 */
public class Z3WordsLengthMultiply {
    public int maxProduct(String[] words) {
        int result = 0;
        int[] exists = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0 ; j < word.length() ; j++){
                exists[i] |= (1 << (word.charAt(j) - 'a'));
            }
            for (int j = 0 ; j < i ; j++){
                if ((exists[i] & exists[j]) == 0){
                    result = Math.max(result, words[j].length() * word.length());
                }
            }
        }
        return result;
    }
}
