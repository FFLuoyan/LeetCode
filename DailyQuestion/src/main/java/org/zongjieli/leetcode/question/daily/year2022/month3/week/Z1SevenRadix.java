package org.zongjieli.leetcode.question.daily.year2022.month3.week;
/**
 * 给定一个整数 num,将其转化为 7 进制,并以字符串形式输出
 *
 * -10^7 <= num <= 10^7
 *
 * @author   Li.zongjie
 * @date     2022/3/7
 * @version  1.0
 */
public class Z1SevenRadix {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public String convertToBase7Detail(int num) {
        byte[] result = new byte[10];
        int index = 10;
        boolean isNegative = num < 0;
        num = Math.abs(num);
        while (num >= 7) {
            result[--index] = (byte) ((num % 7) + 48);
            num /= 7;
        }
        result[--index] = (byte) (num + 48);
        if (isNegative) {
            result[--index] = 45;
        }
        return new String(result, index, 10 - index);
    }

    public static void main(String[] args) {
        Z1SevenRadix test = new Z1SevenRadix();
        // "0"
        System.out.println(test.convertToBase7(0));
        // "202"
        System.out.println(test.convertToBase7(100));
        // "-100"
        System.out.println(test.convertToBase7(-49));
    }
}
