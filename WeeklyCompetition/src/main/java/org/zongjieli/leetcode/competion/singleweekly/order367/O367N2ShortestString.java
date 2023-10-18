package org.zongjieli.leetcode.competion.singleweekly.order367;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二进制字符串 s 和一个正整数 k
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k,则称这个子字符串是一个美丽子字符串
 * 令 len 等于最短美丽子字符串的长度
 * 返回长度等于 len 且字典序最小的美丽子字符串
 * 如果 s 中不含美丽子字符串,则返回一个空字符串
 * 对于相同长度的两个字符串 a 和 b,如果在 a 和 b 出现不同的第一个位置上
 * a 中该位置上的字符严格大于 b 中的对应字符,则认为字符串 a 字典序大于字符串 b
 * 例如,"abcd" 的字典序大于 "abcc",因为两个字符串出现不同的第一个位置对应第四个字符,而 d 大于 c
 *
 * 1 <= s.length <= 100
 * 1 <= k <= s.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/15
 */
public class O367N2ShortestString {

    public String shortestBeautifulSubstring(String s, int k) {
        int index = -1;
        List<Integer> indexes = new ArrayList<>();
        while ((index = s.indexOf('1', index + 1)) != -1) {
            indexes.add(index);
        }
        List<String> results = new ArrayList<>();
        for (int i = 0; i < indexes.size(); i++) {
            if (i + k - 1 >= indexes.size()) {
                break;
            }
            results.add(s.substring(indexes.get(i), indexes.get(i + k - 1) + 1));
        }
        if (results.isEmpty()) {
            return "";
        }
        results.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });
        return results.get(0);
    }


}
