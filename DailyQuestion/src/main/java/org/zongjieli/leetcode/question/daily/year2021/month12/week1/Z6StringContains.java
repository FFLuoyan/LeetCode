package org.zongjieli.leetcode.question.daily.year2021.month12.week1;
/**
 * 为了不在赎金信中暴露字迹,从杂志上搜索各个需要的字母,组成单词来表达意思
 * 给定一个赎金信(ransomNote)字符串和一个杂志(magazine)字符串
 * 判断 ransomNote 能不能由 magazines 里面的字符构成
 * 如果可以构成,返回 true,否则返回 false
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 *
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/12/4
 * @version  1.0
 */
public class Z6StringContains {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0 ; i < ransomNote.length() ; i++){
            count[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0 ; i < magazine.length() ; i++){
            count[magazine.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i > 0){
                return false;
            }
        }
        return true;
    }
}
