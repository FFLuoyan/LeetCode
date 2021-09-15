package org.zongjieli.leetcode.question.daily.year2021.month9.week3;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典
 * 找出并返回字典中最长的字符串,该字符串可以通过删除 s 中的某些字符得到
 *
 * 如果答案不止一个,返回长度最长且字典序最小的字符串
 * 如果答案不存在,则返回空字符串
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2021/9/14
 * @version  1.0
 */
public class Z2FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        int[][] findAll = new int[s.length()][26];
        int[] find = new int[26];
        Arrays.fill(find, -1);
        for (int i = s.length() - 1 ; i >= 0 ; i--){
            findAll[i] = Arrays.copyOf(find,find.length);
            find[s.charAt(i) - 'a'] = i;
        }
        String[] result = new String[]{""};
        dictionary.forEach(d -> {
            int[] currentFind = find;
            for (int i = 0 ; i < d.length() ; i++){
                int nextIndex = currentFind[d.charAt(i) - 'a'];
                if (nextIndex == -1){
                    return;
                }
                currentFind = findAll[nextIndex];
            }
            if (d.length() > result[0].length() || (d.length() == result[0].length() && d.compareTo(result[0]) < 0)){
                result[0] = d;
            }
        });
        return result[0];
    }

    public static void main(String[] args) {
        Z2FindLongestWord test = new Z2FindLongestWord();
        System.out.println(test.findLongestWord("abce", Arrays.asList("abe","abc")));// abc
        System.out.println(test.findLongestWord("bab", Arrays.asList("ba","ab","a","b"))); // ab
        System.out.println(test.findLongestWord("aaa", Arrays.asList("aaa","aa","a"))); // aaa
    }
}
