package org.zongjieli.leetcode.question.daily.year2022.month3.week3;

import java.util.*;

/**
 * 给出一个字符串数组 words 组成的一本英语词典
 * 返回 words 中最长的一个单词,该单词是由 words 词典中其他单词逐步添加一个字母组成
 * 若其中有多个可行的答案,则返回答案中字典序最小的单词,若无答案则返回空字符串
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母
 *
 * @author   Li.zongjie
 * @date     2022/3/17
 * @version  1.0
 */
public class Z4LongestWord {

    public String longestWord(String[] words) {
        Set<String> all = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> {
            int aSize = a.length();
            int bSize = b.length();
            return aSize != bSize ? Integer.compare(bSize, aSize) : a.compareTo(b);
        });
        for (String word : words) {
            String current = word;
            int length = current.length();
            while (length > 0 && all.contains(current)) {
                current = current.substring(0, --length);
            }
            if (length == 0) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Z4LongestWord test = new Z4LongestWord();
        // abcd
        System.out.println(test.longestWord(new String[]{"a","ab","abc","abcd"}));
        // apple
        System.out.println(test.longestWord(new String[]{"a","ap","app","appl", "apple", "apply", "banana"}));
        // eyj
        System.out.println(test.longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}));
        // yodn
        System.out.println(test.longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));
        // latte
        System.out.println(test.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"}));
        // otif
        System.out.println(test.longestWord(new String[]{"rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"}));
    }
}
