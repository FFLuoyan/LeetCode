package org.zongjieli.leetcode.competion.singleweekly.order189;

import java.util.Arrays;

/**
 * @ClassName: ReformatWordInString
 * @Description: 重新排列句子中的单词
 * 句子是一个用空格分隔单词的字符串,给一个满足下列格式的句子 text
 * 句子的首字母大写
 * text 中每个单词都用单个空格分隔
 * 请重新排列 text 中的单词,是所有单词按其长度的升序排列
 * 如果两个单词的长度相同,则保留其在原句子中的相对顺序
 * 请同样按上述格式返回新的句子
 * @Author: Zongjie.Li
 * @Date: 2020/5/17
 * @Version: 1.0
 **/
public class ReformatWordInString {
    public String arrangeWords(String text) {
        String[] wordList = text.split(" ");
        wordList[0] = wordList[0].toLowerCase();

        for (int i = 0; i < wordList.length - 1; i++) {
            for (int j = 0; j < wordList.length - 1 - i; j++) {
                if (wordList[j].length() > wordList[j + 1].length()) {
                    String temp = wordList[j];
                    wordList[j] = wordList[j + 1];
                    wordList[j + 1] = temp;
                }
            }
        }

        wordList[0] = wordList[0].substring(0, 1).toUpperCase() + wordList[0].substring(1);
        StringBuilder stringBuilder = new StringBuilder(wordList[0]);
        for (int i = 1; i < wordList.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(wordList[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReformatWordInString reformatWordInString = new ReformatWordInString();
        System.out.println(reformatWordInString.arrangeWords("Keep calm and code on"));
    }
}
