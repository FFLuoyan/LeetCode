package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

/**
 * 给定两个字符串,s 和 goal
 * 如果在若干次旋转操作之后,s 能变成 goal,那么返回 true
 * s 的旋转操作就是将 s 最左边的字符移动到最右边
 * 例如,若 s = 'abcde',在旋转一次之后结果就是'bcdea'
 *
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/4/7
 * @version  1.0
 */
public class Z4RotateString {

    public boolean rotateString(String s, String goal) {
        int sl = s.length();
        char[] value = new char[2 * sl];
        for (int i = 0 ; i < sl ; i++) {
            value[i] = value[i + sl] = s.charAt(i);
        }
        for (int i = 0 ; i < sl ; i++) {
            if (new String(value, i, sl).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
