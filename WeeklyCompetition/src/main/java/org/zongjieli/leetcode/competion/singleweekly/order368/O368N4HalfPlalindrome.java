package org.zongjieli.leetcode.competion.singleweekly.order368;

/**
 * 给定一个字符串 s 和一个整数 k,请将 s 分成 k 个子字符串
 * 使得每个子字符串变成半回文串需要修改的字符数目最少
 * 请返回一个整数,表示需要修改的最少字符数目
 * 注意:
 *  如果一个字符串从左往右和从右往左读是一样的,那么它是一个回文串
 *  如果长度为 len 的字符串存在一个满足 1 <= d < len 的正整数 d,len % d == 0 成立
 *  且所有对 d 做除法余数相同的下标对应的字符连起来得到的字符串都是回文串
 *  那么这个字符串是半回文串,比方说 "aa", "aba", "adbgad" 和 "abab" 都是半回文串
 *  而 "a", "ab" 和 "abca" 不是
 * 子字符串指的是一个字符串中一段连续的字符序列
 *
 * 2 <= s.length <= 200
 * 1 <= k <= s.length / 2
 * s 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/22
 */
public class O368N4HalfPlalindrome {

    boolean[][][] calculate;
    int[][][] count;

    byte[] values;

    public int minimumChanges(String s, int k) {
        values = s.getBytes();
        int length = values.length;
        calculate = new boolean[length][length][k];
        count = new int[length][length][k];
        int result = getResult(0, length - 1, k - 1);
        return result;
    }

    public int getMin(int start, int end) {
        if (calculate[start][end][0]) {
            return count[start][end][0];
        }
        int length = end - start + 1;
        int min = 0;
        int left = start, right = end;
        while (left < right) {
            if (values[left++] != values[right--]) {
                min++;
            }
        }
        for (int subLength = length / 2 ; subLength >= 1 ; subLength--) {
            if (length % subLength == 0) {
                int result = 0;
                for (int remain = 0 ; remain < subLength ; remain++) {
                    left = start + remain;
                    right = (end - subLength  + remain + 1);
                    while (left  < right) {
                        if (values[left] != values[right]) {
                            result++;
                        }
                        left += subLength;
                        right -= subLength;
                    }
                }
                min = Math.min(min, result);
            }
        }
        calculate[start][end][0] = true;
        return count[start][end][0] = min;
    }


    public int getResult(int start, int end, int k) {
        if (calculate[start][end][k]) {
            return count[start][end][k];
        }
        int length =  end - start + 1;
        int maxSubLength = length - 2 * k;
        int min = Integer.MAX_VALUE;
        if (k == 0) {
            min = getMin(start, end);
        } else {
            for (int subLength = 2 ; subLength <= maxSubLength ; subLength++) {
                min = Math.min(min, getMin(start, start + subLength - 1) + getResult(start + subLength, end, k - 1));
            }
        }

        calculate[start][end][k] = true;
        return count[start][end][k] = min;
    }
    public static void main(String[] args) {
        O368N4HalfPlalindrome test = new O368N4HalfPlalindrome();
        // 1
        System.out.println(test.minimumChanges("aac", 1));
        // 1
        System.out.println(test.minimumChanges("ccccaaacca", 2));
    }
}
