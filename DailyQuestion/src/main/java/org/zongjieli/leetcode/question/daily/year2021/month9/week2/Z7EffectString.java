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
        int max = 0;
        int min = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            if (currentChar == '('){
                max++;
                min++;
            } else if (currentChar == '*'){
                max++;
                if (min > 0){
                    min--;
                }
            } else if (max <= 0){
                return false;
            } else {
                max--;
                if (min > 0){
                    min--;
                }
            }
        }
        return min <= 0 && max >= 0;
    }

    public static void main(String[] args) {
        Z7EffectString test = new Z7EffectString();
        System.out.println(test.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
//        System.out.println(test.checkValidString("(((((*(*********((*(((((****"));
    }
}
