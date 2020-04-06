package org.zongjieli.leetcode.algorithm.primary.string;

/**
 * @ClassName: LongestCommonPrefix
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/10
 * @Version: 1.0
 **/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        strs[0].indexOf("aaa");
        for (int i = 1; i < strs.length; i++) {
            length = length < strs[i].length() ? length : strs[i].length();
        }
        for (int i = 0; i < length; i++) {
            char equalChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (equalChar != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, length);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aaa", "asdasdas", "adaaaaa"};
        System.out.println(longestCommonPrefix(strings));
    }
}
