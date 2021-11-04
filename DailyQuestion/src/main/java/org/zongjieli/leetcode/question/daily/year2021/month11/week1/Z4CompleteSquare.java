package org.zongjieli.leetcode.question.daily.year2021.month11.week1;
/**
 * 给定一个正整数 num,编写一个函数
 * 如果 num 是一个完全平方数,则返回 true,否则返回 false
 *
 * 1 <= num <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/11/4
 * @version  1.0
 */
public class Z4CompleteSquare {
    public boolean isPerfectSquare(int num) {
        long sqrt = 0;
        int compare = 1 << 16;
        while (compare > 0){
            long temp = sqrt + compare;
            temp *= temp;
            if (temp == num){
                return true;
            }
            if (temp < num){
                sqrt += compare;
            }
            compare >>= 1;
        }
        return false;
    }

    public boolean isPerfectSquareByNewton(int num) {
        double v = num;
        while (v * v - num > 0.000001){
            v = num / v / 2 + v / 2;
        }
        double sub = v - (int) v;
        return sub < 0.000001 || sub > 0.999999;
    }

    public static void main(String[] args) {
        Z4CompleteSquare test = new Z4CompleteSquare();
//        test.isPerfectSquareByNewton(16);
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));
//        test.isPerfectSquareByNewton(46340 * 46340);
//        System.out.println(Math.sqrt(100489));
//        test.isPerfectSquareByNewton(100489);
        test.isPerfectSquareByNewton(9);
    }
}
