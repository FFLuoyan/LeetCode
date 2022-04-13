package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import java.util.Arrays;

/**
 * 给定两个整数 left 和 right
 * 在闭区间 [left, right] 范围内
 * 统计并返回计算置位位数为质数的整数个数
 * 计算置位位数就是二进制表示中 1 的个数
 * 例如,21 的二进制表示 10101 有 3 个计算置位
 *
 * 1 <= left <= right <= 10^6
 * 0 <= right - left <= 10^4
 *
 * @author   Li.zongjie
 * @date     2022/4/7
 * @version  1.0
 */
public class Z2PrimeNumberCount {

    private int[][] bitAdd = new int[][]{
            {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 1, 2, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 3, 3, 2, 2, 2, 2, 1, 0, 1, 2, 2, 2, 1, 0, 1, 2, 2},
            {4, 6, 5, 4, 4, 4, 3, 1, 1, 3, 4, 4, 3, 1, 1, 3, 4},
            {10, 11, 9, 8, 8, 7, 4, 2, 4, 7, 8, 7, 4, 2, 4, 7},
            {21, 20, 17, 16, 15, 11, 6, 6, 11, 15, 15, 11, 6, 6, 11},
            {41, 37, 33, 31, 26, 17, 12, 17, 26, 30, 26, 17, 12, 17},
            {78, 70, 64, 57, 43, 29, 29, 43, 56, 56, 43, 29, 29},
            {148, 134, 121, 100, 72, 58, 72, 99, 112, 99, 72, 58},
            {282, 255, 221, 172, 130, 130, 171, 211, 211, 171, 130},
            {537, 476, 393, 302, 260, 301, 382, 422, 382, 301},
            {1013, 869, 695, 562, 561, 683, 804, 804, 683},
            {1882, 1564, 1257, 1123, 1244, 1487, 1608, 1487},
            {3446, 2821, 2380, 2367, 2731, 3095, 3095},
            {6267, 5201, 4747, 5098, 5826, 6190},
            {11468, 9948, 9845, 10924, 12016},
            {21416, 19793, 20769, 22940},
            {41209, 40562, 43709},
            {81771, 84271},
            {166042}
    };

    public int countPrimeSetBits(int left, int right) {
        return countPrimeSetBit(right) -  countPrimeSetBit(left - 1);
    }

    public int countPrimeSetBit(int n) {
        int result = 0, bitCount = 19, bitCompare = 1048576, add = 0;
        while ((bitCompare >>= 1) > 0) {
            if ((n & bitCompare) > 0) {
                result += bitAdd[bitCount][add++];
            }
            bitCount--;
        }
        return result + bitAdd[0][add];
    }

    public static void main(String[] args) {
        Z2PrimeNumberCount test = new Z2PrimeNumberCount();
        // 4
        System.out.println(test.countPrimeSetBits(6, 10));
        // 117
        System.out.println(test.countPrimeSetBits(8, 200));
        // 1465
        System.out.println(test.countPrimeSetBits(289051, 294301));
    }
}
