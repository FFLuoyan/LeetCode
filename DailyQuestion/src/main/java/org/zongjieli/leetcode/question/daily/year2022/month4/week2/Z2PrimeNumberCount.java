package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

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

    private int[][] bitCount = new int[][]{
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 4, 6, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 5, 10, 10, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 6, 15, 20, 15, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 7, 21, 35, 35, 21, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 8, 28, 56, 70, 56, 28, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 9, 36, 84, 126, 126, 84, 36, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 11, 55, 165, 330, 462, 462, 330, 165, 55, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 12, 66, 220, 495, 792, 924, 792, 495, 220, 66, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1, 0, 0, 0, 0, 0, 0},
            {1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455, 105, 15, 1, 0, 0, 0, 0, 0},
            {1, 16, 120, 560, 1820, 4368, 8008, 11440, 12870, 11440, 8008, 4368, 1820, 560, 120, 16, 1, 0, 0, 0, 0},
            {1, 17, 136, 680, 2380, 6188, 12376, 19448, 24310, 24310, 19448, 12376, 6188, 2380, 680, 136, 17, 1, 0, 0, 0},
            {1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1, 0, 0},
            {1, 19, 171, 969, 3876, 11628, 27132, 50388, 75582, 92378, 92378, 75582, 50388, 27132, 11628, 3876, 969, 171, 19, 1, 0},
            {1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756, 167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1}};

    private int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
    private int[] primeReturn = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};

    public int countPrimeSetBits(int left, int right) {
        right = countPrimeSetBit(right, 0);
        left = countPrimeSetBit(left - 1, 0);
        return right -  left;
    }

    public int countPrimeSetBit(int n, int add) {
        if (n == 0) {
            return primeReturn[add];
        }
        int mb = maxBit(n);
        int full = countPrimeSetBitsFull(mb - 1, add);
        int next = countPrimeSetBit(n - (1 << (mb - 1)), add + 1);
        return full + next;
    }

    public int countPrimeSetBitsFull(int bit, int add) {
        int[] v = bitCount[bit];
        int result = 0;
        for (int p : prime) {
            if (p - add >= 0) {
                result += v[p - add];
            }
        }
        return result;
    }

    private int maxBit(int n) {
        int mb = 1;
        while ((n >>= 1) > 0) {
            mb++;
        }
        return mb;
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
