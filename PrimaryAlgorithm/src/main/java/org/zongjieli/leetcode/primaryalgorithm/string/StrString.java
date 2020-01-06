package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: StrString
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/4
 * @Version: 1.0
 **/
public class StrString {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        outer:
        for (int hIndex = 0; hIndex + needleArr.length <= haystackArr.length; hIndex++) {
            if (haystackArr[hIndex] == needleArr[0]) {
                for (int nIndex = 1; nIndex < needleArr.length; nIndex++) {
                    if (haystackArr[hIndex + nIndex] != needleArr[nIndex]) {
                        continue outer;
                    }
                }
                return hIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
