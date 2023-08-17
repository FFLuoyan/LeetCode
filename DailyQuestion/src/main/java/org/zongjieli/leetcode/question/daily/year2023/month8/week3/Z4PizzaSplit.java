package org.zongjieli.leetcode.question.daily.year2023.month8.week3;

import java.util.Arrays;

/**
 * 给定一个 rows x cols 大小的矩形披萨和一个整数 k
 * 矩形包含两种字符: 'A'(表示苹果)和'.'(表示空白格子)
 * 需要切披萨 k-1 次,得到 k 块披萨并送给别人
 * 切披萨的每一刀,先要选择是向垂直还是水平方向切
 * 再在矩形的边界上选一个切的位置,将披萨一分为二
 * 如果垂直地切披萨,那么需要把左边的部分送给一个人
 * 如果水平地切,那么需要把上面的部分送给一个人
 * 在切完最后一刀后,需要把剩下来的一块送给最后一个人
 * 请返回确保每一块披萨包含至少一个苹果的切披萨方案数
 * 由于答案可能是个很大的数字,请返回它对 10^9 + 7 取余的结果
 *
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza 只包含字符 'A' 和 '.'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/17
 */
public class Z4PizzaSplit {

    public int ways(String[] pizza, int k) {
        int rl = pizza.length, cl = pizza[0].length();
        boolean[][] apples = new boolean[rl][cl];
        for (int i = 0; i < pizza.length; i++) {
            String row = pizza[i];
            boolean[] apple = apples[i];
            for (int j = 0; j < apple.length; j++) {
                apple[j] = (row.charAt(j) == 'A');
            }
        }
        int[][][] count = new int[rl][cl][k];
        for (int[][] i : count) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return (int) (ways(apples, count, 0, 0, k - 1) % 1000000007);
    }

    public long ways(boolean[][] apples, int[][][] count, int row, int column, int k) {
        if (count[row][column][k] != -1) {
            return count[row][column][k];
        }
        if (row == count.length - 1 && column == count[0].length - 1) {
            if (k > 0) {
                return count[row][column][k] = 0;
            }
            return count[row][column][k] = (apples[row][column] ? 1 : 0);
        }
        if (k == 0) {
            for (int i = row; i < apples.length; i++) {
                for (int j = column ; j < apples[0].length ; j++) {
                    if (apples[i][j]) {
                        return count[row][column][k] = 1;
                    }
                }
            }
            return count[row][column][k] = 0;
        }
        long sum = 0;
        int applePosition = row;
        boolean existApple = false;
        while (applePosition < count.length && !existApple) {
            for (int j = column ; j < count[0].length ; j++) {
                existApple |= apples[applePosition][j];
            }
            applePosition++;
        }
        if (applePosition < count.length) {
            for (int i = applePosition ; i < count.length ; i++) {
                sum += ways(apples, count, i, column, k - 1);
            }
        }
        applePosition = column;
        existApple = false;
        while (applePosition < count[0].length && !existApple) {
            for (int j = row ; j < count.length ; j++) {
                existApple |= apples[j][applePosition];
            }
            applePosition++;
        }
        if (applePosition < count[0].length) {
            for (int i = applePosition ; i < count[0].length ; i++) {
                sum += ways(apples, count, row, i, k - 1);
            }
        }
        return count[row][column][k] = (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        Z4PizzaSplit test = new Z4PizzaSplit();
        // 1
        System.out.println(test.ways(new String[]{"A..", "AA.", "..."}, 3));
    }
}
