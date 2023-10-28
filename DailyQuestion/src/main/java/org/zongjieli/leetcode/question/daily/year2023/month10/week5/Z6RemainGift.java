package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

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
        int min = 1, max = 0, middle;
        for (int gift : gifts) {
            max = Math.max(gift, max);
        }
        long[] result = getResult(gifts, 1);
        if (result[1] <= k) {
            return result[0];
        }
        while (min < max) {
            middle = (min + max) / 2;
            result = getResult(gifts, middle);
            if (result[1] == k) {
                return result[0];
            } else if (result[1] > k) {
                min = middle + 1;
            } else {
                max = Math.min(middle, (int) result[2] + 1);
            }
        }
        result = getResult(gifts, max);
        return result[0] - (k - result[1]) * ((result[2] - (long) Math.sqrt(result[2])));
    }

    public long[] getResult(int[] gifts, int remainMax) {
        // result, count, max
        long[] result = new long[3];
        for (int gift : gifts) {
            while (gift > remainMax) {
                gift = (int) Math.sqrt(gift);
                result[1]++;
            }
            result[0] += gift;
            result[2] = Math.max(gift, result[2]);
        }
        return result;
    }

    public static void main(String[] args) {
        Z6RemainGift test = new Z6RemainGift();
        // 4
        System.out.println(test.pickGifts(new int[]{1, 2, 3}, 1));
        // 32
        System.out.println(test.pickGifts(new int[]{56, 41, 27, 71, 62, 57, 67, 34, 8, 71, 2, 12, 52, 1, 64, 43, 32, 42, 9, 25, 73, 29, 31}, 52));
    }

}
