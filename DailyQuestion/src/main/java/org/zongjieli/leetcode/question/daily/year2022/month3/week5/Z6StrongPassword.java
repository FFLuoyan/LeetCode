package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

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
        int delete1 = 0, delete2 = 0, deleteAll = 0, replace = 0;
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
                replace += current / 3;
                int remain = current % 3;
                if (remain == 0) {
                    delete1++;
                } else if (remain == 1) {
                    delete2++;
                }
                deleteAll += (current - 2);
            }
            lastChar = currentChar;
            current = 1;
        }

        if (current >= 3) {
            replace += current / 3;
            int remain = current % 3;
            if (remain == 0) {
                delete1++;
            } else if (remain == 1) {
                delete2++;
            }
            deleteAll += (current - 2);
        }
        int needSup = 3 - isUpper - isLower - isNumber;
        if (length < 6) {
            return Math.max(6 - length, needSup);
        }
        if (length <= 20) {
            return Math.max(needSup, replace);
        }

        int needDelete = length - 20;

        if (needDelete >= deleteAll) {
            return needDelete + needSup;
        }

        if (needDelete <= delete1) {
            return needDelete + Math.max(replace - needDelete, needSup);
        }
        needDelete -= delete1;
        replace -= delete1;
        if (needDelete <= 2 * delete2) {
            return delete1 + needDelete + Math.max(replace - needDelete / 2, needSup);
        }

        needDelete -= (2 * delete2);
        replace -= delete2;
        return delete1 + 2 * delete2 + needDelete + Math.max(replace - needDelete / 3, needSup);
    }

    public static void main(String[] args) {
        Z6StrongPassword test = new Z6StrongPassword();
        // 2
        System.out.println(test.strongPasswordChecker("ABABABABABABABABABAB1"));
        // 2
        System.out.println(test.strongPasswordChecker("QQQQQ"));
        // 8
        System.out.println(test.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
        // 3
        System.out.println(test.strongPasswordChecker("10203040aaaaa50607080B"));
    }
}
