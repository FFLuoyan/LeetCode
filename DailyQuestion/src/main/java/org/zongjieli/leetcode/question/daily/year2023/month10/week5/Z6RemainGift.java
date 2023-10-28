package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

import java.util.PriorityQueue;

/**
 * 给定一个整数数组 gifts,表示各堆礼物的数量,每一秒需要执行以下操作:
 *  选择礼物数量最多的那一堆
 *  如果不止一堆都符合礼物数量最多,从中选择任一堆即可
 *  选中的那一堆留下平方根数量的礼物(向下取整)取走其他的礼物
 * 返回在 k 秒后剩下的礼物数量
 *
 * 1 <= gifts.length <= 10^3
 * 1 <= gifts[i] <= 10^9
 * 1 <= k <= 10^3
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/28
 */
public class Z6RemainGift {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> save = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long remain = 0;
        for (int gift : gifts) {
            remain += gift;
            save.add(gift);
        }
        while (k-- > 0) {
            int max = save.poll(), next = (int) Math.sqrt(max);
            remain -= (max - next);
            save.add(next);
        }
        return remain;
    }

    public static void main(String[] args) {
        Z6RemainGift test = new Z6RemainGift();
        // 4
        System.out.println(test.pickGifts(new int[]{1, 2, 3}, 1));
    }

}
