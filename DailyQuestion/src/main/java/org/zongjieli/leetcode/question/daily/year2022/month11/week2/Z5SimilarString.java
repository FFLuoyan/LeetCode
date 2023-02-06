package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

/**
 * 给定一个偶数长度的字符串 s,将其拆分成长度相同的两半,前一半为 a,后一半为 b
 * 两个字符串相似的前提是它们都含有相同数目的元音('a','e','i','o','u','A','E','I','O','U')
 * 注意,s 可能同时含有大写和小写字母
 * 如果 a 和 b 相似,返回 true,否则返回 false
 *
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由大写和小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z5SimilarString {

    public boolean halvesAreAlike(String s) {
        int[] ls = new int[128], rs = new int[128];
        byte[] values = s.getBytes();
        int lc = 0, rc = s.length() - 1;
        while (lc < rc) {
            ls[values[lc++]]++;
            rs[values[rc--]]++;
        }
        return ls['a'] + ls['A'] + ls['e']+ ls['E'] + ls['i'] + ls['I'] + ls['o'] + ls['O'] + ls['u'] + ls['U']
                == rs['a'] + rs['A'] + rs['e'] + rs['E'] + rs['i'] + rs['I'] + rs['o'] + rs['O'] + rs['u'] + rs['U'];
    }

    public static void main(String[] args) {
        Z5SimilarString test = new Z5SimilarString();
        // true
        System.out.println(test.halvesAreAlike("AbCdEfGh"));
    }

}
