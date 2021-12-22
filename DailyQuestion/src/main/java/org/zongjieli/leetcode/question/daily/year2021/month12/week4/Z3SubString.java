package org.zongjieli.leetcode.question.daily.year2021.month12.week4;
/**
 * 给定两个字符串 a 和 b,寻找重复叠加字符串 a 的最小次数
 * 使得字符串 b 成为叠加后的字符串 a 的子串,如果不存在则返回 -1
 * 注意:
 *  字符串 "abc" 重复叠加 0 次是 "",重复叠加 1 次是 "abc",重复叠加 2 次是 "abcabc"
 *  
 * 1 <= a.length <= 10^4
 * 1 <= b.length <= 10^4
 * a 和 b 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/12/22
 * @version  1.0
 */
public class Z3SubString {
    public int repeatedStringMatch(String a, String b) {
        byte[] aBytes = a.getBytes();
        byte[] bBytes = b.getBytes();

        // b 的起点在 a 的下标位置
        for (int bStart = 0 ; bStart < aBytes.length ; bStart++){
            int bIndex = 0;
            int aIndex = bStart;
            int result = 1;
            for (; bIndex < bBytes.length ; aIndex++, bIndex++){
                if (aIndex == aBytes.length){
                    aIndex = 0;
                    result++;
                }
                if (aBytes[aIndex] != bBytes[bIndex]){
                    break;
                }
            }
            if (bIndex == bBytes.length){
                return result;
            }

        }
        return -1;
    }
}
