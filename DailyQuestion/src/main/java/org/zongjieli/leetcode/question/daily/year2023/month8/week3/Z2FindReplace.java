package org.zongjieli.leetcode.question.daily.year2023.month8.week3;

import java.util.Arrays;

/**
 * 一个字符串 s(索引从 0 开始),必须对它执行 k 个替换操作
 * 替换操作以三个长度均为 k 的并行数组给出：indices, sources, targets
 * 要完成第 i 个替换操作:
 *  检查子字符串 sources[i] 是否出现在原字符串 s 的索引 indices[i] 处
 *  如果没有出现,什么也不做
 *  如果出现,则用 targets[i] 替换该子字符串
 * 例如: 如果 s = "abcd", indices[i] = 0, sources[i] = "ab", targets[i] = "eee"
 * 那么替换的结果将是 "eeecd"
 * 所有替换操作必须同时发生, 这意味着替换操作不应该影响彼此的索引,测试用例保证元素间不会重叠
 * 例如,一个 s = "abc", indices = [0,1], sources = ["ab", "bc"] 的测试用例将不会生成
 * 因为 "ab" 和 "bc" 替换重叠
 * 在对 s 执行所有替换操作后返回结果字符串
 * 子字符串是字符串中连续的字符序列
 *
 * 1 <= s.length <= 1000
 * k == indices.length == sources.length == targets.length
 * 1 <= k <= 100
 * 0 <= indexes[i] < s.length
 * 1 <= sources[i].length, targets[i].length <= 50
 * s 仅由小写英文字母组成
 * sources[i] 和 targets[i] 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/15
 */
public class Z2FindReplace {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int length = s.length();
        int[] existIndex = new int[length];
        Arrays.fill(existIndex, -1);
        for (int i = 0; i < indices.length; i++) {
            existIndex[indices[i]] = i;
        }
        int compareIndex = 0;
        StringBuilder sb = new StringBuilder();
        char[] sArray = s.toCharArray();
        while (compareIndex < length) {
            if (existIndex[compareIndex] != -1) {
                int sourceIndex = 0, sIndex = compareIndex;
                String source = sources[existIndex[compareIndex]];
                while (sourceIndex < source.length() && sIndex < length && source.charAt(sourceIndex) == sArray[sIndex]) {
                    sourceIndex++;
                    sIndex++;
                }
                if (sourceIndex == source.length()) {
                    sb.append(targets[existIndex[compareIndex]]);
                    compareIndex += source.length();
                } else {
                    sb.append(sArray[compareIndex++]);
                }
            } else {
                sb.append(sArray[compareIndex++]);
            }
        }
        return sb.toString();
    }

}
