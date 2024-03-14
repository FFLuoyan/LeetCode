package org.zongjieli.leetcode.question.daily.year2024.month3.week3;

/**
 * 给定一个字符串 title,它由单个空格连接一个或多个单词组成,每个单词都只包含英文字母
 * 请按以下规则将每个单词的首字母大写:
 *  如果单词的长度为 1 或者 2,所有字母变成小写
 *  否则,将单词首字母大写,剩余字母变成小写
 * 请返回大写后的 title
 *
 * 1 <= title.length <= 100
 * title 由单个空格隔开的单词组成,且不含有任何前导或后缀空格
 * 每个单词由大写和小写英文字母组成,且都是非空的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/14
 */
public class Z1TitleCase {

    public String capitalizeTitle(String title) {
        byte[] values = title.getBytes();
        int blankIndex = -1, nextBlankIndex;
        while (blankIndex < values.length) {
            nextBlankIndex = blankIndex;
            while (++nextBlankIndex < values.length && values[nextBlankIndex] != ' ') {}
            if (nextBlankIndex - (++blankIndex) <= 2) {
                while (blankIndex < nextBlankIndex) {
                    if (values[blankIndex] <= 'Z') {
                        values[blankIndex] += 32;
                    }
                    blankIndex++;
                }
            } else {
                if (values[blankIndex] > 'Z') {
                    values[blankIndex] -= 32;
                }
                while (++blankIndex < nextBlankIndex) {
                    if (values[blankIndex] <= 'Z') {
                        values[blankIndex] += 32;
                    }
                }
            }
        }
        return new String(values);
    }

}
