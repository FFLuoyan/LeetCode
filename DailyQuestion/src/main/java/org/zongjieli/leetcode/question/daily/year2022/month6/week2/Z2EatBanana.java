package org.zongjieli.leetcode.question.daily.year2022.month6.week2;
/**
 * 珂珂喜欢吃香蕉,这里有 n 堆香蕉
 * 第 i 堆中有 piles[i] 根香蕉
 * 警卫已经离开了,将在 h 小时后回来
 *
 * 珂珂可以决定她吃香蕉的速度 k (单位: 根/小时)
 * 每个小时,她将会选择一堆香蕉,从中吃掉 k 根
 * 如果这堆香蕉少于 k 根,她将吃掉这堆的所有香蕉,然后这一小时内不会再吃更多的香蕉
 *
 * 珂珂喜欢慢慢吃,但仍然想在警卫回来前吃掉所有的香蕉
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k (k 为整数)
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author   Li.zongjie
 * @date     2022/6/7
 * @version  1.0
 */
public class Z2EatBanana {

    public int minEatingSpeed(int[] piles, int h) {
        long all = 0;
        for (int pile : piles) {
            all += pile;
        }
        int min = (int) ((all + h - 1) / h);
        int max = (int) ((all + h - piles.length) / (h - piles.length + 1));
        while (min < max) {
            int middle = (min + max) / 2;
            int count = 0;
            for (int pile : piles) {
                count += (pile + middle - 1) / middle;
            }
            if (count <= h) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Z2EatBanana test = new Z2EatBanana();
        // 30
        System.out.println(test.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        //
        System.out.println(test.minEatingSpeed(new int[]{312884470}, 968709470));
    }
}
