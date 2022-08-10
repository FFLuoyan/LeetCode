package org.zongjieli.leetcode.question.daily.year2022.month8.week2;
/**
 * 求解一个给定的方程,将 x 以字符串 "x=#value" 的形式返回
 * 该方程仅包含 '+','-' 操作,变量 x 和其对应系数
 * 如果方程没有解,请返回 "No solution"
 * 如果方程有无限解则返回 "Infinite solutions"
 * 题目保证,如果方程中只有一个解,则 'x' 的值是一个整数
 *
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成,其绝对值在 [0, 100] 范围内,不含前导零和变量 'x'
 *
 * @author   Li.zongjie
 * @date     2022/8/10
 * @version  1.0
 */
public class Z3SolveEquation {

    public String solveEquation(String equation) {
        int xCount = 0;
        int value = 0;
        boolean isLeft = true;
        boolean isPositive = true;
        boolean xCoefficient = false;
        int currentCount = 0;
        for (int i = 0 ; i < equation.length() ; i++) {
            char cc = equation.charAt(i);
            if (cc == 'x') {
                if (!xCoefficient) {
                    currentCount = 1;
                }
                xCount += (isLeft ^ isPositive ? -currentCount : currentCount);
                currentCount = 0;
                xCoefficient = false;
            } else if (cc == '=') {
                value += (isLeft ^ isPositive ? currentCount : -currentCount);
                currentCount = 0;
                isLeft = false;
                isPositive = true;
                xCoefficient = false;
            } else if (cc == '+') {
                value += (isLeft ^ isPositive ? currentCount : -currentCount);
                currentCount = 0;
                isPositive = true;
                xCoefficient = false;
            } else if (cc == '-') {
                value += (isLeft ^ isPositive ? currentCount : -currentCount);
                currentCount = 0;
                isPositive = false;
                xCoefficient = false;
            } else {
                currentCount = currentCount * 10 + (cc - '0');
                xCoefficient = true;
            }
        }
        value += (isPositive ? currentCount : -currentCount);
        if (xCount == 0) {
            return value == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (value / xCount);
    }

    public static void main(String[] args) {
        Z3SolveEquation test = new Z3SolveEquation();
        // x=2
        System.out.println(test.solveEquation("x+5-3+x=6+x-2"));
        // Infinite solutions
        System.out.println(test.solveEquation("0x=0"));
    }
}
