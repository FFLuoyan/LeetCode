package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: FirstUniqueChar
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/30
 * @Version: 1.0
 **/
public class FirstUniqueChar {
    public static int firstUniqueChar(String s) {
        int index = s.length();
        for (char stringChar = 'a';stringChar <= 'z';stringChar ++){
            int indexSingle = s.indexOf(stringChar);
            if (indexSingle != -1 && indexSingle == s.lastIndexOf(stringChar)){
                index = index < indexSingle ? index : indexSingle;
            }
        }
        return index == s.length() ? -1 : index;
    }

    public static void main(String[] args) {
        String test = "aaacc";
        System.out.println(firstUniqueChar(test));
    }
}
