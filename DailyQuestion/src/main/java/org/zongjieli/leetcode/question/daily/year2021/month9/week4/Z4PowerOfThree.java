package org.zongjieli.leetcode.question.daily.year2021.month9.week4;
/**
 * 给定一个整数,写一个函数来判断它是否是 3 的幂次方
 * 如果是,返回 true,否则返回 false
 * 整数 n 是 3 的幂次方需满足: 存在整数 x 使得 n == 3^x
 *
 * -2^31 <= n <= 2^31 - 1
 *
 * 进阶: 不使用循环或者递归
 *
 * @author   Li.zongjie
 * @date     2021/9/23
 * @version  1.0
 */
public class Z4PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // 3 的整数次幂肯定大于 0,求出 3 的幂的最大值 X
        // 则符合条件的所有数均为 X 的约数
        return n > 0 && 1162261467 % n == 0;
    }
}
