package org.zongjieli.leetcode.algorithm.primary.string;

/**
 * 给定一个字符串,找到它的第一个不重复的字符,并返回它的索引
 * 如果不存在,则返回 -1
 *
 * 你可以假定该字符串只包含小写字母
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P03FirstUniqueChar {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        int[] firstCharIndex = new int[26];
        int index;
        for (int i = 0 ; i < s.length() ; i++){
            index = s.charAt(i) - 'a';
            if (charCount[index]++ == 0){
                firstCharIndex[index] = i;
            }
        }
        index = s.length();
        for (int i = 0 ; i < 26 ; i++){
            index = charCount[i] == 1 ? Math.min(index, firstCharIndex[i]) : index;
        }
        return index == s.length() ? -1 : index;
    }

    public static void main(String[] args) {
        P03FirstUniqueChar test = new P03FirstUniqueChar();
        System.out.println(test.firstUniqChar("leetcode"));
    }
}
