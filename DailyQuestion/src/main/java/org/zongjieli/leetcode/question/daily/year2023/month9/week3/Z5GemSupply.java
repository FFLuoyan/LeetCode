package org.zongjieli.leetcode.question.daily.year2023.month9.week3;

/**
 * 欢迎各位勇者来到力扣新手村,在开始试炼之前,请各位勇者先进行宝石补给
 * 每位勇者初始都拥有一些能量宝石,gem[i] 表示第 i 位勇者的宝石数量
 * 现在这些勇者们进行了一系列的赠送
 * operations[j] = [x, y] 表示在第 j 次的赠送中第 x 位勇者将自己一半的宝石(需向下取整)赠送给第 y 位勇者
 * 在完成所有的赠送后,请找到拥有最多宝石的勇者和拥有最少宝石的勇者,并返回他们二者的宝石数量之差
 * 赠送将按顺序逐步进行
 *
 * 2 <= gem.length <= 10^3
 * 0 <= gem[i] <= 10^3
 * 0 <= operations.length <= 10^4
 * operations[i].length == 2
 * 0 <= operations[i][0], operations[i][1] < gem.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/15
 */
public class Z5GemSupply {

    public int giveGem(int[] gem, int[][] operations) {
        int number, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] operation : operations) {
            number = gem[operation[0]] / 2;
            gem[operation[0]] -= number;
            gem[operation[1]] += number;
        }
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return max - min;
    }

}
