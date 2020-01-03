package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: RevertString
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/30
 * @Version: 1.0
 **/
public class RevertString {
    public static void revertString(char[] s) {
        int loopLength = s.length / 2;
        for (int index = 0; index < loopLength; index++) {
            char temp = s[index];
            int indexChange = s.length - index - 1;
            s[index] = s[indexChange];
            s[indexChange] = temp;
        }
    }

    public static void main(String[] args) {
        char[] newString = new char[]{'a', 'b', 'b', 'c', 'd'};
        revertString(newString);
        System.out.println(newString);
    }
}
