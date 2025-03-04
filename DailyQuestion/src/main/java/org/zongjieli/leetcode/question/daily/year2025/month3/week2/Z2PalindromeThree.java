package org.zongjieli.leetcode.question.daily.year2025.month3.week2;


/**
 * 给定一个字符串 s,如果可以将它分割成三个非空回文子字符串,那么返回 true,否则返回 false
 * 当一个字符串正着读和反着读是一模一样的,就称其为回文字符串
 *
 * 3 <= s.length <= 2000
 * s 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/3/4
 */
public class Z2PalindromeThree {

    byte[] values;

    // 0: 未检查, 1: 不是回文串, 2: 是回文串
    int[][] palindromeCheck;

    public boolean checkPartitioning(String s) {
        values = s.getBytes();
        palindromeCheck = new int[values.length][values.length];

        for (int i = 0; i < s.length() - 2; i++) {
            if (!isPalindrome(0, i)) {
                continue;
            }
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (isPalindrome(i + 1, j) && isPalindrome(j + 1, s.length() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPalindrome(int start, int end) {
        if (palindromeCheck[start][end] != 0) {
            return palindromeCheck[start][end] == 2;
        }
        if (start >= end) {
            palindromeCheck[start][end] = 2;
            return true;
        }
        boolean isPalindrome = values[start] == values[end] && isPalindrome(start + 1, end - 1);
        palindromeCheck[start][end] = isPalindrome ? 2 : 1;
        return isPalindrome;
    }

    public static void main(String[] args) {
        Z2PalindromeThree test = new Z2PalindromeThree();
        // true
        System.out.println(test.checkPartitioning("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttxxvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"));
    }
}
