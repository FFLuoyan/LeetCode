package org.zongjieli.leetcode.question.daily.year2021.month5.week2;
/**
 * 给定一个 32 位的有符号整数 x
 * 返回将 x 中的数字部分反转后的结果
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,2^31 − 1],就返回 0
 * 假设环境不允许存储 64 位整数(有符号或无符号)
 *
 * -2^31 <= x <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/5/3
 * @version  1.0
 */
public class ReverseInteger {
    public int reverse(int x) {
        long l = 0;
        while (x != 0){
            l = 10 * l + (x % 10);
            x /= 10;
        }
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE){
            return 0;
        }
        return (int) l;
    }
}
