package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

/**
 * 定义一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符,并返回唯一字符的个数
 * 例如: s = "LEETCODE",则其中 "L", "T", "C", "O", "D" 都是唯一字符
 * 因为它们只出现一次,所以 countUniqueChars(s) = 5
 * 给定一个字符串 s,返回 countUniqueChars(t) 的总和
 * 其中 t 是 s 的子字符串,输入用例保证返回值为 32 位整数
 * 注意,某些子字符串可能是重复的,但统计时也必须算上这些重复的子字符串
 * 也就是说,必须统计 s 的所有子字符串中的唯一字符
 *
 * 1 <= s.length <= 10^5
 * s 只包含大写英文字符
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/26
 */
public class Z7CountUniqueChars {

    public int uniqueLetterString(String s) {
        char find = 'A';
        int result = 0;
        while (find <= 'Z') {
            int first = -1, second = s.indexOf(find), third;
            while (second < s.length()) {
                third = s.indexOf(find, second + 1);
                if (third == -1) {
                    third = s.length();
                }
                result += (second - first) * (third - second);
                first = second;
                second = third;
            }
            find++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z7CountUniqueChars test = new Z7CountUniqueChars();
        // 10
        System.out.println(test.uniqueLetterString("ABC"));
        // 8
        System.out.println(test.uniqueLetterString("ABA"));
    }
}
