package org.zongjieli.leetcode.question.daily.year2025.month3.week2;

/**
 * 给定一个由小写字母组成的字符串 s 和一个整数 k
 * 请按下面的要求分割字符串:
 *  首先,可以将 s 中的部分字符修改为其他的小写英文字母
 *  接着,需要把 s 分割成 k 个非空且不相交的子串,并且每个子串都是回文串
 *  请返回以这种方式分割字符串所需修改的最少字符数
 *
 * 1 <= k <= s.length <= 100
 * s 中只含有小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/3
 */
public class Z1PalindromeSplit {

    // 表示字符串 s 下标 [a, b] 分割 c 次所需修改的最小字符串
    private int[][][] splitCount;

    public int palindromePartition(String s, int k) {
        splitCount = new int[s.length() + 1][s.length() + 1][k + 1];
        byte[] values = s.getBytes();
        return palindromePartition(values, k, 0, s.length() - 1);
    }

    public int palindromePartition(byte[] values, int k, int start, int end) {
        if (splitCount[start][end][k] != 0) return splitCount[start][end][k];
        if (end - start == k - 1) {
            return 0;
        }
        if (k == 1) {
            if (start >= end) {
                return 0;
            }
            return splitCount[start][end][k] = (palindromePartition(values, k, start + 1, end - 1) + (values[start] == values[end] ? 0 : 1));
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end - k + 1; i++) {
            // i 表示左边区间的右边界,左边区间的 k 恒定为 1,长度最大为 end - k + 1
            min = Math.min(min, palindromePartition(values, 1, start, i) + palindromePartition(values, k - 1, i + 1, end));
        }
        return splitCount[start][end][k] = min;
    }

    public static void main(String[] args) {
        Z1PalindromeSplit test = new Z1PalindromeSplit();
        // 1
        System.out.println(test.palindromePartition("abc", 2));
        // 0
        System.out.println(test.palindromePartition("aabbc", 3));
        // 0
        System.out.println(test.palindromePartition("faaglagedtwnejzpuarkgwgoefwra", 27));
        // 2
        System.out.println(test.palindromePartition("tcymekt", 4));
    }
}
