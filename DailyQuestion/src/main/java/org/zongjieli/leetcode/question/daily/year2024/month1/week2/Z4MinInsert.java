package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

/**
 * 给定一个字符串 word,可以向其中任何位置插入 "a"、"b" 或 "c" 任意次
 * 返回使 word 有效需要插入的最少字母数
 * 如果字符串可以由 "abc" 串联多次得到,则认为该字符串有效
 *
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/11
 */
public class Z4MinInsert {

    public int addMinimum(String word) {
        byte[] values = word.getBytes();
        int groupCount = 1, length = values.length;
        for (int i = 1; i < length; i++) {
            if (values[i] <= values[i - 1]) {
                groupCount++;
            }
        }
        return 3 * groupCount - length;
    }

}
