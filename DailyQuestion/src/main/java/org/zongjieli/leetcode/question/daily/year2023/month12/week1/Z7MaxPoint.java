package org.zongjieli.leetcode.question.daily.year2023.month12.week1;

/**
 * 几张卡牌排成一行,每张卡牌都有一个对应的点数,点数由整数数组 cardPoints 给出
 * 每次行动可以从行的开头或者末尾拿一张卡牌,最终必须正好拿 k 张卡牌
 * 点数就是拿到手中的所有卡牌的点数之和
 * 给定一个整数数组 cardPoints 和整数 k,请返回可以获得的最大点数
 *
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/4
 */
public class Z7MaxPoint {

    public int maxScore(int[] cardPoints, int k) {
        int result, current = 0;
        for (int i = 0; i < k; i++) {
            current += cardPoints[i];
        }
        result = current;
        for (int i = 1; i <= k; i++) {
            current += cardPoints[cardPoints.length - i];
            current -= cardPoints[k - i];
            result = Math.max(result, current);
        }
        return result;
    }

}
