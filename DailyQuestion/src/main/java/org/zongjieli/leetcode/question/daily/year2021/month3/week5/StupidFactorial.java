package org.zongjieli.leetcode.question.daily.year2021.month3.week5;
/**
 * 通常,正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积
 * 我们设计了一个笨阶乘 clumsy:
 *   在整数的递减序列中
 *   我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符:
 *   *、/、+、-
 *   clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 * 这些运算仍然使用通常的算术运算顺序
 * 我们在任何加、减步骤之前执行所有的乘法和除法步骤
 * 并且按从左到右处理乘法和除法步骤
 * 另外,我们使用的除法是地板除法 (floor division)
 * 所以 10 * 9 / 8 等于 11,保证结果是一个整数
 *
 * @author   Zongjie.Li
 * @date     2021/4/1
 * @version  1.0
 */
public class StupidFactorial {
    public int clumsy(int N) {
        if (N > 4){
            int result = N-- * N-- / N-- + N--;
            while (N > 3){
                result = result - (N-- * N-- / N--) + N--;
            }
            switch (N){
                case 1:return result - 1;
                case 2:return result - 2;
                case 3:return result - 6;
                default:return result;
            }
        } else {
            switch (N){
                case 1:return 1;
                case 2:return 2;
                case 3:return 6;
                default:return 7;
            }
        }
    }

    public static void main(String[] args) {
        StupidFactorial stupidFactorial = new StupidFactorial();
        System.out.println(stupidFactorial.clumsy(1));
        System.out.println(stupidFactorial.clumsy(2));
        System.out.println(stupidFactorial.clumsy(3));
        System.out.println(stupidFactorial.clumsy(4));
        System.out.println(stupidFactorial.clumsy(5));
        System.out.println(stupidFactorial.clumsy(6));
        System.out.println(stupidFactorial.clumsy(10));
    }
}
