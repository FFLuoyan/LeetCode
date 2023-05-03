package org.zongjieli.leetcode.question.daily.year2023.month5.week1;

/**
 * 给定一个字符串 s,请判断它是否有效
 * 字符串 s 有效需要满足: 假设开始有一个空字符串 t = "",可以执行任意次下述操作将 t 转换为 s
 *  将字符串 "abc" 插入到 t 中的任意位置
 *  形式上,t 变为 tLeft + "abc" + tRight
 *  其中 t == tLeft + tRight
 *  注意,tLeft 和 tRight 可能为空
 * 如果字符串 s 有效,则返回 true,否则返回 false
 *
 * 1 <= s.length <= 2 * 10^4
 * s 由字母 'a'、'b' 和 'c' 组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/5/3
 */
public class Z3CheckEffect {

    public boolean isValid(String s) {
        int length = Integer.MAX_VALUE, nextLength = s.length();
        while (length > 0 && nextLength != length) {
            length = nextLength;
            s = s.replaceAll("abc", "");
            nextLength = s.length();
        }
        return length == 0;
    }
}
