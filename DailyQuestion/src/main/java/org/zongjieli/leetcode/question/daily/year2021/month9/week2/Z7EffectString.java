package org.zongjieli.leetcode.question.daily.year2021.month9.week2;
/**
 * 给定一个只包含三种字符的字符串:"(",")" 和 "*"
 * 写一个函数来检验这个字符串是否为有效字符串
 * 有效字符串具有如下规则:
 *  任何左括号 "(" 必须有相应的右括号 ")"
 *  任何右括号 ")" 必须有相应的左括号 "("
 *  左括号 "(" 必须在对应的右括号之前 ")"
 *  "*" 可以被视为单个右括号 ")",或单个左括号 "(",或一个空字符串
 *
 * 一个空字符串也被视为有效字符串
 * 字符串大小将在 [1,100] 范围内
 *
 * @author   Li.zongjie
 * @date     2021/9/16
 * @version  1.0
 */
public class Z7EffectString {
    public boolean checkValidString(String s) {
        // 分别校验左括号与右括号
        int brackets = 0;
        int asterisk = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            if (currentChar == '('){
                brackets++;
            } else if (currentChar == '*'){
                asterisk++;
            } else if (brackets > 0){
                brackets--;
            } else if (asterisk > 0){
                asterisk--;
            } else {
                return false;
            }
        }
        brackets = 0;
        asterisk = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--){
            char currentChar = s.charAt(i);
            if (currentChar == ')'){
                brackets++;
            } else if (currentChar == '*'){
                asterisk++;
            } else if (brackets > 0){
                brackets--;
            } else if (asterisk > 0){
                asterisk--;
            } else {
                return false;
            }
        }

        return true;
    }
}
