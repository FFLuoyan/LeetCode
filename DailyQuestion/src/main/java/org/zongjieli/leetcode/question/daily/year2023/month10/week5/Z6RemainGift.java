package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int gift : gifts) {
            count.merge(gift, 1, Integer::sum);
        }
        while (k-- > 0) {
            Map.Entry<Integer, Integer> exist = count.pollLastEntry();
            int key = exist.getKey(), value = exist.getValue();
            if (value > 1) {
                count.put(key, value - 1);
            }
            count.merge((int) Math.sqrt(key), 1, Integer::sum);
        }
        long result = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            result += (long) entry.getKey() * entry.getValue();
        }
        return result;
    }

}
