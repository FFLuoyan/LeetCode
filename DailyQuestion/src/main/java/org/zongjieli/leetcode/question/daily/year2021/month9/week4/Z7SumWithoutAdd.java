package org.zongjieli.leetcode.question.daily.year2021.month9.week4;
/**
 * 给定两个整数 a 和 b,不使用运算符 "+" 和 "-" ​​​​​​计算并返回两整数之和
 *
 * -1000 <= a, b <= 1000
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class Z7SumWithoutAdd {
    public int getSum(int a, int b) {
        int temp;
        while ((temp = a & b) != 0){
            b = a ^ b;
            a = temp << 1;
        }
        return a ^ b;
    }
}
