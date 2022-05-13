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
        int fl = first.length();
        int sl = second.length();
        if (fl == sl) {
            // 替换或相同
            for (int i = 0 ; i < fl ; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    for (int j = i + 1 ; j < fl ; j++) {
                        if (first.charAt(j) != second.charAt(j)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (fl == sl + 1) {
            // first 删除一个或 second 插入一个
            for (int i = 0 ; i < sl ; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    for (int j = i ; j < sl ; j++) {
                        if (first.charAt(j + 1) != second.charAt(j)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (sl == fl + 1) {
            // second 删除一个或 first 插入一个
            for (int i = 0 ; i < fl ; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    for (int j = i ; j < fl ; j++) {
                        if (first.charAt(j) != second.charAt(j + 1)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
