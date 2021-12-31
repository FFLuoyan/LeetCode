package org.zongjieli.leetcode.question.daily.year2021.month12.week5;

import java.util.HashSet;
import java.util.Set;

/**
 * 对于一个正整数,如果它和除了它自身以外的所有正因子之和相等,则称其为完美数
 * 给定一个整数 n,如果是完美数,返回 true,否则返回 false
 *
 * 1 <= num <= 10^8
 *
 * @author   Li.zongjie
 * @date     2021/12/31
 * @version  1.0
 */
public class Z5PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        int max = (int) Math.sqrt(num);
        for (int i = 2 ; i <= max ; i++){
            if (num % i == 0){
                sum += (i + num / i);
            }
        }
        return num != 1 && sum == num;
    }

    public static void main(String[] args) {
        Z5PerfectNumber test = new Z5PerfectNumber();
        System.out.println(test.checkPerfectNumber(28));
    }
}
