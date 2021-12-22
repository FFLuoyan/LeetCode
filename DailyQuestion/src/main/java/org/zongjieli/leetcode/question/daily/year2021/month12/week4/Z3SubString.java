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
        int multiple = (b.length() - 1) / a.length() + 1;
        StringBuilder aDuplicate = new StringBuilder(a.length() * multiple);
        for (int i = 0 ; i < multiple ; i++){
            aDuplicate.append(a);
        }
        if (aDuplicate.toString().contains(b)){
            return multiple;
        }
        aDuplicate.append(a);
        return aDuplicate.toString().contains(b) ? multiple + 1 : -1;
    }
}
