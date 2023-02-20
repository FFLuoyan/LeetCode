package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 给定一个整数数组 ranks 和一个字符数组 suit
 * 有 5 张扑克牌,第 i 张牌大小为 ranks[i],花色为 suits[i]
 * 下述是从好到坏可能持有的手牌类型:
 *  "Flush": 同花,五张相同花色的扑克牌
 *  "Three of a Kind": 三条,有 3 张大小相同的扑克牌
 *  "Pair": 对子,两张大小一样的扑克牌
 *  "High Card": 高牌,五张大小互不相同的扑克牌
 * 请返回一个字符串,表示给定的 5 张牌中,能组成的最好手牌类型
 * 注意: 返回的字符串大小写需与题目描述相同
 *
 * ranks.length == suits.length == 5
 * 1 <= ranks[i] <= 13
 * 'a' <= suits[i] <= 'd'
 * 任意两张扑克牌不会同时有相同的大小和花色
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/20
 */
public class Z1Poker {

    public String bestHand(int[] ranks, char[] suits) {
        char sameSuit = suits[0];
        int i = 1;
        for (; i < suits.length; i++) {
            if (suits[i] != sameSuit) {
                break;
            }
        }
        if (i == suits.length) {
            return "Flush";
        }
        int[] count = new int[14];
        for (int rank : ranks) {
            count[rank]++;
        }
        int max = 0;
        for (int j : count) {
            max = Math.max(max, j);
        }
        if (max >= 3) {
            return "Three of a Kind";
        }
        if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }

}
