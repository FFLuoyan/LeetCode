package org.zongjieli.leetcode.question.daily.year2024.month1.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组 words 和一个字符 separator
 * 请按 separator 拆分 words 中的每个字符串
 * 返回一个由拆分后的新字符串组成的字符串数组,不包括空字符串
 * 注意:
 *  separator 用于决定拆分发生的位置,但它不包含在结果字符串中
 *  拆分可能形成两个以上的字符串
 *  结果字符串必须保持初始相同的先后顺序
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母,要么就是字符串 ".,|$#@" 中的字符(不包括引号)
 * separator 是字符串 ".,|$#@" 中的某个字符(不包括引号)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/24
 */
public class Z6SplitString {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>(words.size());
        char[] values = new char[20];
        int index = 0;
        for (String word : words) {
            for (char currentChar : word.toCharArray()) {
                if (currentChar == separator) {
                    if (index > 0) {
                        result.add(new String(values, 0, index));
                        index = 0;
                    }
                } else {
                    values[index++] = currentChar;
                }
            }
            if (index > 0) {
                result.add(new String(values, 0, index));
                index = 0;
            }
        }
        return result;
    }

}
