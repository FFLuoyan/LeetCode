package org.zongjieli.leetcode.question.daily.year2022.month11.week1;

/**
 * 给定两个字符串数组 word1 和 word2,如果两个数组表示的字符串相同,返回 true,否则返回 false
 * 数组表示的字符串是由数组中的所有元素按顺序连接形成的字符串
 *
 * 1 <= word1.length, word2.length <= 10^3
 * 1 <= word1[i].length, word2[i].length <= 10^3
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 * word1[i] 和 word2[i] 由小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/11/1
 */
public class Z2StringEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
