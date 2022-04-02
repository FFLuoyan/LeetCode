package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * 如果一个密码满足下述所有条件,则认为这个密码是强密码:
 *  由至少 6 个,至多 20 个字符组成
 *  至少包含一个小写字母,一个大写字母,和 一个数字
 *  同一字符不能连续出现三次(比如 "...aaa..." 是不允许的,但是 "...aa...a..." 如果满足其他条件也可以算是强密码)
 * 给定一个字符串 password,返回将 password 修改到满足强密码条件需要的最少修改步数
 * 如果 password 已经是强密码,则返回 0
 *
 * 在一步修改操作中,可以:
 *  插入一个字符到 password
 *  从 password 中删除一个字符或用另一个字符来替换 password 中的某个字符
 *
 * 1 <= password.length <= 50
 * password 由字母、数字、点 '.' 或者感叹号 '!'
 *
 * @author   Li.zongjie
 * @date     2022/4/2
 * @version  1.0
 */
public class Z6StrongPassword {

    public int strongPasswordChecker(String password) {
        int length = password.length();
        if (length <= 3) {
            return 6 - length;
        }
        int current = 0;
        char lastChar = '-';
        int isUpper = 0, isLower = 0, isNumber = 0;
        LinkedList<Integer> same = new LinkedList<>();
        for (int i = 0 ; i < length ; i++) {
            char currentChar = password.charAt(i);
            if (currentChar <= '9' && currentChar >= '0') {
                isNumber = 1;
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                isLower = 1;
            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                isUpper = 1;
            }
            if (currentChar == lastChar) {
                current++;
                continue;
            } else if (current >= 3) {
                same.add(current);
            }
            current = 1;
            lastChar = currentChar;
        }
        if (current >= 3 ){
            same.add(current);
        }
        int isAll = isLower + isNumber + isUpper;
        if (length < 6) {
            return Math.max(6 - length, 3 - isAll);
        } else if (length <= 20) {
            return Math.max(3 - isAll, same.stream().mapToInt(r -> r / 3).sum());
        } else {
            int needDelete = length - 20;
            if (same.isEmpty()) {
                return needDelete + 3 - isAll;
            }
            same.sort(Comparator.comparingInt(a -> a % 3));
            int r = 0;
            while (!same.isEmpty()) {
                if (needDelete == 0) {
                    break;
                }
                int o = same.pollFirst();
                if (o % 3 == 0) {
                    r++;
                    needDelete--;
                    if (o != 3) {
                        same.addLast(o - 1);
                    }
                } else if (o % 3 == 1) {
                    if (needDelete < 2) {
                        r++;
                        needDelete--;
                        same.addLast(o - 1);
                    } else {
                        r += 2;
                        needDelete -= 2;
                        if (o != 4) {
                            same.addLast(o - 2);
                        }
                    }
                } else {
                    if (needDelete < 3) {
                        r += needDelete;
                        needDelete = 0;
                        same.addLast(o - needDelete);
                    } else {
                        r += 3;
                        needDelete -= 3;
                        if (o != 5) {
                            same.addLast(o - 3);
                        }
                    }
                }
            }

            if (needDelete > 0 || same.isEmpty()) {
                return needDelete + r + 3 - isAll;
            } else {
                return r + Math.max(3 - isAll, same.stream().mapToInt(s -> s / 3).sum());
            }
        }
    }

    public static void main(String[] args) {
        Z6StrongPassword test = new Z6StrongPassword();
        // 2
//        System.out.println(test.strongPasswordChecker("ABABABABABABABABABAB1"));
        // 2
        System.out.println(test.strongPasswordChecker("QQQQQ"));
    }
}
