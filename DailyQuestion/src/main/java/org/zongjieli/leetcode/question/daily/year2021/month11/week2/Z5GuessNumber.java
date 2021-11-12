package org.zongjieli.leetcode.question.daily.year2021.month11.week2;

import java.util.Arrays;

/**
 * 一个猜数游戏的游戏规则如下:
 *
 *  我从 1 到 n 之间选择一个数字
 *  你来猜我选了哪个数字
 *  如果你猜到正确的数字,就会赢得游戏
 *  如果你猜错了,那么我会告诉你,我选的数字比你的更大或者更小,并且你需要继续猜数
 *  每当你猜了数字 x 并且猜错了的时候,你需要支付金额为 x 的现金
 *   如果你花光了钱,就会输掉游戏
 *  给你一个特定的数字 n,返回能够确保你获胜的最小现金数,不管我选择那个数字
 *
 *  1 <= n <= 200
 *
 * @author   Li.zongjie
 * @date     2021/11/12
 * @version  1.0
 */
public class Z5GuessNumber {

    private int[][] save = new int[201][201];

    public int getMoneyAmount(int n) {
        for (int[] ints : save) {
            Arrays.fill(ints, -1);
        }
        return getMoneyAmountMin(1, n);
    }

    public int getMoneyAmountMin(int start, int end) {
        if (end - start < 1){
            return 0;
        }

        if (save[start][end] != -1){
            return save[start][end];
        }

        int middle = (end + start) / 2;
        int left = getMoneyAmountMin(start, middle - 1);
        int right = getMoneyAmountMin(middle + 1, end);
        int result = Math.max(left,right) + middle;

        while (left < right){
            middle++;
            left = getMoneyAmountMin(start, middle - 1);
            right = getMoneyAmountMin(middle + 1, end);
            result = Math.min(result, Math.max(left, right) + middle);
        }
        save[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        Z5GuessNumber test = new Z5GuessNumber();

        for (int i = 0 ; i < 200 ; i++){
            System.out.println("I-" + i + ": " + test.getMoneyAmount(i));
        }
    }

}
