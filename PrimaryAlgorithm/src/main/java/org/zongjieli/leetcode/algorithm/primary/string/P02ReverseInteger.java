package org.zongjieli.leetcode.algorithm.primary.string;
/**
 * 一个 32 位的有符号整数 x,返回将 x 中的数字部分反转后的结果
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1],就返回 0
 * 假设环境不允许存储 64 位整数(有符号或无符号)
 *
 * -2^31 <= x <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P02ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x > 9 || x < -9){
            int remain = x % 10;
            result = 10 * result + remain;
            x /= 10;
        }
        int max = Integer.MAX_VALUE / 10;
        if (result > max || (result == max && x > Integer.MAX_VALUE % 10)){
            return 0;
        }
        int min = Integer.MIN_VALUE / 10;
        if (result < min || (result == min && x < Integer.MIN_VALUE % 10)){
            return 0;
        }
        return 10 * result + x;
    }
}
