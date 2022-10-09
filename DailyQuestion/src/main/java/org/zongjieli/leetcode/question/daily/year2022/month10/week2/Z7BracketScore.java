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
                if (values[count + 1] == 0) {
                    values[count] += 1;
                } else {
                    values[count] += 2 * values[count + 1];
                    values[count + 1] = 0;
                }
                count--;
            }
        }
        return values[1];
    }

    public static void main(String[] args) {
        Z7BracketScore test = new Z7BracketScore();
        // 2
        System.out.println(test.scoreOfParentheses("(())"));
        // 2
        System.out.println(test.scoreOfParentheses("()()"));
    }

}
