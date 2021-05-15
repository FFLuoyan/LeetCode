package org.zongjieli.leetcode.competion.doubleweekly.order52;

import java.util.Arrays;

/**
 * 一个句子指的是一个序列的单词用单个空格连接起来
 * 且开头和结尾没有任何空格
 * 每个单词都只包含小写或大写英文字母
 *
 * 我们可以给一个句子添加从 1 开始的单词位置索引,并且将句子中所有单词打乱顺序
 *
 * 比方说,句子 "This is a sentence"
 * 可以被打乱顺序得到 "sentence4 a3 is2 This1"
 * 或者 "is2 sentence4 This1 a3"
 *
 * 给你一个打乱顺序的句子 s
 * 它包含的单词不超过 9 个
 * 请你重新构造并得到原本顺序的句子
 *
 * 2 <= s.length <= 200
 * s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字
 * s 中单词数目为 1 到 9 个
 * s 中的单词由单个空格分隔
 * s 不包含任何前导或者后缀空格
 *
 * @author   Zongjie.Li
 * @date     2021/5/15
 * @version  1.0
 */
public class OrderSentence {
    public String sortSentence(String s) {
        String[] sentence = new String[9];
        String[] split = s.split(" ");
        for (String s1 : split) {
            int index = s1.charAt(s1.length() - 1) - '1';
            sentence[index] = s1.substring(0,s1.length() - 1);
        }
        StringBuilder stringBuilder = new StringBuilder(sentence[0]);
        for (int i = 1 ; i < 9 ; i++){
            if (sentence[i] == null){
                break;
            }
            stringBuilder.append(" ");
            stringBuilder.append(sentence[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OrderSentence test = new OrderSentence();
        System.out.println(test.sortSentence("sentence4 a3 is2 This1"));
    }
}
