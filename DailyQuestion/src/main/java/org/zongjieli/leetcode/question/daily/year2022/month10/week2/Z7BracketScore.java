package org.zongjieli.leetcode.question.daily.year2022.month10.week2;
/**
 * 给定一个平衡括号字符串 S,按下述规则计算该字符串的分数:
 *  () 得 1 分
 *  AB 得 A + B 分,其中 A 和 B 是平衡括号字符串
 *  (A) 得 2 * A 分,其中 A 是平衡括号字符串
 *
 * S 是平衡括号字符串,且只含有 '(' 和 ')'
 * 2 <= S.length <= 50
 *
 * @author   Li.zongjie
 * @date     2022/10/9
 * @version  1.0
 */
public class Z7BracketScore {

    public int scoreOfParentheses(String s) {
        int[] values = new int[32];
        int count = 0;
        for (int bracketIndex = 0 ; bracketIndex < s.length() ; bracketIndex++) {
            if (s.charAt(bracketIndex) == '(') {
                count++;
            } else {
                int cv = values[count];
                values[count] = 0;
                count--;
                values[count] += (cv == 0 ? 1 : 2 * cv);
            }
        }
        return values[0];
    }

    public int scoreOfParentheses2(String s) {
        /*
            平衡括号字符串的最终值只和括号对 "()" 的数目及深度有关
         */
        int count = 0, score = 0, li = 0;
        for (int bracketIndex = 0 ; bracketIndex < s.length() ; bracketIndex++) {
            if (s.charAt(bracketIndex) == '(') {
                count++;
                li = bracketIndex;
            } else {
                count--;
                if (bracketIndex == li + 1) {
                    score += (1 << count);
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Z7BracketScore test = new Z7BracketScore();
        // 2
        System.out.println(test.scoreOfParentheses("(())"));
        // 2
        System.out.println(test.scoreOfParentheses("()()"));
    }

}
