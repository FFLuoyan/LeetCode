package org.zongjieli.leetcode.question.daily.year2024.month1.week1;

/**
 * 给定两个字符串: ransomNote 和 magazine
 * 判断 ransomNote 能不能由 magazine 里面的字符构成
 * 如果可以,返回 true,否则返回 false
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 *
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/24
 */
public class Z7ContainChars {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int['z' + 1];
        for (byte b : ransomNote.getBytes()) {
            count[b]--;
        }
        for (byte b : magazine.getBytes()) {
            count[b]++;
        }
        for (int i = 'a' ; i <= 'z' ; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }

}
