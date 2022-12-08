package org.zongjieli.leetcode.question.daily.year2022.month12.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 word,该字符串由数字和小写英文字母组成
 * 请用空格替换每个不是数字的字符,例如,"a123bc34d8ef34" 将会变成 " 123  34 8  34"
 * 注意,剩下的这些整数为(相邻彼此至少有一个空格隔开):"123"、"34"、"8" 和 "34"
 * 返回对 word 完成替换后形成的不同整数的数目
 * 只有当两个整数的不含前导零的十进制表示不同,才认为这两个整数也不同
 *
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/7
 */
public class Z2DifferentCount {

    public int numDifferentIntegers(String word) {
        Set<String> count = new HashSet<>();
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0 ; i < word.length() ; i++) {
            char currentChar = word.charAt(i);
            if (currentChar >= 'a') {
                if (currentNumber.length() > 0) {
                    count.add(currentNumber.toString());
                    currentNumber = new StringBuilder();
                }
            } else if (currentNumber.length() == 1 && currentNumber.charAt(0) == '0') {
                currentNumber.setCharAt(0, currentChar);
            } else {
                currentNumber.append(currentChar);
            }
        }
        if (currentNumber.length() > 0) {
            count.add(currentNumber.toString());
        }
        return count.size();
    }

    public static void main(String[] args) {
        Z2DifferentCount test = new Z2DifferentCount();
        // 4
        System.out.println(test.numDifferentIntegers("8b43121380705329e43121380705329u43121380705329p43121380705329x83mt37te"));
    }
}
