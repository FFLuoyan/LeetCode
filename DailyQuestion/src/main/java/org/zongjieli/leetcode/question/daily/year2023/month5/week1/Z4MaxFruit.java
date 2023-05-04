package org.zongjieli.leetcode.question.daily.year2023.month5.week1;

/**
 * 在一个无限的 x 坐标轴上,有许多水果分布在其中某些位置
 * 给定一个二维整数数组 fruits
 * 其中 fruits[i] = [positionI, amountI] 表示共有 amountI 个水果放置在 positionI 上
 * fruits 已经按 positionI 升序排列,每个 positionI 互不相同
 * 另给定两个整数 startPos 和 k
 * 最初,位于 startPos,从任何位置,你可以选择向左或者向右走
 * 在 x 轴上每移动一个单位,就记作一步,总共可以走最多 k 步
 * 每达到一个位置,都会摘掉全部的水果,水果也将从该位置消失(不会再生)
 * 返回可以摘到水果的最大总数
 *
 * 1 <= fruits.length <= 10^5
 * fruits[i].length == 2
 * 0 <= startPos, positionI <= 2 * 10^5
 * 对于任意 i > 0,position(i - 1) < position(i) 均成立(下标从 0 开始计数)
 * 1 <= amountI <= 10^4
 * 0 <= k <= 2 * 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/5/4
 */
public class Z4MaxFruit {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxPosition = fruits[fruits.length - 1][0];
        int[] fruitArray = new int[maxPosition + 1];
        for (int[] fruit : fruits) {
            fruitArray[fruit[0]] = fruit[1];
        }
        int startPosition = Math.max(0, startPos - k);
        int left = startPosition, right = startPosition - 1, sum = 0, result = 0;
        while (startPosition <= startPos && right < maxPosition) {
            int nextRight = Math.max(2 * startPosition + k - startPos, startPos + (k - (startPos - startPosition)) / 2);
            nextRight = Math.min(maxPosition, nextRight);
            for (int i = left ; i < startPosition ; i++) {
                sum -= fruitArray[i];
            }
            for (int i = right + 1 ; i <= nextRight; i++) {
                sum += fruitArray[i];
            }
            result = Math.max(sum, result);
            right = nextRight;
            left = startPosition++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4MaxFruit test = new Z4MaxFruit();
        // 9
        System.out.println(test.maxTotalFruits(new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4));
        // 10000
        System.out.println(test.maxTotalFruits(new int[][]{{0, 10000}}, 20000, 20000));
        // 71
        System.out.println(test.maxTotalFruits(new int[][]{{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}}, 21, 30));
    }

}
