package org.zongjieli.leetcode.competion.doubleweekly.order98;

/**
 * 给定一个整数 num,Danny 会偷偷将 0 到 9 中的一个数字替换成另一个数字
 * 请返回将 num 中恰好一个数字进行替换后,得到的最大值和最小值的差为多少
 * 注意:
 *  当 Danny 将一个数字 d1 替换成另一个数字 d2 时,Danny 需要将 nums 中所有 d1 都替换成 d2
 *  Danny 可以将一个数字替换成它自己,也就是说 num 可以不变
 *  Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值
 *  替换后得到的数字可以包含前导 0
 *
 * 1 <= num <= 10^8
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/18
 */
public class O98N1MaxDiff {

    public int minMaxDifference(int num) {
        int max = 0, min = Integer.MAX_VALUE;
        for (char i = '0' ; i <= '9' ; i++) {
            max = Math.max(max, Integer.parseInt(String.valueOf(num).replaceAll("" + i, "9")));
            min = Math.min(min, Integer.parseInt(String.valueOf(num).replaceAll("" + i, "0")));
        }
        return max - min;
    }

}
