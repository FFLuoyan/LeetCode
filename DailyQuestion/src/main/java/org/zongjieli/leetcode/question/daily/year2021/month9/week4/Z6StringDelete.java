package org.zongjieli.leetcode.question.daily.year2021.month9.week4;
/**
 * 给定两个单词 word1 和 word2
 * 找到使得 word1 和 word2 相同所需的最小步数
 * 每步可以删除任意一个字符串中的一个字符
 *
 * 给定单词的长度不超过 500
 * 给定单词中的字符只含有小写字母
 *
 * Origin
 * @see org.zongjieli.leetcode.origin.year2021.month9.LongestCommonSequence
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class Z6StringDelete {
    public int minDistance(String word1, String word2) {
        int firstLength = word1.length();
        int secondLength = word2.length();
        int[][] length = new int[firstLength + 1][secondLength + 1];
        for (int i = 1 ; i <= firstLength ; i++){
            char firstChar = word1.charAt(i - 1);
            for (int j = 1 ; j <= secondLength ; j++){
                char secondChar = word2.charAt(j - 1);
                length[i][j] = firstChar == secondChar ? length[i - 1][j - 1] + 1 : Math.max(length[i - 1][j], length[i][j - 1]);
            }
        }
        return firstLength + secondLength - 2 * length[firstLength][secondLength];
    }
}
