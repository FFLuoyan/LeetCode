package org.zongjieli.leetcode.question.daily.year2023.month9.week5;

/**
 * 假设有一个很长的花坛,一部分地块种植了花,另一部分却没有
 * 可是,花不能种植在相邻的地块上,它们会争夺水源,两者都会死去
 * 给定一个整数数组 flowerbed 表示花坛,由若干 0 和 1 组成
 * 其中 0 表示没种植花,1 表示种植了花,另有一个数 n
 * 能否在不打破种植规则的情况下种入 n 朵花
 * 能则返回 true,不能则返回 false
 *
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/29
 */
public class Z5MaxFlower {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = 0, lastIndex = -2, currentIndex = 0, length = flowerbed.length;
        while (currentIndex < length) {
            if (flowerbed[currentIndex] == 1) {
                if ((result += (currentIndex - lastIndex - 2) / 2) >= n) {
                    return true;
                }
                lastIndex = currentIndex;
            }
            currentIndex++;
        }
        return result + (currentIndex - lastIndex - 1) / 2 >= n;
    }

}
