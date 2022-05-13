package org.zongjieli.leetcode.question.daily.year2022.month5.week3;
/**
 * 字符串有三种编辑操作:
 *  插入一个字符
 *  删除一个字符
 *  替换一个字符
 * 给定两个字符串,编写一个函数判定它们是否只需要一次 (或者零次) 编辑
 *
 * @author   Li.zongjie
 * @date     2022/5/13
 * @version  1.0
 */
public class Z5StringSame {

    public boolean oneEditAway(String first, String second) {
        int fl = first.length(), sl = second.length();
        if (sl > fl) {
            return oneEditAway(second, first);
        }
        if (fl > sl + 1) {
            return false;
        }
        for (int i = 0 ; i < sl ; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                for (int fi = i + 1, si = i + 1 - fl + sl ; si < sl ; fi++, si++) {
                    if (first.charAt(fi) != second.charAt(si)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z5StringSame test = new Z5StringSame();
        System.out.println(test.oneEditAway("islander", "slander"));
    }

}
