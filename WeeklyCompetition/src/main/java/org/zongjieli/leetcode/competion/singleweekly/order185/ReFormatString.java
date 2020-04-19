package org.zongjieli.leetcode.competion.singleweekly.order185;

import org.springframework.core.annotation.Order;

import java.awt.*;
import java.util.Arrays;

/**
 * @ClassName: ReFormatString
 * @Description: 给定一个混合了数字和字母的字符串 s,其中的字母均为小写英文字母
 * 将该字符串重新格式化,使得任意两个相邻字符的类型都不同
 * @Author: Zongjie.Li
 * @Date: 2020/4/19
 * @Version: 1.0
 **/

public class ReFormatString {
    public String reformat(String s) {
        if (s.length() < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean isDouble = chars.length % 2 == 0;
        if (isDouble) {
            int middleIndex = chars.length / 2 - 1;
            if (chars[middleIndex] < 'A') {
                if (chars[middleIndex + 1] < 'A') {
                    return "";
                }
                for (int startIndex = 1; startIndex <= middleIndex; startIndex += 2) {
                    int changeIndex = chars.length - startIndex - 1;
                    char temp = chars[changeIndex];
                    chars[changeIndex] = chars[startIndex];
                    chars[startIndex] = temp;
                }
                return new String(chars);
            } else {
                return "";
            }
        } else {
            int middleIndex = chars.length / 2;
            if (chars[middleIndex] < 'A'){
                if (chars[middleIndex + 1] <'A'){
                    return "";
                }else {
                    // 数字多
                    for (int startIndex = 1;startIndex <= middleIndex;startIndex+=2){
                        int changeIndex = chars.length - startIndex;
                        char temp = chars[changeIndex];
                        chars[changeIndex] = chars[startIndex];
                        chars[startIndex] = temp;
                    }

                    return new String(chars);
                }
            } else {
                if (chars[middleIndex - 1] > 'A'){
                    return "";
                }else {
                    // 字母多
                    for (int startIndex =0;startIndex < middleIndex;startIndex+=2){
                        int changeIndex = chars.length - startIndex - 2;
                        char temp = chars[changeIndex];
                        chars[changeIndex] = chars[startIndex];
                        chars[startIndex] = temp;
                    }
                    return new String(chars);
                }
            }
        }
    }

    public static void main(String[] args) {
        ReFormatString reFormatString = new ReFormatString();
        System.out.println(reFormatString.reformat("aa111a11aaa1a"));
    }
}
