package org.zongjieli.leetcode.competion.doubleweekly.order115;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n 和一个下标从 0 开始的字符串数组 words
 * 和一个下标从 0 开始的数组 groups,两个数组长度都是 n
 * 两个长度相等字符串的汉明距离定义为对应位置字符不同的数目
 * 需要从下标 [0, 1, ..., n - 1] 中选出一个最长子序列
 * 将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1],它需要满足以下条件:
 *  相邻下标对应的 groups 值不同,即,对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1]
 *  对于所有 0 < j + 1 < k 的下标 j,都满足 words[ij] 和 words[ij + 1] 的长度相等,且两个字符串之间的汉明距离为 1
 * 请返回一个字符串数组,它是下标子序列依次对应 words 数组中的字符串连接形成的字符串数组
 * 如果有多个答案,返回任意一个
 * 子序列指的是从原数组中删掉一些(也可能一个也不删掉)元素,剩余元素不改变相对位置得到的新的数组
 * 注意: words 中的字符串长度可能不相等
 *
 * 1 <= n == words.length == groups.length <= 1000
 * 1 <= words[i].length <= 10
 * 1 <= groups[i] <= n
 * words 中的字符串互不相同
 * words[i] 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/14
 */
public class O115N3LongestSubsequence {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<List<Integer>> possible = new ArrayList<>();
        for (int i = 0; i < groups.length; i++) {
            int group = groups[i], maxIndex = -1, maxLength = 0;
            for (int j = 0; j < possible.size(); j++) {
                List<Integer> current = possible.get(j);
                int lastIndex = current.get(current.size() - 1);
                if (groups[lastIndex] != group && current.size() > maxLength && canConnect(words[lastIndex], words[i])) {
                    maxIndex = j;
                    maxLength = current.size();
                }
            }
            List<Integer> add = maxIndex == -1 ? new ArrayList<>() : new ArrayList<>(possible.get(maxIndex));
            add.add(i);
            possible.add(add);
        }
        int max = 0, maxIndex = 0;
        for (int i = 0; i < possible.size(); i++) {
            List<Integer> current = possible.get(i);
            if (current.size() > max) {
                max = current.size();
                maxIndex = i;
            }
        }
        List<String> result = new ArrayList<>();
        for (Integer i : possible.get(maxIndex)) {
            result.add(words[i]);
        }
        return result;
    }

    public boolean canConnect(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        O115N3LongestSubsequence test = new O115N3LongestSubsequence();
        // ["bab", "dab"]
        System.out.println(test.getWordsInLongestSubsequence(3, new String[]{"bab", "dab", "cab"}, new int[]{1, 2, 2}));
        // ["dc","dd","da"]
        System.out.println(test.getWordsInLongestSubsequence(9, new String[]{"bad","dc","bc","ccd","dd","da","cad","dba","aba"}, new int[]{9,7,1,2,6,8,3,7,2}));
    }

}
