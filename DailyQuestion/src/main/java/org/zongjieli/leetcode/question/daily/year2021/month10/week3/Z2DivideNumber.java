package org.zongjieli.leetcode.question.daily.year2021.month10.week3;
/**
 * 给定两个整数,被除数 dividend 和除数 divisor
 * 将两数相除,要求不使用乘法、除法和 mod 运算符
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商
 * 整数除法的结果应当截去(truncate)其小数部分
 * 例如: truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 被除数和除数均为 32 位有符号整数
 * 除数不为 0
 * 假设我们的环境只能存储 32 位有符号整数
 * 其数值范围是 [−2^31,  2^31 − 1]
 * 本题中,如果除法结果溢出,则返回 2^31 − 1
 *
 *
 * @author   Li.zongjie
 * @date     2021/10/12
 * @version  1.0
 */
public class Z2DivideNumber {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }

        int negativeSignal = Integer.MIN_VALUE;
        int signal = (dividend & negativeSignal) ^ (divisor & negativeSignal);

        signal = signal == negativeSignal ? -1 : 1;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        if (divisor < dividend){
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        int multiple = 1;
        while (divisor > dividend && divisor >= Integer.MIN_VALUE / 2){
            multiple <<= 1;
            divisor <<= 1;
        }

        int result = 0;
        while (multiple != 0){
            if (dividend <= divisor){
                dividend -= divisor;
                result += multiple;
            }
            divisor >>= 1;
            multiple >>>= 1;
        }
        return signal * result;
    }

    public static void main(String[] args) {
        Z2DivideNumber test = new Z2DivideNumber();
//        System.out.println(test.divide(10,3));
//        System.out.println(test.divide(-10,3));
//        System.out.println(test.divide(10,-3));
//        System.out.println(test.divide(-10,-3));
//        System.out.println(test.divide(1,1));
//        System.out.println(test.divide(Integer.MIN_VALUE,2));
//        System.out.println(test.divide(Integer.MIN_VALUE, -1));
        System.out.println(test.divide(Integer.MAX_VALUE, 1));
//        System.out.println(test.divide(Integer.MIN_VALUE, 1));
    }
}
