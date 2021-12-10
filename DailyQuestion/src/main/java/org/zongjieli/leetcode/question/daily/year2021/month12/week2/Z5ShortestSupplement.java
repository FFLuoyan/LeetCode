package org.zongjieli.leetcode.question.daily.year2021.month12.week2;
/**
 * 给定一个字符串 licensePlate 和一个字符串数组 words
 * 请找出并返回 words 中的最短补全词
 *
 *  补全词是一个包含 licensePlate 中所有的字母的单词
 *  在所有补全词中,最短的那个就是最短补全词
 *
 * 在匹配 licensePlate 中的字母时:
 *
 *  忽略 licensePlate 中的 数字和空格
 *  不区分大小写
 *  如果某个字母在 licensePlate 中出现不止一次,那么该字母在补全词中的出现次数应当一致或者更多
 *
 * 例如:licensePlate = "aBc 12c"那么它的补全词应当包含
 * 字母 'a'、'b'(忽略大写)和两个 'c'
 * 可能的补全词有 "abccdef"、"caaacab" 以及 "cbca"
 *
 * 请找出并返回 words 中的最短补全词
 * 题目数据保证一定存在一个最短补全词
 * 当有多个单词都符合最短补全词的匹配条件时取 words 中最靠前的那个
 *
 *  1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/12/10
 * @version  1.0
 */
public class Z5ShortestSupplement {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[27];
        for (int i = 0 ; i < licensePlate.length() ; i++){
            char c = licensePlate.charAt(i);
            count[c >= 'a' ? c - 'a' : c >= 'A' ? c - 'A' : 26]++;
        }

        String result = null;

        a: for (String word : words) {
            int[] temp = new int[26];
            for (int i = 0 ; i < word.length(); i++){
                temp[word.charAt(i) - 'a']++;
            }
            for (int i = 0 ; i < 26; i++){
                if (temp[i] < count[i]){
                    continue a;
                }
            }
            result = result == null || result.length() > word.length() ? word : result;
        }

        return result;
    }
}
