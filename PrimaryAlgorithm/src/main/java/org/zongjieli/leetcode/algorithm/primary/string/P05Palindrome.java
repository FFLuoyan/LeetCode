package org.zongjieli.leetcode.algorithm.primary.string;
/**
 * 给定一个字符串,验证它是否是回文串
 * 只考虑字母和数字字符,可以忽略字母的大小写
 * 空字符串为有效的回文串
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
 *
 * @author   Li.zongjie
 * @date     2021/11/9
 * @version  1.0
 */
public class P05Palindrome {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int left = 0,right = charArray.length - 1;
        while (left < right){
            char leftChar = charArray[left];
            if (leftChar < 48 || (leftChar > 57 && leftChar < 65) || leftChar > 122 || (leftChar > 90 && leftChar < 97)){
                left++;
                continue;
            }
            char rightChar = charArray[right];
            if (rightChar < 48 || (rightChar > 57 && rightChar < 65) || rightChar > 122 || (rightChar > 90 && rightChar < 97)){
                right--;
                continue;
            }

            if (leftChar >= 97){
                leftChar -= 32;
            }

            if (rightChar >= 97){
                rightChar -= 32;
            }

            if (rightChar != leftChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
