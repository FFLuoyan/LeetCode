package org.zongjieli.leetcode.algorthm.intermediate.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: NumberToString
 * @Description: 将 2-9 的数字转换成字符串输出
 * @Author: Zongjie.Li
 * @Date: 2020/5/21
 * @Version: 1.0
 **/
public class NumberToString {

    char[][] numberChar = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> outputList = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return outputList;
        }
        char[] singleValue = new char[digits.length()];
        int[] numberArray = new int[digits.length()];
        for (int i = 0;i<numberArray.length;i++){
            numberArray[i] = digits.charAt(i) - '2';
        }
        constructString(singleValue,outputList,numberArray,0);
        return outputList;
    }

    public void constructString (char[] value,List<String> list,int[] numberArray, int index){
        int number = numberArray[index];
        for (int i = 0 ; i < numberChar[number].length ; i++){
            value[index] = numberChar[number][i];
            if (index == numberArray.length - 1){
                list.add(String.valueOf(value));
            }else {
                constructString(value,list,numberArray,index+1);
            }
        }
    }

    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        System.out.println(numberToString.letterCombinations("22"));
    }
}
