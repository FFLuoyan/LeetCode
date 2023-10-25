package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 给定一个正整数 n,请返回 n 的惩罚数
 * n 的惩罚数定义为所有满足以下条件 i 的数的平方和:
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串
 * 且这些子字符串对应的整数值之和等于 i
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/25
 */
public class Z3SpecialNumber {

    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i * i, i)) {
                result += i * i;
            }
        }
        return result;
    }

    public boolean isSpecial(int square, int value) {
        if (value < 0) {
            return false;
        }
        if (square == value) {
            return true;
        }
        int remain = 10;
        while (square > remain) {
            if (isSpecial(square / remain, value - (square % remain))) {
                return true;
            }
            remain *= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Z3SpecialNumber test = new Z3SpecialNumber();
        // 182
        System.out.println(test.punishmentNumber(10));
    }
}
