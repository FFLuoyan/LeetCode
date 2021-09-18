package org.zongjieli.leetcode.algorithm.primary.string;

import java.util.Arrays;

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
        int[] indexSave = new int[26];
        Arrays.fill(indexSave, -1);
        for (int i = 0 ; i < s.length() ; i++){
            int index = s.charAt(i) - 'a';
            indexSave[index] = indexSave[index] == -1 ? i : -2;
        }
        int min = s.length();
        for (int i : indexSave) {
            if (i > -1){
                min = Math.min(min,i);
            }
        }
        return min == s.length() ? -1 : min;
    }
}
