package org.zongjieli.leetcode.question.daily.year2021.month11.week4;
/**
 * 给定两个字符串 s 和 goal
 * 只要可以通过交换 s 中的两个字母得到与 goal 相等的结果,就返回 true,否则返回 false
 * 交换字母的定义是:
 *  取两个下标 i 和 j(下标从 0 开始)且满足 i != j
 *  接着交换 s[i] 和 s[j] 处的字符
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad"
 *
 * 1 <= s.length, goal.length <= 2 * 10^4
 * s 和 goal 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/11/23
 * @version  1.0
 */
public class Z2CloseString {
    public boolean buddyStrings(String s, String goal) {
        int length = s.length();
        if (length != goal.length()){
            return false;
        }
        int different = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0 ; i < length ; i++){
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            if (c1 != c2){
                different++;
            }
            count1[c1 - 'a']++;
            count2[c2 - 'a']++;
        }
        if (different > 2 || different == 1){
            return false;
        }
        int sameMax = 0;
        for (int i = 0 ; i < 26 ; i++){
            if (count1[i] != count2[i]){
                return false;
            }
            sameMax = Math.max(sameMax, count1[i]);
        }
        return different == 2 || sameMax >= 2;
    }
}
