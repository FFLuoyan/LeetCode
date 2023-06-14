package org.zongjieli.leetcode.question.daily.year2023.month6.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s,请对 s 的子串进行检测
 * 每次检测,待检子串都可以表示为 queries[i] = [left, right, k]
 * 可以重新排列子串 s[left], ..., s[right],并从中选择最多 k 项替换成任何小写英文字母
 * 如果在上述检测过程中,子串可以变成回文形式的字符串,那么检测结果为 true,否则结果为 false
 * 返回答案数组 answer[],其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果
 * 注意: 在替换时,子串中的每个字母都必须作为独立的项进行计数
 * 也就是说.如果 s[left..right] = "aaa" 且 k = 2,只能替换其中的两个字母
 * 另外,任何检测都不会修改原始字符串 s,可以认为每次检测都是独立的
 *
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/15
 */
public class Z4PalindromeCheck {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        byte[] values = s.getBytes();
        int change = 0;
        int[] changes = new int[values.length + 1];
        for (int i = 0; i < values.length; i++) {
            changes[i + 1] = (change ^= (1 << (values[i] - 'a')));
        }
        for (int[] query : queries) {
            result.add(Integer.bitCount(changes[query[1] + 1] ^ changes[query[0]]) / 2 <= query[2]);
        }
        return result;
    }

    public static void main(String[] args) {
        Z4PalindromeCheck test = new Z4PalindromeCheck();
        // true, true, true, true
        System.out.println(test.canMakePaliQueries("shezu", new int[][]{{3, 3, 1}, {3, 4, 2}, {2, 2, 1}, {3, 4, 2}}));
    }

}
