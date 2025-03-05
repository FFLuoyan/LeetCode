package org.zongjieli.leetcode.question.daily.year2025.month3.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s,请将 s 分割成一些子串,使每个子串都是回文串,返回 s 所有可能的分割方案
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/5
 */
public class Z6SplitPalindrome {

    List<List<String>> result;

    private byte[] values;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        values = s.getBytes();
        partition(new ArrayList<>(), 0, values.length - 1);
        return result;
    }

    public void partition(List<String> current, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPalindrome(start, i)) {
                List<String> temp = new ArrayList<>(current);
                temp.add(new String(values, start, i - start + 1));
                if (i == end) {
                    result.add(temp);
                } else {
                    partition(temp, i + 1, end);
                }
            }
        }
    }

    public boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (values[start] != values[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
