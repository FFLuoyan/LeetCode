package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

/**
 * @ClassName: LongestPalindromeSubarray
 * @Description: 给定一个字符串, 找出其最大的回文子字符串
 * @Author: Zongjie.Li
 * @Date: 2020/4/17
 * @Version: 1.0
 **/
public class LongestPalindromeSubarray {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[] palindromeCan = new boolean[chars.length];
        int startIndex = 0;
        int endIndex = 1;
        for (int charIndex = 1;charIndex < chars.length;charIndex++){
            // 字符串的每一个值开始循环
            // 循环的目的,去 can 数组中比较,如果为 true,说明为指定值时会产生回文字符串
            palindromeCan[charIndex] = true;
            palindromeCan[charIndex - 1] = true;
            for (int canIndex = 0 ; canIndex < charIndex;canIndex++){
                if (palindromeCan[canIndex + 1]){
                    // 如果后一个位置可以组成回文字符串
                    // 则对数组进行比较
                    if (chars[charIndex] == chars[canIndex]){
                        // 如果比较字符与需要字符相等,说明当前位置在下一轮循环中也可以构成回文字符串
                        palindromeCan[canIndex] = true;
                        if (charIndex + 1 - canIndex > endIndex - startIndex){
                            startIndex = canIndex;
                            endIndex = charIndex + 1;
                        }
                    } else {
                        palindromeCan[canIndex] = false;
                    }
                }
            }
        }
        return s.substring(startIndex,endIndex);
    }

    public static void main(String[] args) {
        LongestPalindromeSubarray subarray = new LongestPalindromeSubarray();
        System.out.println(subarray.longestPalindrome("aaabaaaa"));
    }

}
