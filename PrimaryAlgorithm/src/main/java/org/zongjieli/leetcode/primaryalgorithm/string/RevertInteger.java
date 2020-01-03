package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: RevertInteger
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/30
 * @Version: 1.0
 **/
public class RevertInteger {
    public static int revertInteger(int x) {
        if (x == 0) {
            return 0;
        }
        long changeNumber = 0L;
        while (x != 0) {
            changeNumber = changeNumber * 10 + x % 10;
            x /= 10;
        }
        if (changeNumber > Integer.MAX_VALUE || changeNumber < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) changeNumber;
    }

    public static void main(String[] args) {
        System.out.println(-3851 % 10);
        System.out.println(revertInteger(-1534236469));
    }
}
