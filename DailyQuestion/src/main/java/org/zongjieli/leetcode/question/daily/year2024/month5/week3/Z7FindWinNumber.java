package org.zongjieli.leetcode.question.daily.year2024.month5.week3;

/**
 * 给定一个由不同整数组成的整数数组 arr 和一个整数 k
 * 每回合游戏都在数组的前两个元素(即 arr[0] 和 arr[1])之间进行
 * 比较 arr[0] 与 arr[1] 的大小,较大的整数将会取得这一回合的胜利并保留在位置 0
 * 较小的整数移至数组的末尾,当一个整数赢得 k 个连续回合时,游戏结束,该整数就是比赛的赢家
 * 返回赢得比赛的整数,题目数据保证游戏存在赢家
 *
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数各不相同
 * 1 <= k <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/5/21
 */
public class Z7FindWinNumber {

    public int getWinner(int[] arr, int k) {
        int max = arr[0], currentK = 0;
        for (int i = 1; i < arr.length && currentK < k; i++) {
            if (max < arr[i]) {
                max = arr[i];
                currentK = 0;
            }
            currentK++;
        }
        return max;
    }

}
