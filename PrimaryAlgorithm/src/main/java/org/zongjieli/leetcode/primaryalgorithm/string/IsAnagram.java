package org.zongjieli.leetcode.primaryalgorithm.string;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: IsAnagram
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/1
 * @Version: 1.0
 **/
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] charArray = new int[26];
        for (int index = 0 ; index < s.length() ; index++){
            charArray[s.charAt(index) - 'a'] ++;
            charArray[t.charAt(index) - 'a'] --;
        }
        for (int index = 0 ; index < 26 ; index ++){
            if (charArray[index] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String first = "xaaddbby";
        String second = "xbbccaay";
        System.out.println(isAnagram(first, second));
    }
}
