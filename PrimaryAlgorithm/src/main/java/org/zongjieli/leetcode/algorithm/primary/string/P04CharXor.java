package org.zongjieli.leetcode.algorithm.primary.string;
/**
 * 给定两个字符串 s 和 t
 * 编写一个函数来判断 t 是否是 s 的字母异位词
 * 若 s 和 t 中每个字符出现的次数都相同
 * 则称 s 和 t 互为字母异位词。
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 *
 * @author   Li.zongjie
 * @date     2021/11/9
 * @version  1.0
 */
public class P04CharXor {
    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if (length != t.length()){
            return false;
        }
        int[] count = new int[128];
        for (int i = 0 ; i < length ; i++){
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i = 97 ; i <= 122 ; i++){
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
