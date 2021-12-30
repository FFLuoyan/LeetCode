package org.zongjieli.leetcode.question.daily.year2021.month12.week5;

import java.util.TreeMap;

/**
 * Alice 手中有一把牌,她想要重新排列这些牌,分成若干组
 * 使每一组的牌数都是 groupSize,并且由 groupSize 张连续的牌组成
 * 给定一个整数数组 hand 其中 hand[i] 是第 i 张牌,和一个整数 groupSize
 * 如果她可能重新排列这些牌,返回 true,否则返回 false
 *
 * 1 <= hand.length <= 10^4
 * 0 <= hand[i] <= 10^9
 * 1 <= groupSize <= hand.length
 *
 * @author   Li.zongjie
 * @date     2021/12/30
 * @version  1.0
 */
public class Z4StraightDraws {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> save = new TreeMap<>();
        for (int i : hand) {
            save.merge(i, 1, Integer::sum);
        }
        while (!save.isEmpty()){
            Integer start = save.firstKey();
            for (int i = start; i < start + groupSize ; i++){
                Integer count = save.get(i);
                if (count == null){
                    return false;
                } else if (count == 1){
                    save.remove(i);
                } else {
                    save.put(i, count - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z4StraightDraws test = new Z4StraightDraws();
        // true
        System.out.println(test.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
}
