package org.zongjieli.leetcode.algorithm.primary.string;

import java.util.HashMap;
import java.util.Map;

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
        boolean[] charExist = new boolean[26];
        Map<Character,Integer> unique = new HashMap<>(26);
        for (int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            if (!charExist[currentChar - 'a']){
                unique.put(currentChar,i);
                charExist[currentChar - 'a'] = true;
            } else {
                unique.remove(currentChar);
            }
        }
        if (unique.size() == 0){
            return -1;
        }
        return unique.values().stream().min(Integer::compareTo).get();
    }
}
