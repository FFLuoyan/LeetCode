package org.zongjieli.leetcode.question.daily.year2022.month4.week3;

import org.zongjieli.leetcode.base.NestedInteger;

/**
 * 给定一个字符串 s 表示一个整数嵌套列表
 * 实现一个解析它的语法分析器并返回解析的结果 NestedInteger
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 1 <= s.length <= 5 * 10^4
 * s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成
 * 用例保证 s 是可解析的 NestedInteger
 * 输入中的所有值的范围是 [-10^6, 10^6]
 *
 * @author   Li.zongjie
 * @date     2022/4/15
 * @version  1.0
 */
public class Z5GrammarAnalysis {

    public NestedInteger deserialize(String s) {
        if (!s.contains("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        // 如果包含列表,则第一个字符肯定为 '['
        NestedInteger result = new NestedInteger();
        int bracketCount = 0;
        int startIndex = 1;
        char[] sc = s.toCharArray();
        sc[sc.length - 1] = ',';
        for (int i = 1 ; i < sc.length ; i++) {
            char currentChar = sc[i];
            if (currentChar == ',') {
                if (bracketCount == 0) {
                    if (i - startIndex != 0) {
                        result.add(deserialize(new String(sc, startIndex, i - startIndex)));
                    }
                    startIndex = i + 1;
                }
            } else if (currentChar == '[') {
                bracketCount++;
            } else if (currentChar == ']') {
                bracketCount--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z5GrammarAnalysis test = new Z5GrammarAnalysis();
        System.out.println(test.deserialize("324"));
        System.out.println(test.deserialize("[123,[456,[789]]]"));
        System.out.println(test.deserialize("[123,456,[788,799,833],[[]],10,[]]"));
    }

}
