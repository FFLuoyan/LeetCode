package org.zongjieli.leetcode.competion.singleweekly.order184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SubWordInStringArray
 * @Description: 给定一个字符串数组 words,数组中的每个字符串都可以看做是一个单词
 *               请按照任意顺序返回 words 中是其他单词的子字符串的所有单词
 * @Author: Zongjie.Li
 * @Date: 2020/4/12
 * @Version: 1.0
 **/
public class SubWordInStringArray {
    public List<String> stringMatching(String[] words) {
//        System.out.println(Arrays.toString(words));
        for (int i =  0;i < words.length;i++){
            for (int j = words.length - 1;j > i;j--){
                if (words[j].length() > words[j - 1].length()){
                    String temp = words[j -1];
                    words[j -1] = words[j];
                    words[j] = temp;
                }
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int compareWordIndex = words.length - 1; compareWordIndex >0;compareWordIndex--){
            for (int bigStringIndex = 0; bigStringIndex < compareWordIndex;bigStringIndex++){
                if (words[bigStringIndex].contains(words[compareWordIndex])){
                    stringList.add(words[compareWordIndex]);
                    break;
                }
            }
        }


//        System.out.println(Arrays.toString(words));
        return stringList;
    }

    public static void main(String[] args) {
        SubWordInStringArray subWordInStringArray = new SubWordInStringArray();
        String[] strings = new String[]{"asf","gdfgdfg","dfgsdffdsgsdfgsdfg","asd"};
        System.out.println(subWordInStringArray.stringMatching(strings));
    }



}
