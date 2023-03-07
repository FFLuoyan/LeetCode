package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 花括号展开可以用来生成任意字符串
 * 花括号展开的表达式可以看作一个由花括号、逗号和小写英文字母组成的字符串
 * 定义下面几条语法规则:
 *  如果只给出单一的元素 x,那么表达式表示的字符串就只有 "x",R(x) = {x}
 *      例如,表达式 "a" 表示字符串 "a",而表达式 "w" 就表示字符串 "w"
 *  当两个或多个表达式并列,以逗号分隔
 *      取这些表达式中元素的并集,R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 *      例如,表达式 "{a,b,c}" 表示字符串 "a", "b", "c"
 *      而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a", "b", "c"
 *  要是两个或多个表达式相接,中间没有隔开时
 *      从这些表达式中各取一个元素依次连接形成字符串
 *      R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}
 *      例如,表达式 "{a,b}{c,d}" 表示字符串 "ac", "ad", "bc", "bd"
 *  表达式之间允许嵌套,单一元素与表达式的连接也是允许的
 *      例如,表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"
 *      例如,表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串
 *          "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"
 * 给出表示基于给定语法规则的表达式 expression,返回它所表示的所有字符串组成的有序列表
 *
 * 1 <= expression.length <= 60
 * expression[i] 由 '{', '}', ',' 或小写英文字母组成
 * 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/7
 */
public class Z2BracketDevelop {

    public List<String> braceExpansionII(String expression) {
        return braceExpansion(expression).stream().distinct().sorted().collect(Collectors.toList());
    }

    public List<String> braceExpansion(String expression) {
        int count = 0;
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0 ; i < expression.length() ; i++) {
            char current = expression.charAt(i);
            if (current == ',') {
                if (count == 0) {
                    result.addAll(braceExpansion(expression.substring(startIndex, i)));
                    startIndex = i + 1;
                }
            } else if (current == '{') {
                count++;
            } else if (current == '}') {
                count--;
            }
        }
        if (startIndex != 0) {
            result.addAll(braceExpansion(expression.substring(startIndex)));
            return result;
        }
        for (int i = 0 ; i < expression.length() ; i++) {
            char current = expression.charAt(i);
            if (current == '{') {
                if (count++ == 0) {
                    if (i != 0) {
                        String before = expression.substring(0, i);
                        List<String> after = braceExpansion(expression.substring(i));
                        after.replaceAll(s -> before + s);
                        return after;
                    }
                }
            } else if (current == '}') {
                if (--count == 0) {
                    List<String> before = braceExpansion(expression.substring(1, i));
                    if (i == expression.length() - 1) {
                        return before;
                    }
                    List<String> after = braceExpansion(expression.substring(i + 1));
                    for (String b : before) {
                        for (String a : after) {
                            result.add(b + a);
                        }
                    }
                    return result;
                }
            }
        }
        result.add(expression);
        return result;
    }

    public static void main(String[] args) {
        Z2BracketDevelop test = new Z2BracketDevelop();
        // a
        System.out.println(test.braceExpansionII("a"));
        // a, b
        System.out.println(test.braceExpansionII("a,b"));
        // ab
        System.out.println(test.braceExpansionII("a{b}"));
        // ac, ad, bc, bd
        System.out.println(test.braceExpansionII("{a,b}{c,d}"));
        // "a", "ab", "ac", "z"
        System.out.println(test.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }

}
