package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

import java.util.*;

/**
 * 给定一个字符串 s,它包含一些括号对,每个括号中包含一个非空的键
 * 比方说,字符串 "(name)is(age)years old" 中,有两个括号对,分别包含键 "name" 和 "age"
 * 有许多键对应的值,这些关系由二维字符串数组 knowledge 表示
 * 其中 knowledge[i] = [keyI, valueI],表示键 keyI 对应的值为 valueI
 * 需要替换所有的括号对,当替换一个括号对,且它包含的键为 keyI 时,需要:
 *  将 keyI 和括号用对应的值 valueI 替换
 *  如果从 knowledge 中无法得知某个键对应的值,你需要将 keyI 和括号用问号 "?" 替换(不需要引号)
 *  knowledge 中每个键最多只会出现一次,s 中不会有嵌套的括号
 * 请返回替换所有括号对后的结果字符串
 *
 * 1 <= s.length <= 10^5
 * 0 <= knowledge.length <= 10^5
 * knowledge[i].length == 2
 * 1 <= keyI.length, valueI.length <= 10
 * s 只包含小写英文字母和圆括号 '(' 和 ')'
 * s 中每一个左圆括号 '(' 都有对应的右圆括号 ')'
 * s 中每对括号内的键都不会为空
 * s 中不会有嵌套括号对
 * keyI 和 valueI 只包含小写英文字母
 * knowledge 中的 keyI 不会重复
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/12
 */
public class Z4ReplaceBracket {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        char[] values = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == '(') {
                StringBuilder key = new StringBuilder();
                while (values[++i] != ')') {
                    key.append(values[i]);
                }
                result.append(map.getOrDefault(key.toString(), "?"));
            } else {
                result.append(values[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Z4ReplaceBracket test = new Z4ReplaceBracket();
        // hi?
        System.out.println(test.evaluate("hi(name)", Collections.singletonList(Arrays.asList("a", "b"))));
        // bobistwoyearsold
        System.out.println(test.evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
        // c
        System.out.println(test.evaluate("(zib)", Arrays.asList(Arrays.asList("qfviuwjo", "w"), Arrays.asList("kppdajmk", "n"), Arrays.asList("zib", "c"), Arrays.asList("ztfljcff", "i"), Arrays.asList("aoayyihi", "d"))));
    }
}
