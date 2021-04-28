package org.zongjieli.leetcode.question.daily.year2021.month4.week5;
/**
 * 给定一个非负整数 c,判断是否存在两个整数 a 和 b,使得 a^2 + b^2 = c
 *
 * @author   Zongjie.Li
 * @date     2021/4/28
 * @version  1.0
 */
public class SquareNumberSum {
    public boolean judgeSquareSum(int c) {
        int min = 0;
        int max = (int) Math.sqrt(c);
        while (min <= max){
            int temp = max * max;
            min = (int) Math.sqrt(c - temp);
            if (min * min + temp == c){
                return true;
            }
            max--;
        }
        return false;
    }

    public static void main(String[] args) {
        SquareNumberSum test = new SquareNumberSum();
        System.out.println(test.judgeSquareSum(0));;
    }
}
