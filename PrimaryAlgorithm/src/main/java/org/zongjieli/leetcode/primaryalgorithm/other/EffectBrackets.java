package org.zongjieli.leetcode.primaryalgorithm.other;

/**
 * @ClassName: EffectBrackets
 * @Description: 检验给定字符串中的括号是否有效
 *               左括号必须与右括号闭合
 *               括号闭合的顺序必须是正确的
 *               括号包括 "(",")","[","]","{","}"
 *               +
 * @Author: Zongjie.Li
 * @Date: 2020/4/1
 * @Version: 1.0
 **/
public class EffectBrackets {
    public boolean isValid(String s) {
        // 1:(    2:[    3:{
        if (s== null){
            return true;
        }
        int stringLength = s.length();
        if (stringLength < 1){
            return true;
        }
        if ((stringLength % 2) == 1){
            return false;
        }
        int[] bracketArray = new int[s.length()];
        int compareIndex = -1;
        for (int i = 0 ; i < s.length();i++){
            char loopChar = s.charAt(i);

            switch (loopChar){
                case '(':
                    compareIndex ++;
                    bracketArray[compareIndex] = 1;
                    break;
                case '[':
                    compareIndex ++;
                    bracketArray[compareIndex] = 2;
                    break;
                case '{':
                    compareIndex ++;
                    bracketArray[compareIndex] = 3;
                    break;
                case ')':
                    if (compareIndex == -1 || bracketArray[compareIndex] != 1){
                        return false;
                    }
                    compareIndex --;
                    break;
                case ']':
                    if (compareIndex == -1 || bracketArray[compareIndex] != 2){
                        return false;
                    }
                    compareIndex --;
                    break;
                case '}':
                    if (compareIndex == -1 || bracketArray[compareIndex] != 3){
                        return false;
                    }
                    compareIndex --;
                    break;
                default:
                    break;
            }
        }
        return compareIndex == -1 ;

    }

    public static void main(String[] args) {
        EffectBrackets effectBrackets = new EffectBrackets();
        System.out.println(effectBrackets.isValid("()[]{}([{}}])"));
    }
}
