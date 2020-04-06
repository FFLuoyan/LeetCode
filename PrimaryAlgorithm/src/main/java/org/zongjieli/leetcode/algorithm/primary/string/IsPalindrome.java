package org.zongjieli.leetcode.algorithm.primary.string;

/**
 * @ClassName: IsPalindrom
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/2
 * @Version: 1.0
 **/
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        char[] stringArray = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = stringArray.length - 1;
        while (leftIndex < rightIndex) {
            while (!isChar(stringArray, leftIndex)) {
                leftIndex++;
                if (leftIndex == stringArray.length - 1) {
                    return true;
                }
            }
            while (!isChar(stringArray, rightIndex) && rightIndex > 0) {
                --rightIndex;
            }
            if (stringArray[leftIndex] != stringArray[rightIndex]) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static boolean isChar(char[] charArray, int index) {
        if ((charArray[index] >= '0' && charArray[index] <= '9')
                || charArray[index] >= 'A' && charArray[index] <= 'Z') {
            return true;
        } else if (charArray[index] >= 'a' && charArray[index] <= 'z') {
            charArray[index] -= 32;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
