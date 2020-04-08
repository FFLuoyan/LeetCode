package org.zongjieli.leetcode.competion.singleweekly.order183;

/**
 * @ClassName: HappyString
 * @Description: 如果字符串中不包含"aaa","bbb","ccc"这样的字符串,那么该字符串就是一个快乐字符串
 *               给定三个整数,然后任意一个满足下列全部条件的字符串 s
 *                  s 是一个尽可能长的快乐字符串
 *                  s 中最多有 a 个字母'a',b 个字母'b',c 个字母'c'
 *                  s 中只含有'a','b','c'三种字母
 *                 如果不存在这样的字符串 s,请返回一个空字符串""
 * @Author: Zongjie.Li
 * @Date: 2020/4/5
 * @Version: 1.0
 **/
public class HappyString {
    public String longestDiverseString(int a, int b, int c) {
        int max = 0;
        int middle = 0;
        int min = 0;
        String maxString = "";
        String middleString = "";
        String minString = "";

        if (a > b){
            max = a;
            maxString = "a";
            middle =b;
            middleString = "b";
        } else {
            max = b;
            maxString = "b";
            middle =a;
            middleString = "a";
        }
        if (c > max){
            min = middle;
            minString = middleString;
            middle = max;
            middleString = maxString;
            max = c;
            maxString = "c";
        } else if (c <middle){
            min = c;
            minString = "c";
        } else {
            min = middle;
            minString = middleString;
            middle = c;
            middleString = "c";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (max >= 2 * (middle + min + 1)){
            maxString = maxString + maxString;
            stringBuilder.append(maxString);
            stringAdd(stringBuilder,middleString + maxString,middle);
            stringAdd(stringBuilder,minString + maxString,min);
            return stringBuilder.toString();
        }

        if (max > middle + min) {
            int doubleCount = max - middle - min;
            stringAdd(stringBuilder, minString + maxString + maxString, min);
        }
        return "";
    }

    public void stringAdd(StringBuilder stringBuilder,String add,int count){
        for (int i = 0;i < count;i++){
            stringBuilder.append(add);
        }
    }
}
