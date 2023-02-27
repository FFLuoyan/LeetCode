package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 一份单词表 words,一个字母表 letters(可能会有重复字母),以及每个字母对应的得分情况表 score
 * 请帮忙计算玩家在单词拼写游戏中所能获得的最高得分:
 *  能够由 letters 里的字母拼写出的任意属于 words 单词子集中,分数最高的单词集合的得分
 * 单词拼写游戏的规则概述如下:
 *  玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词
 *  可以只使用字母表 letters 中的部分字母,但是每个字母最多被使用一次
 *  单词表 words 中每个单词只能计分（使用）一次
 *  根据字母得分情况表 score
 *      字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]
 * 本场游戏的得分是指: 玩家所拼写出的单词集合里包含的所有字母的得分之和
 *
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length == 26
 * 0 <= score[i] <= 10
 * words[i] 和 letters[i] 只包含小写的英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/27
 */
public class Z7MaxScoreWord {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[][] wordCount = new int[words.length][26];
        int[] wordScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (byte b : words[i].getBytes()) {
                int index = b - 'a';
                wordScore[i] += score[index];
                wordCount[i][index]++;
            }
        }
        int[] remain = new int[26];
        for (char letter : letters) {
            remain[letter - 'a']++;
        }
        return getMaxScore(wordCount, 0, 0, wordScore, remain);
    }

    public int getMaxScore(int[][] count, int currentIndex, int currentScore, int[] scores, int[] remain) {
        if (currentIndex == count.length) {
            return currentScore;
        }
        int notContainCurrent = getMaxScore(count, currentIndex + 1, currentScore, scores, remain);
        for (int i = 0; i < remain.length; i++) {
            if (remain[i] < count[currentIndex][i]) {
                return notContainCurrent;
            }
        }
        int[] newRemain = new int[26];
        for (int i = 0; i < newRemain.length; i++) {
            newRemain[i] = remain[i] - count[currentIndex][i];
        }
        int containCurrent = getMaxScore(count, currentIndex + 1, currentScore + scores[currentIndex], scores, newRemain);
        return Math.max(notContainCurrent, containCurrent);
    }

    public static void main(String[] args) {
        Z7MaxScoreWord test = new Z7MaxScoreWord();
        // 98
        System.out.println(test.maxScoreWords(new String[]{"bbb", "abc", "ce", "ced", "ca", "cbd", "adbde", "eaeee"}, new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'e', 'e', 'e'}, new int[]{4, 1, 9, 2, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

}
