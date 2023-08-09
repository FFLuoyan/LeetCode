package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

/**
 * 给定一个整数 n,请计算并返回该整数各位数字之积与各位数字之和的差
 *
 * 1 <= n <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/9
 */
public class Z3DiffProductSum {

    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int remain = n % 10;
            n /= 10;
            product *= remain;
            sum += remain;
        }
        return product - sum;
    }

}
