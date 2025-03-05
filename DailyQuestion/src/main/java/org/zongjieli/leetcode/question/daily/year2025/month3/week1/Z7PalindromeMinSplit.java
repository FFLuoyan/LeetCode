package org.zongjieli.leetcode.question.daily.year2025.month3.week1;

/**
 * 给定一个字符串 s,请将 s 分割成一些子串,使每个子串都是回文串
 * 返回符合要求的最少分割次数
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/5
 */
public class Z7PalindromeMinSplit {

    public byte[] values;

    // 0 表示未计算,1 表示非回文,2 表示为是回文
    // 当 a < b 时
    // [a][b] 表示 [a, b] 区间是否计算
    // 当 a > b 时
    // [a][b] 表示 [b, a] 区间的最小分割次数
    public int[][] isPalindrome;

    public int minCut(String s) {
        values = s.getBytes();
        isPalindrome = new int[values.length][values.length];
        return minCut(0, values.length - 1);
    }

    public int minCut(int start, int end) {
        if (isPalindrome[end][start] != 0) {
            return isPalindrome[end][start];
        }
        if (start >= end || isPalindrome(start, end)) {
            return 0;
        }
        int min = end - start;
        for (int i = start; i < end; i++) {
            // 如果 [start, i] 是回文串,则计算 [i + 1, end] 的最小值
            if (isPalindrome(start, i)) {
                min = Math.min(min, minCut(i + 1, end) + 1);
            }
        }
        return isPalindrome[end][start] = min;
    }

    public boolean isPalindrome(int start, int end) {
        if (isPalindrome[start][end] > 0) {
            return isPalindrome[start][end] == 2;
        }
        if (start >= end) {
            isPalindrome[start][end] = 2;
            return true;
        }
        boolean isPalindromeBoolean = (values[start] == values[end] && isPalindrome(start + 1, end - 1));
        isPalindrome[start][end] = isPalindromeBoolean ? 2 : 1;
        return isPalindromeBoolean;
    }

    public static void main(String[] args) {
        Z7PalindromeMinSplit test = new Z7PalindromeMinSplit();
        // 452
        System.out.println(test.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}
