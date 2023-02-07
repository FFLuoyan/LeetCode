package org.zongjieli.leetcode.question.daily.year2022.month11.week1;

/**
 * 给定一个字符串 sequence,如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串
 * 那么单词 word 的重复值为 k
 * 单词 word 的最大重复值是单词 word 在 sequence 中最大的重复值
 * 如果 word 不是 sequence 的子串,那么重复值 k 为 0
 * 给定一个字符串 sequence 和 word,请你返回最大重复值 k
 *
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/7
 */
public class Z4MaxRepeatString {

    public int maxRepeating(String sequence, String word) {
        int result = 0;
        StringBuilder search = new StringBuilder(word);
        while (sequence.contains(search)) {
            result++;
            search.append(word);
        }
        return result;
    }

}
