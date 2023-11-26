package org.zongjieli.leetcode.competion.singleweekly.order373;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个正整数 k
 * 用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量
 * 如果某个字符串满足以下条件,则称其为美丽字符串:
 *  vowels == consonants,即元音字母和辅音字母的数量相等
 *  (vowels * consonants) % k == 0,即元音字母和辅音字母的数量的乘积能被 k 整除
 * 返回字符串 s 中非空美丽子字符串的数量
 * 子字符串是字符串中的一个连续字符序列
 * 英语中的元音字母为 'a', 'e', 'i', 'o', 'u'
 * 英语中的辅音字母为除了元音字母之外的所有字母
 *
 * 1 <= s.length <= 1000
 * 1 <= k <= 1000
 * s 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/26
 */
public class O373N2CountBeauty {

    public int beautifulSubstrings(String s, int k) {
        int[][] temp = new int[s.length()][2];
        int index = 0, result = 0;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (char c : s.toCharArray()) {
            int addIndex = vowels.contains(c) ? 0 : 1;
            for (int i = 0; i <= index; i++) {
                temp[i][addIndex]++;
                if (temp[i][0] == temp[i][1] && (temp[i][0] * temp[i][1]) % k == 0) {
                    result++;
                }
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        O373N2CountBeauty test = new O373N2CountBeauty();
        // 2
        System.out.println(test.beautifulSubstrings("baeyh", 2));
    }
}
