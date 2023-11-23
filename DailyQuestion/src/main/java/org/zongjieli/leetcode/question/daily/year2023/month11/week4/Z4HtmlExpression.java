package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

/**
 * HTML 实体解析器是一种特殊的解析器,它将 HTML 代码作为输入
 * 并用字符本身替换掉所有这些特殊的字符实体
 * HTML 里这些特殊字符和它们对应的字符实体包括:
 * 双引号: 字符实体为 &quot; 对应的字符是 "
 * 单引号: 字符实体为 &apos; 对应的字符是 '
 * 与符号: 字符实体为 &amp; 对应对的字符是 &
 * 大于号: 字符实体为 &gt; 对应的字符是 >
 * 小于号: 字符实体为 &lt; 对应的字符是 <
 * 斜线号: 字符实体为 &frasl; 对应的字符是 /
 * 给定输入字符串 text,请实现一个 HTML 实体解析器,返回解析器解析后的结果
 *
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个 ASCII 字符中的任意字符
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/23
 */
public class Z4HtmlExpression {

    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");
    }

}
