package org.zongjieli.leetcode.question.daily.year2022.month10.week3;
/**
 * 给定长度相等的两个字符串 s1 和 s2
 * 一次字符串交换操作的步骤如下:
 *  选出某个字符串中的两个下标(不必不同),并交换这两个下标所对应的字符
 * 如果对其中一个字符串执行最多一次字符串交换就可以使两个字符串相等
 * 返回 true,否则返回 false
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z2ChangeEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        char[] equals = new char[4];
        int count = 0;
        for (int i = 0 ; i < s1.length() ; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a != b) {
                if (count >= 4) {
                    return false;
                }
                equals[count++] = a;
                equals[count++] = b;
            }
        }
        return count == 0 || (count == 4 && equals[0] == equals[3] && equals[1] == equals[2]);
    }
}
