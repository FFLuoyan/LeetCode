package org.zongjieli.leetcode.question.daily.year2022.month10.week4;

/**
 * 给定两个字符串 word1 和 word2
 * 请从 word1 开始,通过交替添加字母来合并字符串
 * 如果一个字符串比另一个字符串长,就将多出来的字母追加到合并后字符串的末尾
 * 返回合并后的字符串
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/1
 */
public class Z7MergeString {

    public String mergeAlternately(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        char[] result = new char[s1.length + s2.length];
        int i1 = 0, i2 = 0, ir = 0;
        while (i1 < s1.length && i2 < s2.length) {
            result[ir++] = s1[i1++];
            result[ir++] = s2[i2++];
        }
        while (i1 < s1.length) {
            result[ir++] = s1[i1++];
        }
        while (i2 < s2.length) {
            result[ir++] = s2[i2++];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Z7MergeString test = new Z7MergeString();
        // apbqcr
        System.out.println(test.mergeAlternately("abc", "pqr"));
        // apbqrs
        System.out.println(test.mergeAlternately("ab", "pqrs"));
    }

}
