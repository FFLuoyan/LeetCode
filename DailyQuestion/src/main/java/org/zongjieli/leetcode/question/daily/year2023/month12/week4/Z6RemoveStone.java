package org.zongjieli.leetcode.question.daily.year2023.month12.week4;

/**
 * 给定一个整数数组 piles,数组下标从 0 开始,其中 piles[i] 表示第 i 堆石子中的石子数量
 * 另给定一个整数 k,请执行下述操作恰好 k 次:
 *  选出任一石子堆 piles[i],并从中移除 floor(piles[i] / 2) 颗石子
 * 注意: 可以对同一堆石子多次执行此操作
 * 返回执行 k 次操作后,剩下石子的最小总数
 * floor(x) 为小于或等于 x 的最大整数(对 x 向下取整)
 *
 * 1 <= piles.length <= 10^5
 * 1 <= piles[i] <= 10^4
 * 1 <= k <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/25
 */
public class Z6RemoveStone {

    public int minStoneSum(int[] piles, int k) {
        int min = 1, max = 10000, middle, sum = 0;
        int[] result = new int[2];
        while (min < max) {
            middle = (max + min) / 2;
            result = can(piles, middle);
            if (result[0] <= k) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        for (int pile : piles) {
            sum += pile;
        }
        result = can(piles, min);
        return sum - (k - result[0]) * (min / 2) - result[1];
    }

    public int[] can(int[] piles, int max) {
        // count, sub
        int[] result = new int[2];
        for (int pile : piles) {
            while (pile > max) {
                int sub = pile / 2;
                pile -= sub;
                result[0]++;
                result[1] += sub;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z6RemoveStone test = new Z6RemoveStone();
        // 12
        System.out.println(test.minStoneSum(new int[]{5, 4, 9}, 2));
    }
}
