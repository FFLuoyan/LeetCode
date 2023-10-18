package org.zongjieli.leetcode.competion.doubleweekly.order115;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n 和一个下标从 0 开始的字符串数组 words
 * 和一个下标从 0 开始的二进制数组 groups,两个数组长度都是 n
 * 需要从下标 [0, 1, ..., n - 1] 中选出一个最长子序列
 * 将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1]
 * 对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1]
 * 请返回一个字符串数组,它是下标子序列依次对应 words 数组中的字符串连接形成的字符串数组
 * 如果有多个答案,返回任意一个
 * 子序列指的是从原数组中删掉一些(也可能一个也不删掉)元素,剩余元素不改变相对位置得到的新的数组
 * 注意: words 中的字符串长度可能不相等
 *
 * 1 <= n == words.length == groups.length <= 100
 * 1 <= words[i].length <= 10
 * 0 <= groups[i] < 2
 * words 中的字符串互不相同
 * words[i] 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/14
 */
public class O115N2LongestSubsequence {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[][] startByIndex = new int[2][102];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == 0) {
                if (startByIndex[0][101] % 2 == 0) {
                    startByIndex[0][startByIndex[0][101]++] = i;
                }
                if (startByIndex[1][101] % 2 == 1) {
                    startByIndex[1][startByIndex[1][101]++] = i;
                }
            } else {
                if (startByIndex[0][101] % 2 == 1) {
                    startByIndex[0][startByIndex[0][101]++] = i;
                }
                if (startByIndex[1][101] % 2 == 0) {
                    startByIndex[1][startByIndex[1][101]++] = i;
                }
            }
        }
        int[] indexes = startByIndex[0][101] >= startByIndex[1][101] ? startByIndex[0] : startByIndex[1];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < indexes[101]; i++) {
            result.add(words[indexes[i]]);
        }
        return result;
    }

}
