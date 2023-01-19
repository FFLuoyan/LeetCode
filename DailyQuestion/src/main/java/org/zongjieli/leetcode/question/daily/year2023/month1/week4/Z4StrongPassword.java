package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

/**
 * 如果一个密码满足以下所有条件,我们称它是一个强密码:
 *  它有至少 8 个字符
 *  至少包含一个小写英文字母
 *  至少包含一个大写英文字母
 *  至少包含一个数字
 *  至少包含一个特殊字符,特殊字符为: "!@#$%^&*()-+" 中的一个
 *  它不包含 2 个连续相同的字符(比方说 "aab" 不符合该条件,但是 "aba" 符合该条件)
 * 给定一个字符串 password,如果它是一个强密码,返回 true,否则返回 false
 *
 * 1 <= password.length <= 100
 * password 包含字母,数字和 "!@#$%^&*()-+" 这些特殊字符
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/19
 */
public class Z4StrongPassword {

    public boolean strongPasswordCheckerII(String password) {
        int length = password.length();
        if (length < 8) {
            return false;
        }
        byte[] values = password.getBytes();
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                return false;
            }
        }
        password = password.replaceAll("[a-z]","");
        if (length == (length = password.length())) {
            return false;
        }
        password = password.replaceAll("[A-Z]","");
        if (length == (length = password.length())) {
            return false;
        }
        password = password.replaceAll("[0-9]","");
        if (length == (length = password.length())) {
            return false;
        }
        password = password.replaceAll("[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]","");
        return length != password.length();
    }

    public static void main(String[] args) {
        Z4StrongPassword test = new Z4StrongPassword();
        // true
        System.out.println(test.strongPasswordCheckerII("-Aa1a1a1"));
    }

}
