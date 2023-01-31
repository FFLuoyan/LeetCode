package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

/**
 * 一个句子是由一些单词与它们之间的单个空格组成,且句子的开头和结尾没有多余空格
 * 比方说, "Hello World", "HELLO", "hello world hello world" 都是句子
 * 每个单词都只包含大写和小写英文字母
 * 如果两个句子 sentence1 和 sentence2
 * 可以通过往其中一个句子插入一个任意的句子(可以是空句子)而得到另一个句子
 * 那么我们称这两个句子是相似的,比方说:
 * sentence1 = "Hello my name is Jane", sentence2 = "Hello Jane"
 * 我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1
 * 给定两个句子 sentence1 和 sentence2
 * 如果 sentence1 和 sentence2 是相似的,请返回 true,否则返回 false
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格
 * sentence1 和 sentence2 中的单词都只由单个空格隔开
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/30
 */
public class Z1SameSentence {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        byte[] values1 = sentence1.getBytes();
        byte[] values2 = sentence2.getBytes();
        int matchIndex = 0, blankIndex = -1;

        while (matchIndex < values2.length && values1[matchIndex] == values2[matchIndex]) {
            if (values1[matchIndex] == ' ') {
                blankIndex = matchIndex;
            }
            matchIndex++;
        }
        if (matchIndex == values2.length && (matchIndex == values1.length || values1[matchIndex] == ' ')) {
            return true;
        }
        int i = values1.length - 1, j = values2.length - 1;
        while (j > blankIndex) {
            if (values1[i--] != values2[j--]) {
                return false;
            }
        }
        return i == -1 || values1[i] == ' ';
    }

}
