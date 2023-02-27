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

    private final long BIT = 36170086419038336L;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int length = words.length, cs;
        long[][] wordCount = new long[length][4];
        int[] wordScore = new int[length];
        long[] cc;
        for (int i = 0; i < length; i++) {
            cs = 0;
            cc = wordCount[i];
            for (byte b : words[i].getBytes()) {
                cs += score[b -= 'a'];
                cc[b / 7] += 1L << ((b % 7) << 3);
            }
            wordScore[i] = cs;
        }
        cc = new long[]{BIT, BIT, BIT, BIT};
        for (char letter : letters) {
            cc[(letter -= 'a') / 7] += 1L << ((letter % 7) << 3);
        }
        return getMaxScore(wordCount, 0, 0, wordScore, cc[0], cc[1], cc[2], cc[3]);
    }

    public int getMaxScore(long[][] count, int currentIndex, int currentScore, int[] scores, long r0, long r1, long r2, long r3) {
        if (currentIndex == count.length) {
            return currentScore;
        }
        int notContainCurrent = getMaxScore(count, currentIndex + 1, currentScore, scores, r0, r1, r2, r3);
        long[] currentCount = count[currentIndex];
        if (((r0 -= currentCount[0]) & BIT) != BIT || ((r1 -= currentCount[1]) & BIT) != BIT || ((r2 -= currentCount[2]) & BIT) != BIT  || ((r3 -= currentCount[3]) & BIT) != BIT) {
            return notContainCurrent;
        }
        return Math.max(notContainCurrent, getMaxScore(count, currentIndex + 1, currentScore + scores[currentIndex], scores, r0, r1, r2, r3));
    }

    public static void main(String[] args) {
        Z7MaxScoreWord test = new Z7MaxScoreWord();
        // 98
        System.out.println(test.maxScoreWords(new String[]{"bbb", "abc", "ce", "ced", "ca", "cbd", "adbde", "eaeee"}, new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'e', 'e', 'e'}, new int[]{4, 1, 9, 2, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

}
